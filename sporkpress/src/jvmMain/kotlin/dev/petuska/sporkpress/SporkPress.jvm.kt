package dev.petuska.sporkpress

import io.ktor.client.*
import io.ktor.client.statement.*
import io.ktor.utils.io.jvm.javaio.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.DecodeSequenceMode
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeToSequence

internal actual fun buildClient(client: HttpClient): SporkPress = JvmSporkPress(client)

@OptIn(ExperimentalSerializationApi::class)
internal class JvmSporkPress(client: HttpClient) : DefaultSporkPress(client) {
  override suspend fun <T> FlowCollector<T>.emitItems(
    deserializer: KSerializer<T>,
    response: HttpResponse
  ) {
    val stream = response.bodyAsChannel().toInputStream()
    Json.decodeToSequence(
      stream = stream,
      deserializer = deserializer,
      format = DecodeSequenceMode.ARRAY_WRAPPED
    ).forEach { emit(it) }.also { stream.close() }
  }
}

@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
internal actual inline val Dispatchers.IO: CoroutineDispatcher
  get() = Dispatchers.IO
