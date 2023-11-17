package com.example.Second_homework.event;

import com.example.Second_homework.Event;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class AddEventHolder extends ApplicationEvent {

    private final Event event;

    public AddEventHolder(Object source, Event event) {
        super(source);
        this.event = event;
    }
}