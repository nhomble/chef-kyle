package io.hombro.chef.commands;

import io.hombro.chef.models.Recipe;
import io.hombro.chef.models.RecipeLoader;
import io.hombro.chef.repository.Recipes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.yaml.snakeyaml.Yaml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecipeCommandsTest {

    private RecipeCommands recipeCommands;
    private RecipeLoader recipeLoader = new RecipeLoader(new Yaml());

    @Mock
    private Recipes recipes;

    @Captor
    private ArgumentCaptor<Recipe> captor;

    @BeforeEach
    void setup() {
        recipeCommands = new RecipeCommands(recipes, recipeLoader);
    }

    @Test
    void loadRecipes() {
        recipeCommands.loadRecipes("recipes");
        doNothing().when(recipes).addRecipe(captor.capture());
        assertEquals(2, captor.getAllValues().size());
    }
}
