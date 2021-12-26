package com.github.demolisher.animedb.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

/**
 *  Created by Android Studio on 12/25/2021 9:57 PM
 *  Developer: Sergey Leskov
 */

@SuppressLint("CommitPrefEdits")
class SharedPreferenceManager constructor(private val context: Context) {

    private val PREFERENCES_FILE_NAME = "animedb.spref"
    private val USER_TOKEN = "user_token"
    private val USER_EMAIL = "USER_EMAIL"
    private val sharedPreferences: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        this.sharedPreferences =
            context.getSharedPreferences(PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
        this.editor = sharedPreferences.edit()
    }

//    var userEmail: String?
//        get() {
//            return sharedPreferences.getString(USER_EMAIL, null)
//        }
//        set(userEmail) {
//            editor.putString(USER_EMAIL, userEmail)
//            editor.apply()
//        }


    var userToken: String?
        get() {
            return sharedPreferences.getString(USER_TOKEN, null)
        }
        set(token) {
            editor.putString(USER_TOKEN, token)
            editor.apply()
        }


    fun clearAllSharedPreferences() {
        sharedPreferences.edit()
            ?.clear()
            ?.apply()
    }
}