package org.example.todolistapp_practice.event;

public interface Event {
    void print();

    boolean support(EventType type);
}
