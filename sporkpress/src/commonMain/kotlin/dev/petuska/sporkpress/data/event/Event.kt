package dev.petuska.sporkpress.data.event


import dev.petuska.sporkpress.data.*
import dev.petuska.sporkpress.data.SeasonId
import dev.petuska.sporkpress.data.TeamId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Event(
  @SerialName("author")
  var author: UInt,
  @SerialName("content")
  var content: Content,
  @SerialName("date")
  var date: Instant,
  @SerialName("date_gmt")
  var dateGmt: Instant,
  @SerialName("day")
  var day: String,
  @SerialName("defense")
  var defense: List<JsonElement>,
  @SerialName("excerpt")
  var excerpt: Content,
  @SerialName("featured_media")
  var featuredMedia: UInt,
  @SerialName("format")
  var format: String,
  @SerialName("guid")
  var guid: Rendered,
  @SerialName("id")
  var id: EventId,
  @SerialName("leagues")
  var leagues: List<UInt>,
  @SerialName("link")
  var link: String,
  @SerialName("_links")
  var links: Links,
  @SerialName("main_results")
  var mainResults: List<String>,
  @SerialName("meta")
  var meta: Meta,
  @SerialName("minutes")
  var minutes: String,
  @SerialName("mode")
  var mode: String,
  @SerialName("modified")
  var modified: Instant,
  @SerialName("modified_gmt")
  var modifiedGmt: Instant,
  @SerialName("offense")
  var offense: List<JsonElement>,
  @SerialName("outcome")
  var outcome: JsonElement,
  @SerialName("performance")
  var performance: List<List<JsonElement>>,
  @SerialName("players")
  var players: List<UInt>,
  @SerialName("results")
  var results: Map<TeamId, Result>,
  @SerialName("seasons")
  var seasons: List<SeasonId>,
  @SerialName("slug")
  var slug: String,
  @SerialName("staff")
  var staff: List<UInt>,
  @SerialName("status")
  var status: String,
  @SerialName("teams")
  var teams: List<TeamId>,
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
  var venues: List<VenueId>,
  @SerialName("winner")
  var winner: TeamId?,
)
