package io.hombro.chef.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.yaml.snakeyaml.Yaml;

@Configuration(proxyBeanMethods = false)
public class YmlConfig {

    @Bean
    public Yaml yaml() {
        return new Yaml();
    }
}
