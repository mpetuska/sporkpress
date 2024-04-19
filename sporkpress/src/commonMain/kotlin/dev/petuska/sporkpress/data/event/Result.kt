package dev.petuska.sporkpress.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable(with = ResultSerializer::class)
sealed interface Result {
  data object Empty : Result

  sealed interface Filled : Result {
    @SerialName("sets")
    var sets: UInt

    @SerialName("one")
    var one: UInt

    @SerialName("two")
    var two: UInt

    @SerialName("three")
    var three: UInt
  }

  data class Header(
    @SerialName("outcome")
    var outcome: String,
    override var sets: UInt,
    override var one: UInt,
    override var two: UInt,
    override var three: UInt
  ) : Filled

  class Value(
    @SerialName("outcome")
    var outcome: List<String>,
    override var sets: UInt,
    override var one: UInt,
    override var two: UInt,
    override var three: UInt
  ) : Filled
}
