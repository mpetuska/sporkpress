pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
  }
  includeBuild("./build-conventions")
}

plugins {
  id("settings")
}

rootProject.name = "SporkPress"
include(
  ":sporkpress",
)
