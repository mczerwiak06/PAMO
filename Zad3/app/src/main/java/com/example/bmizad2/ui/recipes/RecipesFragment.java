package com.example.bmizad2.ui.recipes;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.bmizad2.R;
import com.example.bmizad2.databinding.FragmentRecipesBinding;

public class RecipesFragment extends Fragment {

    private FragmentRecipesBinding binding;

    Button recipe1Button, recipe2Button;
    TextView pageLabel, recipeTitle, recipe;
    String recipe1Title = "Tomato and Basil Soup.";
    String recipe2Title = "Lentil and Vegetable Stew.";
    String recipe1 = "Ingridients:\n" +
            "- 1 onion, 2 garlic cloves,\n" +
            "- 2 tbsp olive oil, 500g ripe tomatoes,\n" +
            "- 1 tbsp tomato puree,\n" +
            "- 1 tsp sugar, 600ml vegetable stock,\n" +
            "- salt and pepper, 2 tbsp fresh basil leaves\n\n" +
            "1. Heat the olive oil in a large saucepan over medium heat. Add the onion and garlic\n" +
            " and cook for 5 minutes until softened.\n" +
            "2. Add the tomatoes, tomato puree, sugar and vegetable stock. Season with salt and pepper.\n" +
            "3. Bring to the boil, then reduce the heat and simmer for 20 minutes.\n" +
            "4. Blend the soup until smooth.\n" +
            "5. Serve with the shredded basil leaves on top.";
    String recipe2 = "Ingridients:\n" +
            "- 1 onion, 2 garlic cloves,\n" +
            "- 2 tbsp olive oil, 1 red pepper,\n" +
            "- 2 celery sticks, 2 medium carrots,\n" +
            "- 400g tin chopped tomatoes, 400g tin lentils,\n" +
            "- 300ml vegetable, salt and pepper\n\n" +
            "1. Heat the olive oil in a large saucepan over medium heat. Add the onion and garlic\n" +
            " and cook for 5 minutes until softened.\n" +
            "2. Add the tomatoes, tomato puree, sugar and vegetable stock.\n" +
            "Season with salt and pepper.\n" +
            "3. Bring to the boil, then reduce the heat and simmer for 20 minutes.\n" +
            "4. Blend the soup until smooth.\n" +
            "5. Serve with the shredded basil leaves on top.";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RecipesViewModel recipesViewModel =
                new ViewModelProvider(this).get(RecipesViewModel.class);

        binding = FragmentRecipesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recipe1Button = root.findViewById(R.id.button_recipe1);
        recipe2Button = root.findViewById(R.id.button_recipe2);
        pageLabel = root.findViewById(R.id.sampleRecipes);
        recipeTitle = root.findViewById(R.id.recipe_title);
        recipe = root.findViewById(R.id.recipe);

        recipe1Button.setOnClickListener(view -> {
            recipeTitle.setText(String.format(recipe1Title));
            recipe.setText(String.format(recipe1));

        });

        recipe2Button.setOnClickListener(view -> {
            recipeTitle.setText(String.format(recipe2Title));
            recipe.setText(String.format(recipe2));
        });

        final TextView textView = binding.textRecipes;
        recipesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}