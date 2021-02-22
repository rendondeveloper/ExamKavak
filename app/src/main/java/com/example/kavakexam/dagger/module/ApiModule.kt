package com.example.kavakexam.dagger.module

import com.example.kavakexam.dto.friends.behavior.FriendsServices
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    private val URL : String = "https://raw.githubusercontent.com/";

    @Provides fun providerFriends() : FriendsServices {
        return providerRetrofit(URL, providerHttpClient()).create(FriendsServices::class.java)
    }

    @Provides fun providerHttpClient() : OkHttpClient{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level  = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient()
        client.newBuilder().addInterceptor(interceptor)
        return client;
    }

    @Provides fun providerRetrofit(baseUrl: String, client: OkHttpClient) : Retrofit {
        return  Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}
