plugins {
  id("kmp")
  id("detekt")
}

kotlin {
  jvm {
    withJava()
  }
  linuxX64()

  sourceSets {
    commonMain {
      dependencies {
        api(libs.kotlinx.serialization.core)
        api(libs.kotlinx.datetime)
        api(libs.kotlinx.coroutines.core)
        implementation(libs.ktor.client.core)
        implementation(libs.ktor.client.auth)
        implementation(libs.ktor.client.content.negotiation)
        implementation(libs.ktor.serialization.kotlinx.json)
      }
    }
    commonTest {
      dependencies {
        implementation(libs.kotlin.test)
      }
    }
    jvmMain {
      dependencies {
        implementation(libs.ktor.client.cio)
      }
    }
    nativeMain {
      dependencies {
        implementation(libs.ktor.client.cio)
      }
    }
  }
}
