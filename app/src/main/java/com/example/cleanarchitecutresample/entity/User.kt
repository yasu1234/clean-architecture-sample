package com.example.cleanarchitecutresample.entity

import com.google.gson.annotations.SerializedName

class User {
    var description: String? = null
    @SerializedName("followees_count")
    var followCount = 0
    @SerializedName("followers_count")
    var followerCount = 0
    var name: String? = null
    @SerializedName("profile_image_url")
    var imageUrl: String? = null
}