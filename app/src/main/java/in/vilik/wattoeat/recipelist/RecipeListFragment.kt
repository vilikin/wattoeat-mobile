package `in`.vilik.wattoeat.recipelist

import `in`.vilik.wattoeat.R
import `in`.vilik.wattoeat.databinding.RecipeListFragmentBinding
import `in`.vilik.wattoeat.recipeListItem
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_holder_recipe_list_item.view.*

class RecipeListFragment : Fragment() {
    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<RecipeListFragmentBinding>(inflater, R.layout.recipe_list_fragment, container, false)

        val epoxyRecyclerView = binding.recipeListRecyclerView

        epoxyRecyclerView.withModels {
            viewModel.recipes.value?.forEach { recipe ->
                recipeListItem {
                    this.onBind { _, bindingHolder, _ ->
                        val root = bindingHolder.dataBinding.root
                        val imageView = root.recipeImage

                        Glide.with(root).load(recipe.imageUrl).placeholder(R.drawable.placeholder)
                            .into(imageView)

                        root.recipeCard.setOnClickListener {
                            val action =
                                RecipeListFragmentDirections.viewRecipeAction(recipe, recipe.name)

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

        binding.createRecipeButton.setOnClickListener {
            it.findNavController().navigate(R.id.createRecipeAction)
        }

        return binding.root
    }
}