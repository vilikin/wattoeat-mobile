package `in`.vilik.wattoeat.recipe

import `in`.vilik.wattoeat.R
import `in`.vilik.wattoeat.databinding.RecipeFragmentBinding
import `in`.vilik.wattoeat.recipeIngredientsItem
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide

class RecipeFragment : Fragment() {

    val args: RecipeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<RecipeFragmentBinding>(
            inflater,
            R.layout.recipe_fragment,
            container,
            false
        )

        binding.recipe = args.recipe

        val ingredientsRecyclerView = binding.recipeFragmentIngredients
        ingredientsRecyclerView.layoutManager = LinearLayoutManager(context)

        ingredientsRecyclerView.withModels {
            args.recipe.ingredients.withIndex().forEach { (index, value) ->
                recipeIngredientsItem {
                    id(index)
                    ingredient(value)
                }
            }
        }


        Glide.with(binding.root).load(args.recipe.imageUrl).placeholder(R.drawable.placeholder)
            .into(binding.recipeFragmentImage)

        return binding.root
    }
}