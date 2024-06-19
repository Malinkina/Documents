package ru.julia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.julia.controller.dto.response.ErrorDto;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ErrorControllerAdvice {


    /**
     * берет из exception список ошибок, каждую ошибку превращает в строку, добавляет в список возвращаемый и возвращает
     * @param exception
     * @return объект со списком ошибок
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorDto handleException(MethodArgumentNotValidException exception) {
        List<String> stringErrors = new ArrayList<>();
        ErrorDto errorDto = new ErrorDto();
        List<FieldError> errors = exception.getBindingResult().getFieldErrors();
        for (FieldError error : errors) {
            String errorS = error.getField() + " " + error.getDefaultMessage();
            stringErrors.add(errorS);
        }
        errorDto.setErrors(stringErrors);
        return errorDto;
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public String handleOtherException(HttpRequestMethodNotSupportedException e) {
        return e.getBody().getDetail();
    }
}
