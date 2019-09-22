package `in`.vilik.wattoeat

import java.io.Serializable

data class Recipe(
    val contentfulId: String,
    val name: String,
    val imageUrl: String?
): Serializable