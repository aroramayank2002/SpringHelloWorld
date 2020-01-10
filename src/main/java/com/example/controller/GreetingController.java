package com.example.controller;

import com.example.model.Book;
import com.example.model.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@Validated
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting( @RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    Book newBook(@Valid @RequestBody Book newBook) {
        return newBook;
    }

    @GetMapping("/books/{id}")
    Book findOne(@PathVariable @Min(1) Long id) { //jsr 303 annotations
        return new Book();
    }


}
