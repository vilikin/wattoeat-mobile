package `in`.vilik.wattoeat.api

import `in`.vilik.wattoeat.Recipe
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import java.util.concurrent.TimeUnit


interface RecipeService {
    @GET("recipes")
    @Headers("x-secret: 12345")
    suspend fun findAllRecipes(): List<Recipe>

    companion object {
        fun create(): RecipeService {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .build()

            val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl("https://wattoeat.herokuapp.com/api/")
                .build()

            return retrofit.create(RecipeService::class.java)
        }
    }
}

