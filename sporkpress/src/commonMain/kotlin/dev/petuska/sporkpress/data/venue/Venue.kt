package dev.petuska.sporkpress.data.venue


import dev.petuska.sporkpress.data.VenueId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Venue(
  @SerialName("count")
  var count: Int,
  @SerialName("description")
  var description: String,
  @SerialName("id")
  var id: VenueId,
  @SerialName("link")
  var link: String,
  @SerialName("_links")
  var links: Links,
  @SerialName("meta")
  var meta: List<JsonElement>,
  @SerialName("name")
  var name: String,
  @SerialName("parent")
  var parent: Int,
  @SerialName("slug")
  var slug: String,
  @SerialName("taxonomy")
  var taxonomy: String
)
