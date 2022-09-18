package com.njhyuk.contract.adapter.in.web;

import com.njhyuk.contract.adapter.in.web.v1.model.ErrorModel;
import com.njhyuk.contract.domain.exception.BusinessException;
import com.njhyuk.contract.domain.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundException.class)
  protected ErrorModel notFoundException(Throwable e) {
    return new ErrorModel(e.getMessage());
  }

  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ExceptionHandler(BindException.class)
  protected ErrorModel validationException(BindException e) {
    String message = e.getBindingResult().getFieldErrors().stream()
        .findAny()
        .map(FieldError::getDefaultMessage)
        .orElse(null);

    return new ErrorModel(message);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(BusinessException.class)
  protected ErrorModel businessException(Throwable e) {
    return new ErrorModel(e.getMessage());
  }
}

