package dev.petuska.sporkpress.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UagbFeaturedImageSrc(
  @SerialName("full")
  var full: Boolean,
  @SerialName("large")
  var large: Boolean,
  @SerialName("medium")
  var medium: Boolean,
  @SerialName("medium_large")
  var mediumLarge: Boolean,
  @SerialName("sportspress-crop-medium")
  var sportspressCropMedium: Boolean,
  @SerialName("sportspress-fit-icon")
  var sportspressFitIcon: Boolean,
  @SerialName("sportspress-fit-medium")
  var sportspressFitMedium: Boolean,
  @SerialName("sportspress-fit-mini")
  var sportspressFitMini: Boolean,
  @SerialName("thumbnail")
  var thumbnail: Boolean,
  @SerialName("1536x1536")
  var x1536: Boolean,
  @SerialName("2048x2048")
  var x2048: Boolean
)
