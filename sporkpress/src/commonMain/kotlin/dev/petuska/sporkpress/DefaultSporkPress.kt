package dev.petuska.sporkpress

import dev.petuska.sporkpress.data.*
import dev.petuska.sporkpress.data.calendar.Calendar
import dev.petuska.sporkpress.data.event.Event
import dev.petuska.sporkpress.data.league.League
import dev.petuska.sporkpress.data.season.Season
import dev.petuska.sporkpress.data.team.Team
import dev.petuska.sporkpress.data.venue.Venue
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

internal open class DefaultSporkPress(
  private val client: HttpClient,
  private val json: Json = Json,
) : SporkPress {
  override fun close() {
    client.close()
  }

  override fun listSeasons(
    limit: UInt,
  ): Flow<Season> = paginate {
    url("seasons")
    parameter("per_page", limit)
  }

  override fun listCalendars(
    before: Instant?,
    after: Instant?,
    seasons: Iterable<SeasonId>?,
    limit: UInt,
  ): Flow<Calendar> = paginate {
    url("calendars")
    parameter("per_page", limit)
    parameter("before", before)
    parameter("after", after)
    parameter("seasons", seasons)
  }

  override fun listTeams(
    before: Instant?,
    after: Instant?,
    seasons: Iterable<SeasonId>?,
    limit: UInt,
  ): Flow<Team> = paginate {
    url("teams")
    parameter("per_page", limit)
    parameter("before", before)
    parameter("after", after)
    parameter("seasons", seasons)
  }

  override fun listLeagues(
    include: Iterable<LeagueId>?,
    exclude: Iterable<LeagueId>?,
    limit: UInt,
  ): Flow<League> = paginate {
    url("leagues")
    parameter("per_page", limit)
    parameter("include", include)
    parameter("exclude", exclude)
  }

  override fun listVenues(
    include: Iterable<VenueId>?,
    exclude: Iterable<LeagueId>?,
    hideEmpty: Boolean?,
    limit: UInt,
  ): Flow<Venue> = paginate {
    url("venues")
    parameter("per_page", limit)
    parameter("include", include)
    parameter("exclude", exclude)
    parameter("hide_empty", hideEmpty)
  }

  override fun listEvents(
    before: Instant?,
    after: Instant?,
    include: Iterable<EventId>?,
    exclude: Iterable<EventId>?,
    seasons: Iterable<SeasonId>?,
    leagues: Iterable<LeagueId>?,
    limit: UInt,
  ): Flow<Event> = paginate {
    url("events")
    parameter("per_page", limit)
    parameter("before", before)
    parameter("after", after)
    parameter("include", include)
    parameter("exclude", exclude)
    parameter("seasons", seasons)
    parameter("leagues", leagues)
  }

  protected open suspend fun <T> FlowCollector<T>.emitItems(
    deserializer: KSerializer<T>,
    response: HttpResponse
  ) {
    json.decodeFromString(ListSerializer(deserializer), response.bodyAsText()).forEach { emit(it) }
  }

  private suspend inline fun <reified T> FlowCollector<T>.emitItems(response: HttpResponse) {
    emitItems(serializer<T>(), response)
  }

  private fun HttpRequestBuilder.parameter(name: String, values: Iterable<ID>?) {
    values?.joinToString(separator = ",")?.let { parameter(name, it) }
  }

  private inline fun <reified T> paginate(
    crossinline builder: HttpRequestBuilder.() -> Unit,
  ): Flow<T> = flow<T> {
    var page = 0
    while (true) {
      val totalPages = client.prepareGet {
        builder()
        parameter("page", ++page)
      }.execute {
        emitItems(it)
        it.headers["x-wp-totalpages"]?.toInt() ?: 0
      }
      if (page >= totalPages) break
    }
  }.flowOn(Dispatchers.IO)
}
