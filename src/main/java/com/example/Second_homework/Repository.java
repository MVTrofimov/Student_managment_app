package com.example.Second_homework;


import com.example.Second_homework.event.AddEventHolder;
import com.example.Second_homework.event.DeleteEventHolder;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ShellComponent
public class Repository {

    private Map<UUID, Student> students = new HashMap<>();

    private ApplicationEventPublisher publisher;

    public Repository(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @ShellMethod(value = "Add student")
    public void add(String firstName, String lastName, Integer age){
        UUID id = UUID.randomUUID();
        Student student = new Student(id, firstName, lastName, age);
        students.put(id, student);
        Event event = new Event();

        event.setPayload("Создан студент " + firstName + " " + lastName + " id : " + id.toString());
        publisher.publishEvent(new AddEventHolder(this, event));
    }

    @ShellMethod(value = "Delete student with input id")
    public void delete(UUID id){
        students.remove(id);
        Event event = new Event();
        event.setPayload("Удален студент id : " + id.toString());
        publisher.publishEvent(new DeleteEventHolder(this, event));
    }

    @ShellMethod(value = "Show all students", key = "show")
    public void showAll(){
        for (UUID id : students.keySet()){
            System.out.println(students.get(id).toString());
        }
    }

    @ShellMethod(value = "Delete all students", key = "deleteAll")
    public void deleteAll(){
        students.clear();
    }

}
