package dev.petuska.sporkpress.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UagbAuthorInfo(
  @SerialName("author_link")
  var authorLink: String,
  @SerialName("display_name")
  var displayName: String
)
