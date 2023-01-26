package io.hombro.chef.models;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Recipe {

    private String recipeName;
    private Map<String, Integer> ingredients = new HashMap<>();
}
