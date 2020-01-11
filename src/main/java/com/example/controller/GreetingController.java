package com.example.controller;

import com.example.model.Book;
import com.example.model.BuilderClass;
import com.example.model.Greeting;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@Validated
@Slf4j
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

//  Better way compared to field injection.
    private Greeting greeting;

    @Autowired
    public void setGreeting(Greeting greetingSecond){
        this.greeting = greetingSecond;
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        log.info("Autowired bean greeting: " + greeting.getContent());
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    Book newBook(@Valid @RequestBody Book newBook) {
        return newBook;
    }

    @GetMapping("/books/{id}")
    Book findOne(@PathVariable @Min(1) Long id) {
        return new Book();
    }

    @PostMapping("/builder")
    BuilderClass findBuilder(@RequestParam(value = "name", defaultValue = "John") String name,
                             @RequestParam(value = "phone", defaultValue = "1234") String phone) {
        return BuilderClass.builder().name(name).phone(phone).build();
    }

//    This overrides global exception handler.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InvalidFormatException.class,
            MethodArgumentNotValidException.class,
            HttpClientErrorException.UnsupportedMediaType.class,
            HttpClientErrorException.MethodNotAllowed.class})
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
