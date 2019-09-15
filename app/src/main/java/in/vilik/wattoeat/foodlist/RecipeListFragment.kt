package `in`.vilik.wattoeat.foodlist

import `in`.vilik.wattoeat.R
import `in`.vilik.wattoeat.recipeListItem
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.airbnb.epoxy.EpoxyRecyclerView

class RecipeListFragment : Fragment() {
    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.recipe_list_fragment, container)

        val epoxyRecyclerView = view.findViewById<EpoxyRecyclerView>(R.id.food_list_recycler_view)

        epoxyRecyclerView.withModels {
            viewModel.recipes.value?.forEach {
                recipeListItem {
                    id(it.contentfulId)
                    food(it)
                }
            }
        }

        viewModel.recipes.observe(viewLifecycleOwner) {
            epoxyRecyclerView.requestModelBuild()
        }

        return view;
    }
}