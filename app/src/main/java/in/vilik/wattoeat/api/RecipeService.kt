package `in`.vilik.wattoeat.api

import `in`.vilik.wattoeat.Food
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface RecipeService {
    @GET("recipes")
    @Headers("x-secret: 12345")
    suspend fun findAllRecipes(): List<Food>

    companion object {
        fun create(): RecipeService {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl("https://wattoeat.herokuapp.com/api/")
                .build()

            return retrofit.create(RecipeService::class.java)
        }
    }
}

