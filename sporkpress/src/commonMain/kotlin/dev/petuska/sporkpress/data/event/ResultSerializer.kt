package dev.petuska.sporkpress.data.event

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*

@OptIn(ExperimentalSerializationApi::class)
class ResultSerializer : KSerializer<Result> {
  private val delegate = JsonElement.serializer()

  override val descriptor: SerialDescriptor = SerialDescriptor("Result", delegate.descriptor)

  override fun deserialize(decoder: Decoder): Result {
    val json = delegate.deserialize(decoder)
    return if (json is JsonArray) {
      Result.Empty
    } else {
      val jso = json as JsonObject
      val oJson = jso["outcome"]
      val sets = jso["sets"]?.jsonPrimitive?.content?.toUIntOrNull() ?: 0u
      val one = jso["one"]?.jsonPrimitive?.content?.toUIntOrNull() ?: 0u
      val two = jso["two"]?.jsonPrimitive?.content?.toUIntOrNull() ?: 0u
      val three = jso["three"]?.jsonPrimitive?.content?.toUIntOrNull() ?: 0u
      if (oJson is JsonArray) {
        Result.Value(
          outcome = oJson.map(JsonElement::toString),
          sets = sets,
          one = one,
          two = two,
          three = three,
        )
      } else {
        Result.Header(
          outcome = oJson.toString(),
          sets = sets,
          one = one,
          two = two,
          three = three,
        )
      }
    }
  }

  override fun serialize(encoder: Encoder, value: Result) {
    val jso = when (value) {
      is Result.Empty -> JsonArray(listOf())
      is Result.Filled -> buildJsonObject {
        put("sets", "${value.sets}")
        put("one", "${value.one}")
        put("two", "${value.two}")
        put("three", "${value.three}")
        when (value) {
          is Result.Header -> put("outcome", value.outcome)
          is Result.Value -> put("outcome", buildJsonArray { addAll(value.outcome) })
        }
      }
    }
    delegate.serialize(encoder, jso)
  }
}
