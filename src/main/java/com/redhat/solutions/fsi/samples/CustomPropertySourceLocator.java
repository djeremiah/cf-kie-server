package com.redhat.solutions.fsi.samples;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

public class CustomPropertySourceLocator implements PropertySourceLocator {

    @Override
    public PropertySource<?> locate(Environment environment) {
        // Load Properties from CyberArk
        Map<String, Object> propertiesFromCyberArk = new HashMap<>();
        propertiesFromCyberArk.put("spring.datasource.username", "kieserver");
        propertiesFromCyberArk.put("spring.datasource.password", "kieserver");

        return new MapPropertySource("datasourceProperties", propertiesFromCyberArk);
    }
}
