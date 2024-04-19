package dev.petuska.sporkpress.data

import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class InstantSerializer : KSerializer<Instant> {
  override val descriptor = PrimitiveSerialDescriptor("InstantZ", PrimitiveKind.STRING)

  override fun serialize(encoder: Encoder, value: Instant) {
    encoder.encodeString(value.toString().removeSuffix("Z"))
  }

  override fun deserialize(decoder: Decoder): Instant {
    val iso = decoder.decodeString().replace(" ", "T").removeSuffix("Z") + "Z"
    return Instant.parse(iso)
  }
}

typealias Instant =
  @Serializable(with = InstantSerializer::class)
  Instant
