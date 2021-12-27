package com.github.demolisher.animedb.utils

/**
 *  Created by Android Studio on 12/23/2021 11:54 AM
 *  Developer: Sergey Leskov
 */

object NetworkUrls {
    const val REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob"
    const val URL_WEBSITE = "https://shikimori.one/"
    const val ANIMES = "api/animes"
    const val ANIME_BY_ID = "api/animes/{id}"
    const val MANGAS = "api/mangas"
    const val MANGA_BY_ID = "api/mangas/{id}"
    const val SEARCH_ANIME = "api/animes/{search}"
    const val USER_SIGN_IN = "api/access_token?{nickname}/{password}"
    const val TOKEN = "oauth/token"
}