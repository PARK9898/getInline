package com.example.getInline.error;

import com.example.getInline.constant.ErrorCode;
import com.example.getInline.exception.GeneralException;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler
    public ModelAndView general(GeneralException e) {
        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = errorCode.isClientSideError() ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;

        return new ModelAndView("error", Map.of(
                "statusCode", status.value(),
                "errorCode", errorCode,
                "message", errorCode.getMessage(e)
        ), status
        );
    }

    @ExceptionHandler
    public ModelAndView exception(Exception e) {
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if(e instanceof NoResourceFoundException) {
            status = HttpStatus.NOT_FOUND;
        }

        return new ModelAndView("error", Map.of(
                "statusCode", status.value(),
                "errorCode", errorCode,
                "message", errorCode.getMessage(e)
        ), status
        );
    }
}
