package com.example.getInline.domain;


import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Admin {
    private Long id;

    private String email;
    private String nickname;
    private String password;
    private String phoneNumber;
    private String memo;

    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
}
