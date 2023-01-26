package io.hombro.chef.repository;

import io.hombro.chef.models.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class Cart {

    private final Recipes recipes;
    private Map<String, Integer> tally = new HashMap<>();

    public void add(String id, Integer num) {
        if (!recipes.contains(id)) {
            throw new RuntimeException("Unknown recipe=" + id);
        }
        tally.put(id, tally.getOrDefault(id, 0) + num);
    }

    public void remove(String id) {
        tally.computeIfPresent(id, (k, v) -> v - 1);
    }

    public void clear() {
        tally.clear();
    }

    public Map<String, Integer> getContents() {
        return new HashMap<>(tally);
    }

    public Map<String, Integer> getIngredients() {
        Map<String, Integer> m = new HashMap<>();
        tally.forEach((k, n) -> {
            Recipe r = recipes.getRecipeById(k).orElseThrow();
            r.getIngredients().forEach((ing, num) -> {
                m.put(ing, num * n);
            });
        });

        return m;
    }
}
