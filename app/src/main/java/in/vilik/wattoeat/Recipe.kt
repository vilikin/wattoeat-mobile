package `in`.vilik.wattoeat

import java.io.Serializable

data class Recipe(
    val contentfulId: String,
    val name: String,
    val ingredients: List<String>,
    val instructions: String?,
    val imageUrl: String?
): Serializable