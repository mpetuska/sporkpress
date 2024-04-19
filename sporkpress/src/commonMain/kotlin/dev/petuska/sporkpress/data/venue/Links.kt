package dev.petuska.sporkpress.data.venue


import dev.petuska.sporkpress.data.Cury
import dev.petuska.sporkpress.data.Link
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
  @SerialName("about")
  var about: List<Link>,
  @SerialName("collection")
  var collection: List<Link>,
  @SerialName("curies")
  var curies: List<Cury>,
  @SerialName("self")
  var self: List<Link>,
  @SerialName("wp:post_type")
  var wpPostType: List<Link>,
)
