package com.example.project1662.repository

import com.example.project1662.Domain.PropertyDomain

object FavoriteRepository {
    private val favoriteList = mutableListOf<PropertyDomain>()

    fun addFavorite(property: PropertyDomain) {
        if (!favoriteList.contains(property)) {
            favoriteList.add(property)
        }
    }

    fun removeFavorite(property: PropertyDomain) {
        favoriteList.remove(property)
    }

    fun getFavorites(): List<PropertyDomain> {
        return favoriteList
    }

    fun isFavorite(property: PropertyDomain): Boolean {
        return favoriteList.contains(property)
    }
}
