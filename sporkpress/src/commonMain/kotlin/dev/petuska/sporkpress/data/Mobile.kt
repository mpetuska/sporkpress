package dev.petuska.sporkpress.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Mobile(
  @SerialName("background-attachment")
  var backgroundAttachment: String,
  @SerialName("background-color")
  var backgroundColor: String,
  @SerialName("background-image")
  var backgroundImage: String,
  @SerialName("background-media")
  var backgroundMedia: String,
  @SerialName("background-position")
  var backgroundPosition: String,
  @SerialName("background-repeat")
  var backgroundRepeat: String,
  @SerialName("background-size")
  var backgroundSize: String,
  @SerialName("background-type")
  var backgroundType: String,
  @SerialName("overlay-color")
  var overlayColor: String,
  @SerialName("overlay-gradient")
  var overlayGradient: String,
  @SerialName("overlay-type")
  var overlayType: String
)
