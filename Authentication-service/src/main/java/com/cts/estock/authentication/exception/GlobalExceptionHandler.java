package com.cts.estock.authentication.exception;

import com.cts.estock.authentication.model.Error;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

        private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                      HttpHeaders headers, HttpStatus status, WebRequest request) {

            LOGGER.info("Start");

            Map<String, Object> body = new LinkedHashMap<>();
            body.put("timestamp",new Date());
            body.put("status", status.value());


            List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.toList());


            body.put("errors", errors);

            LOGGER.info("End");
            return new ResponseEntity<>(body, headers, status);
        }

        protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                      HttpHeaders headers, HttpStatus status, WebRequest request) {

            LOGGER.info("Start");

            Map<String, Object> body = new LinkedHashMap<>();
            body.put("timestamp", new Date());
            body.put("status", status.value());
            body.put("error", "Bad Request");

            if (ex.getCause() instanceof InvalidFormatException) {
                final Throwable cause = ex.getCause() == null ? ex : ex.getCause();
                for (InvalidFormatException.Reference reference : ((InvalidFormatException) cause).getPath()) {
                    body.put("message", "Incorrect format for field '" + reference.getFieldName() + "'");
                }
            }
            LOGGER.info("End");
            return new ResponseEntity<>(body, headers, status);
        }


        @ExceptionHandler(UserAlreadyExist.class)
        public final ResponseEntity<Error> handleUserNotFoundException(UserAlreadyExist ex, WebRequest request) {

            LOGGER.info("Start");

            Error errorDetails = new Error(ex.getMessage(), request.getDescription(false), new Date());
            LOGGER.info("End");
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(UserNotFoundException.class)
        public final ResponseEntity<Error> handleUserRegistrationException(
                UserNotFoundException ex, WebRequest request) {
            LOGGER.info("START");
            Error errorDetails = new Error(ex.getMessage(),
                    request.getDescription(false), new Date());
            LOGGER.info("END");
            return new ResponseEntity<Error>(errorDetails, HttpStatus.BAD_REQUEST);
        }
}
