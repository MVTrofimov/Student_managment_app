package com.example.Second_homework;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:application.properties")
@ConditionalOnProperty(name = "app.initializer.enabled", havingValue = "true")
public class RepositoryInitializer {

    private final Repository repository;

    public RepositoryInitializer(Repository repository) {
        this.repository = repository;
    }

    @EventListener(ApplicationStartedEvent.class)
    public void init(){
        repository.add("Иван", "Иванов", 25);
        repository.add("Кирилл", "Иванов", 35);
        repository.add("Петр", "Иванов", 21);
    }
}
