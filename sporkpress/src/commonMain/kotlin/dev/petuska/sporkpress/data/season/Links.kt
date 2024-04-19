package dev.petuska.sporkpress.data.season
import dev.petuska.sporkpress.data.Link
import dev.petuska.sporkpress.data.Cury
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
  var wpPostType: List<Link>
)
