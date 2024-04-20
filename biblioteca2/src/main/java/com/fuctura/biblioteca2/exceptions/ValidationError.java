package com.fuctura.biblioteca2.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(LocalDateTime timestemp, Integer status, String message, String path) {
        super(timestemp, status, message, path);
    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addErros(String fieldMessage, String message) {
        this.erros.add(new FieldMessage(fieldMessage, message));
    }
}
