package dev.petuska.sporkpress.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Link(
  @SerialName("href")
  var href: String
)
