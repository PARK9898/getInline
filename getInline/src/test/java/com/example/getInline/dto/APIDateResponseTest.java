package com.example.getInline.dto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.getInline.constant.ErrorCode;
import org.junit.jupiter.api.Test;

class APIDateResponseTest {

    @Test
    void givenStringData_whenCreatingResponse_thenReturnSuccess() {
        String data = "Test data";
        APIDateResponse response = APIDateResponse.of(data);

        assertThat(response)
                .hasFieldOrPropertyWithValue("success", true)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.OK.getCode())
                .hasFieldOrPropertyWithValue("message", ErrorCode.OK.getMessage())
                .hasFieldOrPropertyWithValue("data", data);

    }

    @Test
    void givenNothing_whenCreatingResponse_thenReturnsEmptySuccessfulResponse() {

        APIDateResponse<String> response = APIDateResponse.empty();

        assertThat(response)
                .hasFieldOrPropertyWithValue("success", true)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.OK.getCode())
                .hasFieldOrPropertyWithValue("message", ErrorCode.OK.getMessage())
                .hasFieldOrPropertyWithValue("data", null);
    }

}