package com.example.myapplication

import android.util.Log

@ExperimentalUnsignedTypes
interface EditNfcData {
    var tagData: TagData
    val fragments: Array<EditFragment>

    fun setByte(which: WhichByte, value: UByte) {
        val diff = which.index - tagData.bytes.lastIndex
        if (diff > 0) {
            // increase buffer size
            tagData.bytes += UByteArray(diff) { 0u }
        }
        if (tagData.bytes[which.index] != value) {
            tagData.bytes[which.index] = value
            fragments.forEach { fragment ->
                if (fragment.isVisible) {
                    fragment.refreshDescriptions(tagData)
                }
            }
        }
    }
}

enum class WhichByte(val index: Int) { FOLDER(5), MODE(6), SPECIAL(7), SPECIAL2(8) }
