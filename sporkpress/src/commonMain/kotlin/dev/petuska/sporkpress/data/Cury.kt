package dev.petuska.sporkpress.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cury(
  @SerialName("href")
  var href: String,
  @SerialName("name")
  var name: String,
  @SerialName("templated")
  var templated: Boolean
)
