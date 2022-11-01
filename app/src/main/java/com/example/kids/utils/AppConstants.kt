package com.example.kids.utils;
import androidx.viewbinding.BuildConfig

class AppConstants {
    companion object {
        val SHOW_CONSOLE_LOGS = BuildConfig.DEBUG

        /**
         * Base and staging URLS
         */
        const val BASE_URL = "https://api.nytimes.com/"
        const val API_KEY = "EqcJ2VXokDEUzIRw42OX0LHxm2GZrge4"

        /**
         * EndPoints
         */

        const val GET_ARTICLES = "svc/mostpopular/v2/viewed/7.json"

    }
}