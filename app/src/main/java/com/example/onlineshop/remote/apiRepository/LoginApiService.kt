package com.example.onlineshop.remote.apiRepository

import com.example.onlineshop.remote.dataModel.DefaultModel
import com.example.onlineshop.remote.dataModel.GetApiModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginApiService {

    @FormUrlEncoded
    @POST("email/login")
    suspend fun sendCode(
        @Field("email") email: String
    ): Response<DefaultModel>

    @FormUrlEncoded
    @POST("email/login/verify")
    suspend fun verifyCode(
        @Header("app-device-uid") androidId:String,
        @Field("code") code: String,
        @Field("email") email: String
    ): Response<GetApiModel>

}