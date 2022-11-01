package com.example.kids.core.model.getarticles

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    val `abstract`: String,
    val adx_keywords: String,
    val asset_id: Long,
    val byline: String,
    val column: String,
    val des_facet: ArrayList<String>,
    val eta_id: Int,
    val geo_facet: ArrayList<String>,
    val id: Long,
    val media: ArrayList<Media>,
    val nytdsection: String,
    val org_facet: ArrayList<String>,
    val per_facet: ArrayList<String>,
    val published_date: String,
    val section: String,
    val source: String,
    val subsection: String,
    val title: String,
    val type: String,
    val updated: String,
    val uri: String,
    val url: String
): Parcelable