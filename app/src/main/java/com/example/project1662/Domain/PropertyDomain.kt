package com.example.project1662.Domain

import java.io.Serializable

class PropertyDomain(
    var type: String,
    var title: String,
    var address: String,
    var picPath: String,
    var price: Int,
    var bed: Int,
    var bath: Int,
    var isWifi: Boolean,
    var score: Double,
    var description: String
) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PropertyDomain) return false

        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        return title.hashCode()
    }
}
