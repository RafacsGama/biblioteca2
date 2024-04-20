package com.fuctura.biblioteca2.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class StandardError {
    @JsonFormat(pattern = "HH:mm - dd/mm/yyyy")
    private LocalDateTime timestemp;
    private Integer status;
    private String message;
    private String path;

    public StandardError() {
    }

    public StandardError(LocalDateTime timestemp, Integer status, String message, String path) {
        this.timestemp = timestemp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimestemp() {
        return timestemp;
    }

    public void setTimestemp(LocalDateTime timestemp) {
        this.timestemp = timestemp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}