package com.example.getInline.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class APIDateResponse extends APIErrorResponse{
    private final Object data;

    private APIDateResponse(boolean success, Integer errorCode, String message, Object data) {
        super(success, errorCode, message);
        this.data = data;
    }

    public static APIDateResponse of(boolean success, Integer errorCode, String message, Object data) {
        return new APIDateResponse(success, errorCode, message, data);
    }
}
