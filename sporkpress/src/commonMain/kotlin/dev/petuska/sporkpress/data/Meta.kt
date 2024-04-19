package dev.petuska.sporkpress.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
  @SerialName("adv-header-id-meta")
  var advHeaderIdMeta: String,
  @SerialName("ast-banner-title-visibility")
  var astBannerTitleVisibility: String,
  @SerialName("ast-breadcrumbs-content")
  var astBreadcrumbsContent: String,
  @SerialName("ast-content-background-meta")
  var astContentBackgroundMeta: AstContentBackgroundMeta,
  @SerialName("ast-featured-img")
  var astFeaturedImg: String,
  @SerialName("ast-global-header-display")
  var astGlobalHeaderDisplay: String,
  @SerialName("ast-hfb-above-header-display")
  var astHfbAboveHeaderDisplay: String,
  @SerialName("ast-hfb-below-header-display")
  var astHfbBelowHeaderDisplay: String,
  @SerialName("ast-hfb-mobile-header-display")
  var astHfbMobileHeaderDisplay: String,
  @SerialName("ast-main-header-display")
  var astMainHeaderDisplay: String,
  @SerialName("ast-page-background-enabled")
  var astPageBackgroundEnabled: String,
  @SerialName("ast-page-background-meta")
  var astPageBackgroundMeta: AstPageBackgroundMeta,
  @SerialName("ast-site-content-layout")
  var astSiteContentLayout: String,
  @SerialName("astra-migrate-meta-layouts")
  var astraMigrateMetaLayouts: String,
  @SerialName("footer-sml-layout")
  var footerSmlLayout: String,
  @SerialName("header-above-stick-meta")
  var headerAboveStickMeta: String,
  @SerialName("header-below-stick-meta")
  var headerBelowStickMeta: String,
  @SerialName("header-main-stick-meta")
  var headerMainStickMeta: String,
  @SerialName("site-content-layout")
  var siteContentLayout: String,
  @SerialName("site-content-style")
  var siteContentStyle: String,
  @SerialName("site-post-title")
  var sitePostTitle: String,
  @SerialName("site-sidebar-layout")
  var siteSidebarLayout: String,
  @SerialName("site-sidebar-style")
  var siteSidebarStyle: String,
  @SerialName("stick-header-meta")
  var stickHeaderMeta: String,
  @SerialName("theme-transparent-header-meta")
  var themeTransparentHeaderMeta: String,
  @SerialName("_uag_custom_page_level_css")
  var uagCustomPageLevelCss: String
)
