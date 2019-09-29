package `in`.vilik.wattoeat.createrecipe

import `in`.vilik.wattoeat.R
import `in`.vilik.wattoeat.databinding.CreateRecipeFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

class CreateRecipeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<CreateRecipeFragmentBinding>(
            inflater,
            R.layout.create_recipe_fragment,
            container,
            false
        )

        return binding.root
    }
}