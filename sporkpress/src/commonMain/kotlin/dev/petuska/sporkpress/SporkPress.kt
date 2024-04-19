@file:Suppress("LongParameterList")

package dev.petuska.sporkpress

import dev.petuska.sporkpress.data.EventId
import dev.petuska.sporkpress.data.LeagueId
import dev.petuska.sporkpress.data.SeasonId
import dev.petuska.sporkpress.data.VenueId
import dev.petuska.sporkpress.data.calendar.Calendar
import dev.petuska.sporkpress.data.event.Event
import dev.petuska.sporkpress.data.league.League
import dev.petuska.sporkpress.data.season.Season
import dev.petuska.sporkpress.data.team.Team
import dev.petuska.sporkpress.data.venue.Venue
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.Instant

@OptIn(ExperimentalStdlibApi::class)
interface SporkPress : AutoCloseable {

  /**
   * List calendars.
   * @param before limit response to posts published before a given ISO8601 compliant date.
   * @param after limit response to posts published after a given ISO8601 compliant date.
   * @param seasons limit result set to items with specific terms assigned in the seasons taxonomy.
   * @param limit maximum number of items to be returned in result set.
   */
  fun listCalendars(
    before: Instant? = null,
    after: Instant? = null,
    seasons: Iterable<SeasonId>? = null,
    limit: UInt = 10u,
  ): Flow<Calendar>

  /**
   * List seasons.
   * @param limit maximum number of items to be returned in result set.
   */
  fun listSeasons(
    limit: UInt = 10u,
  ): Flow<Season>

  /**
   * List teams.
   * @param before limit response to posts published before a given ISO8601 compliant date.
   * @param after limit response to posts published after a given ISO8601 compliant date.
   * @param seasons limit result set to items with specific terms assigned in the seasons taxonomy.
   * @param limit maximum number of items to be returned in result set.
   */
  fun listTeams(
    before: Instant? = null,
    after: Instant? = null,
    seasons: Iterable<SeasonId>? = null,
    limit: UInt = 10u,
  ): Flow<Team>

  /**
   * List events.
   * @param before limit response to posts published before a given ISO8601 compliant date.
   * @param after limit response to posts published after a given ISO8601 compliant date.
   * @param include limit result set to specific IDs.
   * @param exclude ensure result set excludes specific IDs.
   * @param seasons limit result set to items with specific terms assigned in the seasons taxonomy.
   * @param leagues limit result set to item…n the leagues taxonomy.
   * @param limit maximum number of items to be returned in result set.
   */
  fun listEvents(
    before: Instant? = null,
    after: Instant? = null,
    include: Iterable<EventId>? = null,
    exclude: Iterable<EventId>? = null,
    seasons: Iterable<SeasonId>? = null,
    leagues: Iterable<LeagueId>? = null,
    limit: UInt = 10u,
  ): Flow<Event>

  /**
   * List leagues.
   * @param include limit result set to specific IDs.
   * @param exclude ensure result set excludes specific IDs.
   * @param limit maximum number of items to be returned in result set.
   */
  fun listLeagues(
    include: Iterable<LeagueId>? = null,
    exclude: Iterable<LeagueId>? = null,
    limit: UInt = 10u,
  ): Flow<League>

  /**
   * Lists venues.
   * @param include limit result set to specific IDs.
   * @param exclude ensure result set excludes specific IDs.
   * @param hideEmpty whether to hide terms not assigned to any posts.
   * @param limit maximum number of items to be returned in result set.
   */
  fun listVenues(
    include: Iterable<VenueId>? = null,
    exclude: Iterable<VenueId>? = null,
    hideEmpty: Boolean? = null,
    limit: UInt = 100u,
  ): Flow<Venue>

  companion object {
    /**
     * Build a [SporkPress] instance from a preconfigured [HttpClient].
     * It is recommended to use [SporkPress.login] builder for default configuration.
     * At the bare minimum, the client is expected to have default request
     * configured with base API URL & [ContentType.Application.Json] header.
     */
    operator fun invoke(client: HttpClient): SporkPress = buildClient(client)

    /**
     * @param apiUrl SportsPress API url
     */
    fun login(
      apiUrl: String,
    ): SporkPress {
      val url = apiUrl.removeSuffix("/")
      val client = HttpClient {
        expectSuccess = true
        install(DefaultRequest) {
          contentType(ContentType.Application.Json)
          url("$url/")
        }
        install(ContentNegotiation) {
          json()
        }
      }
      return SporkPress(client)
    }
  }
}

internal expect fun buildClient(client: HttpClient): SporkPress

internal expect val Dispatchers.IO: CoroutineDispatcher
