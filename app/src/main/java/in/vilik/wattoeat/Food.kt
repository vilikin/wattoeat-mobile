package `in`.vilik.wattoeat

data class Food(
    val contentfulId: String,
    val name: String
)

val exampleFoods = listOf(
    Food("1", "Makaronilaatikko"),
    Food("2", "Maksalaatikko"),
    Food("3", "Sosesoppa"),
    Food("4", "Pizza"),
    Food("5", "Pinaattirisotto")
)