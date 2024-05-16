package com.example.getInline.dto;

import com.example.getInline.constant.ErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class APIDateResponse<T> extends APIErrorResponse{
    private final T data;

    private APIDateResponse(T data) {
        super(true, ErrorCode.OK.getCode(), ErrorCode.OK.getMessage());
        this.data = data;
    }

    public static <T> APIDateResponse<T> of(T data) {
        return new APIDateResponse(data);
    }
}
