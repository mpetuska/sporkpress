package dev.petuska.sporkpress

import io.ktor.client.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

internal actual fun buildClient(client: HttpClient): SporkPress = DefaultSporkPress(client)

internal actual inline val Dispatchers.IO: CoroutineDispatcher
  get() = IO
