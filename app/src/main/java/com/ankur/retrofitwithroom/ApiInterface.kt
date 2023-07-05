package com.ankur.retrofitwithroom

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    suspend fun getData():Response<dataModel>
}