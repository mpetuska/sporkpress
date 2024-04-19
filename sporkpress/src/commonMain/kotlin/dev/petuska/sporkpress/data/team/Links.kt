package dev.petuska.sporkpress.data.team


import dev.petuska.sporkpress.data.EmbeddableLink
import dev.petuska.sporkpress.data.Link
import dev.petuska.sporkpress.data.Cury
import dev.petuska.sporkpress.data.WpTerm
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("about")
  var about: List<Link>,
    @SerialName("author")
  var author: List<EmbeddableLink>,
    @SerialName("collection")
  var collection: List<Link>,
    @SerialName("curies")
  var curies: List<Cury>,
    @SerialName("self")
  var self: List<Link>,
    @SerialName("wp:attachment")
  var wpAttachment: List<Link>,
    @SerialName("wp:term")
  var wpTerm: List<WpTerm>,
)
