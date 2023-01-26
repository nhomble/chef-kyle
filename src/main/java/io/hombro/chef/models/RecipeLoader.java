package io.hombro.chef.models;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.*;

@Component
@AllArgsConstructor
public class RecipeLoader {

    private final Yaml yaml;

    public Recipe read(File f) {
        try (InputStream is = new FileInputStream(f)) {
            Recipe r = yaml.loadAs(is, Recipe.class);
            if (!StringUtils.hasText(r.getRecipeName())) {
                throw new RuntimeException("Recipe: " + f.getName() + " contains a recipe with no name");
            }
            return r;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
