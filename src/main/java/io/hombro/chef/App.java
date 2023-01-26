package io.hombro.chef;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Component
    public static class ChefPrompt implements PromptProvider {

        @Override
        public final AttributedString getPrompt() {

            return new AttributedString("chefkyle>", AttributedStyle.BOLD);

        }

    }
}
