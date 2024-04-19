package dev.petuska.sporkpress.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EmbeddableLink(
  @SerialName("embeddable")
  var embeddable: Boolean,
  @SerialName("href")
  var href: String
)
