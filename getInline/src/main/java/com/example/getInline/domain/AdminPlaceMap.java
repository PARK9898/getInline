package com.example.getInline.domain;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.cglib.core.Local;

@Data
public class AdminPlaceMap {
    private Long id;

    private Long adminId;
    private Long placeId;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
