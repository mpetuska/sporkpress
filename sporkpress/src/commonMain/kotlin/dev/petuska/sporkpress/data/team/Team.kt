package dev.petuska.sporkpress.data.team


import dev.petuska.sporkpress.data.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Team(
  @SerialName("abbreviation")
  var abbreviation: String,
  @SerialName("author")
  var author: Int,
  @SerialName("content")
  var content: Content,
  @SerialName("date")
  var date: Instant,
  @SerialName("date_gmt")
  var dateGmt: Instant,
  @SerialName("events")
  var events: List<EventId>,
  @SerialName("excerpt")
  var excerpt: Content,
  @SerialName("featured_media")
  var featuredMedia: Int,
  @SerialName("guid")
  var guid: Rendered,
  @SerialName("id")
  var id: TeamId,
  @SerialName("leagues")
  var leagues: List<LeagueId>,
  @SerialName("link")
  var link: String,
  @SerialName("_links")
  var links: Links,
  @SerialName("lists")
  var lists: List<JsonElement>,
  @SerialName("menu_order")
  var menuOrder: Int,
  @SerialName("meta")
  var meta: Meta,
  @SerialName("modified")
  var modified: Instant,
  @SerialName("modified_gmt")
  var modifiedGmt: Instant,
  @SerialName("parent")
  var parent: Int,
  @SerialName("seasons")
  var seasons: List<SeasonId>,
  @SerialName("slug")
  var slug: String,
  @SerialName("staff")
  var staff: List<JsonElement>,
  @SerialName("status")
  var status: String,
  @SerialName("tables")
  var tables: List<JsonElement>,
  @SerialName("template")
  var template: String,
  @SerialName("title")
  var title: Rendered,
  @SerialName("type")
  var type: String,
  @SerialName("uagb_author_info")
  var uagbAuthorInfo: UagbAuthorInfo,
  @SerialName("uagb_comment_info")
  var uagbCommentInfo: Int,
  @SerialName("uagb_excerpt")
  var uagbExcerpt: JsonElement? = null,
  @SerialName("uagb_featured_image_src")
  var uagbFeaturedImageSrc: UagbFeaturedImageSrc,
  @SerialName("url")
  var url: String,
  @SerialName("venues")
  var venues: List<VenueId>,
  @SerialName("class_list")
  var classList: List<String>
)
