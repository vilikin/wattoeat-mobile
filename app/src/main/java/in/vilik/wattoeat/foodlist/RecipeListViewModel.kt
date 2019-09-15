package `in`.vilik.wattoeat.foodlist

import `in`.vilik.wattoeat.Food
import `in`.vilik.wattoeat.repository.RecipeRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RecipeListViewModel : ViewModel() {

    private val recipeRepository = RecipeRepository()

    private val _recipes : MutableLiveData<List<Food>> = MutableLiveData(emptyList())

    val recipes: LiveData<List<Food>> = _recipes

    init {
        viewModelScope.launch {
            _recipes.value = recipeRepository.findAllRecipes()
        }
    }
}