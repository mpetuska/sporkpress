package dev.petuska.sporkpress.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rendered(
  @SerialName("rendered")
  var rendered: String
)
