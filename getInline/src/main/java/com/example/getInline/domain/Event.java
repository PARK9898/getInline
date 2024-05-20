package com.example.getInline.domain;

import com.example.getInline.constant.EventStatus;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Event {
    private Long id;

    private Long placeId;
    private String eventName;
    private EventStatus eventStatus;
    private LocalDateTime eventStartDateTime;
    private LocalDateTime eventEndDateTime;
    private Integer currentNumberOfPeople;
    private Integer capacity;

    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

}
