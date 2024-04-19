package dev.petuska.sporkpress.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AstPageBackgroundMeta(
  @SerialName("desktop")
  var desktop: Desktop,
  @SerialName("mobile")
  var mobile: Mobile,
  @SerialName("tablet")
  var tablet: Tablet
)
