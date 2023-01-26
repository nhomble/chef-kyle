package io.hombro.chef.commands;

import io.hombro.chef.repository.Recipes;
import lombok.AllArgsConstructor;
import org.springframework.shell.CompletionContext;
import org.springframework.shell.CompletionProposal;
import org.springframework.shell.completion.CompletionResolver;
import org.springframework.shell.standard.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class RecipeProvider implements ValueProvider {

    private final Recipes recipes;

    @Override
    public List<CompletionProposal> complete(CompletionContext completionContext) {
        return recipes.getAllRecipes().stream().map(n -> new CompletionProposal("\"" + n + "\"")).collect(Collectors.toList());
    }
}
