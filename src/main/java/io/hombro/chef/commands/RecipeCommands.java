package io.hombro.chef.commands;

import io.hombro.chef.models.Recipe;
import io.hombro.chef.models.RecipeLoader;
import io.hombro.chef.repository.Recipes;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.File;
import java.util.Collection;
import java.util.Set;

@ShellComponent
@AllArgsConstructor
public class RecipeCommands {

    private final Recipes recipes;
    private final RecipeLoader recipeLoader;

    @ShellMethod("loadRecipeDirectory")
    public void loadRecipes(String relativePath) {
        File dir = new File(relativePath);
        if (!dir.isDirectory()) {
            throw new RuntimeException("provide a directory");
        }
        Collection<File> files = FileUtils.listFiles(
                dir,
                new RegexFileFilter("^(.*?)"),
                DirectoryFileFilter.DIRECTORY
        );
        for (File f : files) {
            Recipe r = recipeLoader.read(f);
            recipes.addRecipe(r);
        }
    }

    @ShellMethod
    public Set<String> listRecipes() {
        return recipes.getAllRecipes();
    }

    @ShellMethod
    public Recipe showRecipe(@ShellOption(valueProvider = RecipeProvider.class) String recipe) {
        return recipes.getRecipeById(recipe).orElseThrow();
    }
}
