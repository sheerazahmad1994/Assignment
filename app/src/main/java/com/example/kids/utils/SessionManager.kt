package com.example.kids.utils;

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.kids.core.ui.MainActivity


class SessionManager(
    // Context
    var _context: Context,
) {
    var pref: SharedPreferences

    // Editor for Shared preferences
    var editor: SharedPreferences.Editor

    // Shared pref mode
    var PRIVATE_MODE = 0

    /**
     * Create login session
     *
     * @param id is identification number of record data in database
     * @param name of user
     * @param work is title or role in company
     * @param about is simple description of user
     * @param username is a account id for credential
     * @param token is a secret key which generated from id and username
     */
//    fun createLoginSession(
//        authTokenResp: AuthResponse,
//    ) {
//        editor.putBoolean(IS_LOGIN, true)
//        editor.putString(KEY_TOKEN, authTokenResp.data.token)
//        saveUserDetails(authTokenResp.data.user)
//        editor.commit()
//    }
//
//    fun saveUserDetails(user: User) {
//        editor.remove(KEY_USER_DETAILS)
//        val json = Gson().toJson(user)
//        editor.putString(KEY_USER_DETAILS, json)
//        editor.commit()
//    }

    /**
     * Check login method will check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     *
     * @return boolean
     */
    fun checkLogin(): Boolean {
        // Check login status
        if (!isLoggedIn) {
            // user is not logged in redirect him to Login Activity
            val i = Intent(_context, MainActivity::class.java)
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

            // Add new Flag to start new Activity
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            // Staring Login Activity
            _context.startActivity(i)
            return false
        }
        return true
    }

    val authDetails: String
        get() {
            // return user
            return pref.getString(KEY_TOKEN, null).toString()
        }

    /**
     * Get stored session data
     *
     * @return HashMap
     */
//    val authDetails: AuthTokenResp
//        get() {
//            // return user
//            return AuthTokenResp(
//                pref.getString(KEY_ACCESS_TOKEN, null),
//                pref.getInt(KEY_EXPIRES_IN, 0),
//                pref.getString(
//                    KEY_TOKEN_TYPE, null
//                )
//            )
//        }
//    val userDetails: User
//        get() {
//            val json: String? = pref.getString(KEY_USER_DETAILS, "")
//            return Gson().fromJson(json, User::class.java)
//        }
//    val bookingDetails: BookingDetails
//        get() {
//            val json: String? = pref.getString(KEY_BOOKING_DETAILS, "")
//            return Gson().fromJson(json, BookingDetails::class.java)
//        }

    /**
     * Clear session details
     */
    fun clearPrefs() {
        editor.clear()
        editor.commit()
    }

    fun logoutUser() {
        // Clearing all data from Shared Preferences
        editor.remove(KEY_TOKEN)
        editor.remove(IS_LOGIN)
        editor.remove(KEY_USER_DETAILS)

        editor.clear()
        editor.commit()

        // After logout redirect user to Login Activity
//        val i = Intent(_context, LoginActivity::class.java)
////        Closing all the Activities
//        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
// //       Staring Login Activity
//        _context.startActivity(i)
    }

    /**
     * Quick check for login
     */
    val isLoggedIn: Boolean
        get() = pref.getBoolean(IS_LOGIN, false)

    companion object {
        // Shared pref file name
        private const val PREF_NAME = "SPF_PREF"

        // All Shared Preferences Keys
        private const val IS_LOGIN = "IsLoggedIn"

        private const val IS_APP_USER_SAVED = "IsAppUserSaved"

        // User id
        const val KEY_ID = "id"

        // User token
        const val KEY_TOKEN = "userToken"
        const val KEY_USER_DETAILS = "userDetails"    }

    // Constructor
    init {
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
        editor.apply()
    }
}