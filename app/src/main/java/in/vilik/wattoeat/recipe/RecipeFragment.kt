package `in`.vilik.wattoeat.recipe

import `in`.vilik.wattoeat.R
import `in`.vilik.wattoeat.databinding.RecipeFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

class RecipeFragment : Fragment() {

    val args: RecipeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<RecipeFragmentBinding>(inflater, R.layout.recipe_fragment, container, false)

        binding.recipe = args.recipe

        args.recipe.imageUrl?.let {
            Glide.with(binding.root).load(args.recipe.imageUrl).into(binding.recipeFragmentImage)
        }

        return binding.root
    }
}