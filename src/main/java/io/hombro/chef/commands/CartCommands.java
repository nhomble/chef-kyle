package io.hombro.chef.commands;

import io.hombro.chef.repository.Cart;
import io.hombro.chef.repository.Recipes;
import lombok.AllArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;

import java.util.Map;

@ShellComponent
@AllArgsConstructor
public class CartCommands {

    private final Recipes recipes;
    private final Cart cart;

    @ShellMethodAvailability
    public Availability availability() {
        if (recipes.hasRecipes()) {
            return Availability.available();
        }
        return Availability.unavailable("you haven't loaded any recipes");
    }

    @ShellMethod("addToCart")
    public void addToCart(@ShellOption(valueProvider = RecipeProvider.class) String recipe, @ShellOption(defaultValue = "1") Integer num) {
        cart.add(recipe, num);
    }

    @ShellMethod("removeFromCart")
    public void removeFromCart(@ShellOption(valueProvider = RecipeProvider.class) String recipe) {
        cart.remove(recipe);
    }

    @ShellMethod("clearCart")
    public void clearCart() {
        cart.clear();
    }

    @ShellMethod("listCartItems")
    public Map<String, Integer> listCartItems() {
        return cart.getContents();
    }

    @ShellMethod("listIngredients")
    public Map<String, Integer> listIngredients() {
        return cart.getIngredients();
    }
}
