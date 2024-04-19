package dev.petuska.sporkpress.data.calendar

import dev.petuska.sporkpress.data.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Calendar(
  @SerialName("author")
  var author: UInt,
  @SerialName("content")
  var content: Content,
  @SerialName("data")
  var data: List<Data>,
  @SerialName("date")
  var date: Instant,
  @SerialName("date_gmt")
  var dateGmt: Instant,
  @SerialName("featured_media")
  var featuredMedia: UInt,
  @SerialName("format")
  var format: String,
  @SerialName("guid")
  var guid: Rendered,
  @SerialName("id")
  var id: CalendarId,
  @SerialName("leagues")
  var leagues: List<LeagueId>,
  @SerialName("link")
  var link: String,
  @SerialName("_links")
  var links: Links,
  @SerialName("meta")
  var meta: Meta,
  @SerialName("modified")
  var modified: Instant,
  @SerialName("modified_gmt")
  var modifiedGmt: Instant,
  @SerialName("seasons")
  var seasons: List<SeasonId>,
  @SerialName("slug")
  var slug: String,
  @SerialName("status")
  var status: String,
  @SerialName("template")
  var template: String,
  @SerialName("title")
  var title: Rendered,
  @SerialName("type")
  var type: String,
  @SerialName("uagb_author_info")
  var uagbAuthorInfo: UagbAuthorInfo,
  @SerialName("uagb_comment_info")
  var uagbCommentInfo: UInt,
  @SerialName("uagb_excerpt")
  var uagbExcerpt: JsonElement?,
  @SerialName("uagb_featured_image_src")
  var uagbFeaturedImageSrc: UagbFeaturedImageSrc,
  @SerialName("venues")
  var venues: List<VenueId>
)
