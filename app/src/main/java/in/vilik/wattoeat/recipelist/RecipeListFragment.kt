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
import com.airbnb.epoxy.EpoxyRecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_holder_recipe_list_item.view.*

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
                    this.onBind { _, bindingHolder, _ ->
                        val root = bindingHolder.dataBinding.root
                        val imageView = root.foodImage
                        if (it.imageUrl != null) {
                            Picasso.with(root.context).load(it.imageUrl).into(imageView)
                        } else {
                            imageView.setImageResource(R.drawable.placeholder)
                        }
                    }

                    id(it.contentfulId)
                    recipe(it)
                }
            }
        }

        viewModel.recipes.observe(viewLifecycleOwner) {
            epoxyRecyclerView.requestModelBuild()
        }

        return view;
    }
}