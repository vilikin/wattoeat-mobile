package `in`.vilik.wattoeat.repository

import `in`.vilik.wattoeat.Recipe
import `in`.vilik.wattoeat.api.RecipeService

class RecipeRepository {
    private val recipeService = RecipeService.create()

    suspend fun findAllRecipes(): List<Recipe> {
        return recipeService.findAllRecipes()
    }
}