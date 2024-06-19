package ru.julia.controller.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ErrorDto {
    private List<String> errors;
}
