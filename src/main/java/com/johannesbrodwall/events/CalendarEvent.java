package com.johannesbrodwall.events;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

public class CalendarEvent {

    @Getter @Setter
    private String summary;

    @Getter @Setter
    private LocalDate date;

}
