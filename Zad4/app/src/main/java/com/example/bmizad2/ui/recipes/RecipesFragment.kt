package com.example.bmizad2.ui.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bmizad2.databinding.FragmentRecipesBinding

class RecipesFragment : Fragment() {

    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!

    private val recipe1Title = "Tomato and Basil Soup."
    private val recipe2Title = "Lentil and Vegetable Stew."
    private val recipe1 = """Ingredients:
- 1 onion, 2 garlic cloves,
- 2 tbsp olive oil, 500g ripe tomatoes,
- 1 tbsp tomato puree,
- 1 tsp sugar, 600ml vegetable stock,
- salt and pepper, 2 tbsp fresh basil leaves
 
1. Heat the olive oil in a large saucepan over medium heat. Add the onion and garlic
and cook for 5 minutes until softened.
2. Add the tomatoes, tomato puree, sugar and vegetable stock. Season with salt and pepper.
3. Bring to the boil, then reduce the heat and simmer for 20 minutes.
4. Blend the soup until smooth.
5. Serve with the shredded basil leaves on top."""
    private val recipe2 = """Ingredients:
- 1 onion, 2 garlic cloves,
- 2 tbsp olive oil, 1 red pepper,
- 2 celery sticks, 2 medium carrots,
- 400g tin chopped tomatoes, 400g tin lentils,
- 300ml vegetable stock, salt and pepper
 
1. Heat the olive oil in a large saucepan over medium heat. Add the onion and garlic
and cook for 5 minutes until softened.
2. Add the tomatoes, tomato puree, sugar and vegetable stock.
Season with salt and pepper.
3. Bring to the boil, then reduce the heat and simmer for 20 minutes.
4. Blend the soup until smooth.
5. Serve with the shredded basil leaves on top."""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val recipesViewModel = ViewModelProvider(this).get(RecipesViewModel::class.java)
        _binding = FragmentRecipesBinding.inflate(inflater, container, false)

        with(binding) {
            buttonRecipe1.setOnClickListener {
                recipeTitle.text = recipe1Title
                recipe.text = recipe1
            }
            buttonRecipe2.setOnClickListener {
                recipeTitle.text = recipe2Title
                recipe.text = recipe2
            }
            recipesViewModel.text.observe(viewLifecycleOwner) { text ->
                textRecipes.text = text
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
