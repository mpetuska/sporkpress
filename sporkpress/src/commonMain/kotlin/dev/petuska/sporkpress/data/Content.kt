package dev.petuska.sporkpress.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Content(
  @SerialName("protected")
  var protected: Boolean,
  @SerialName("rendered")
  var rendered: String
)
