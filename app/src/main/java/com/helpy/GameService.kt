package com.helpy

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GameService {
    @GET("/api/games")
    fun getGame(@Query("format") format: String):Call<Game>
}