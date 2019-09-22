package `in`.vilik.wattoeat.recipelist

import `in`.vilik.wattoeat.R
import `in`.vilik.wattoeat.recipeListItem
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.airbnb.epoxy.EpoxyRecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_holder_recipe_list_item.view.*

class RecipeListFragment : Fragment() {
    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.recipe_list_fragment, container, false)

        val epoxyRecyclerView = view.findViewById<EpoxyRecyclerView>(R.id.food_list_recycler_view)

        epoxyRecyclerView.withModels {
            viewModel.recipes.value?.forEach { recipe ->
                recipeListItem {
                    this.onBind { _, bindingHolder, _ ->
                        val root = bindingHolder.dataBinding.root
                        val imageView = root.recipeImage

                        recipe.imageUrl?.let {
                            Glide.with(root).load(recipe.imageUrl).into(imageView)
                        }

                        root.recipeCard.setOnClickListener {
                            val action = RecipeListFragmentDirections.viewRecipeAction(recipe, recipe.name)

                            it.findNavController().navigate(action)
                        }
                    }

                    id(recipe.contentfulId)
                    this.recipe(recipe)
                }
            }
        }

        viewModel.recipes.observe(viewLifecycleOwner) {
            epoxyRecyclerView.requestModelBuild()
        }

        return view
    }
}