package com.example.getInline.error;

import com.example.getInline.constant.ErrorCode;
import com.example.getInline.dto.APIErrorResponse;
import com.example.getInline.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class APIExceptionHandler {
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<APIErrorResponse> general(GeneralException e) {
        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = errorCode.isClientSideError() ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status)
                .body(APIErrorResponse.of(false, errorCode, errorCode.getMessage(e)));
    }

    @ExceptionHandler
    public ResponseEntity<APIErrorResponse> exception(Exception e) {
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status)
                .body(APIErrorResponse.of(false, errorCode, errorCode.getMessage(e)));
    }
}
