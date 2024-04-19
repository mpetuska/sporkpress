package dev.petuska.sporkpress.data.calendar

import dev.petuska.sporkpress.data.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
  @SerialName("comment_count")
  var commentCount: String,
  @SerialName("comment_status")
  var commentStatus: String,
  @SerialName("filter")
  var filter: String,
  @SerialName("guid")
  var guid: String,
  @SerialName("ID")
  var id: Int,
  @SerialName("menu_order")
  var menuOrder: Int,
  @SerialName("ping_status")
  var pingStatus: String,
  @SerialName("pinged")
  var pinged: String,
  @SerialName("post_author")
  var postAuthor: String,
  @SerialName("post_content")
  var postContent: String,
  @SerialName("post_content_filtered")
  var postContentFiltered: String,
  @SerialName("post_date")
  var postDate: Instant,
  @SerialName("post_date_gmt")
  var postDateGmt: Instant,
  @SerialName("post_excerpt")
  var postExcerpt: String,
  @SerialName("post_mime_type")
  var postMimeType: String,
  @SerialName("post_modified")
  var postModified: Instant,
  @SerialName("post_modified_gmt")
  var postModifiedGmt: Instant,
  @SerialName("post_name")
  var postName: String,
  @SerialName("post_parent")
  var postParent: Int,
  @SerialName("post_password")
  var postPassword: String,
  @SerialName("post_status")
  var postStatus: String,
  @SerialName("post_title")
  var postTitle: String,
  @SerialName("post_type")
  var postType: String,
  @SerialName("to_ping")
  var toPing: String,
)
