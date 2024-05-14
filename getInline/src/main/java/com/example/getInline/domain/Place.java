package com.example.getInline.domain;


import com.example.getInline.constant.PlaceType;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Place {
    private Long id;

    private PlaceType placeType;
    private String placeName;
    private String address;
    private String phoneNumber;
    private Integer capacity;
    private String memo;

    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

}
