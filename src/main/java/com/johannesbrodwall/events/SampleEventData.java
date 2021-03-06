package com.johannesbrodwall.events;

import com.johannesbrodwall.events.category.Category;
import com.johannesbrodwall.events.event.Event;
import com.johannesbrodwall.events.project.Project;
import com.johannesbrodwall.infrastructure.SampleData;

import java.time.LocalDate;


public class SampleEventData extends SampleData {

    public static Category sampleCategory() {
        return new Category(null, randomWords(2), randomColor());
    }

    public static Event sampleEvent(Category category) {
        Event event = new Event(randomWords(3), category);
        event.setStartDate(randomDate());
        event.setEndDate(event.getStartDate().plusDays(randomInt(30)));
        return event;
    }

    public static Project sampleProject() {
        return new Project(randomWords(3));
    }

    public static Project sampleProject(Project parent) {
        Project project = sampleProject();
        project.setParent(parent);
        return project;
    }

    public static Event sampleEvent(Category category, LocalDate targetDate) {
        Event event = new Event(randomWords(3), category);
        event.setStartDate(randomDate(targetDate));
        event.setEndDate(event.getStartDate().plusDays(randomInt(15)));
        return event;
    }


}
