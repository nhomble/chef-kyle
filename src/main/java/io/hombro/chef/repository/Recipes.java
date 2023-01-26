package io.hombro.chef.repository;

import io.hombro.chef.models.Recipe;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Component
public class Recipes {

    Map<String, Recipe> db = new HashMap<>();

    public boolean hasRecipes() {
        return !db.isEmpty();
    }

    public Set<String> getAllRecipes() {
        return db.keySet();
    }

    public Optional<Recipe> getRecipeById(String id) {
        return Optional.ofNullable(db.get(id));
    }

    public void addRecipe(Recipe recipe) {
        if (db.containsKey(recipe.getRecipeName())) {
            throw new RuntimeException("Recipe=" + recipe.getRecipeName() + " already exists");
        }
        db.put(recipe.getRecipeName(), recipe);
    }

    public void removeRecipe(Recipe recipe) {
        db.remove(recipe.getRecipeName());
    }

    public boolean contains(String name) {
        return db.containsKey(name);
    }
}
