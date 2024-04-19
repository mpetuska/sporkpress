package dev.petuska.sporkpress.data.league


import dev.petuska.sporkpress.data.LeagueId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class League(
  @SerialName("count")
  var count: Int,
  @SerialName("description")
  var description: String,
  @SerialName("id")
  var id: LeagueId,
  @SerialName("link")
  var link: String,
  @SerialName("_links")
  var links: Links,
  @SerialName("meta")
  var meta: List<JsonElement>,
  @SerialName("name")
  var name: String,
  @SerialName("parent")
  var parent: LeagueId,
  @SerialName("slug")
  var slug: String,
  @SerialName("taxonomy")
  var taxonomy: String
)
