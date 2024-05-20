package com.example.getInline.constant;

import java.util.Optional;
import java.util.function.Predicate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    OK(0, ErrorCategory.NORMAL, "OK"),

    BAD_REQUEST(10000, ErrorCategory.CLIENT_SIDE, "bad request"),
    SPRING_BAD_REQUEST(10001, ErrorCategory.CLIENT_SIDE, "Spring-detected bad request"),

    INTERNAL_ERROR(20000, ErrorCategory.SERVER_SIDE, "internal error"),
    SPRING_INTERNAL_ERROR(20001, ErrorCategory.SERVER_SIDE, "Spring-detected internal error");

    private final Integer code;
    private final ErrorCategory errorCategory;
    private final String message;

    public String getMessage(Exception e) {
        return getMessage(e.getMessage());
    }

    public String getMessage(String message) {
        return Optional.ofNullable(message)
                .filter(Predicate.not(String::isBlank)) // 비어 있지 않다면 입력한 메시지를 띠워준다
                .orElse(getMessage()); // 아니면 디폴트 메시지를 띄워준다
    }

    public boolean isClientSideError() {
        return this.getErrorCategory() == ErrorCategory.CLIENT_SIDE;
    }

    public boolean isServerSideError() {
        return this.getErrorCategory() == ErrorCategory.SERVER_SIDE;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", name(), this.getCode());
    }

    private enum ErrorCategory {
        NORMAL, CLIENT_SIDE, SERVER_SIDE
    }
}
