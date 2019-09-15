package `in`.vilik.wattoeat.repository

import `in`.vilik.wattoeat.Food
import `in`.vilik.wattoeat.api.RecipeService

class RecipeRepository {
    private val recipeService = RecipeService.create()

    suspend fun findAllRecipes(): List<Food> {
        return recipeService.findAllRecipes()
    }
}