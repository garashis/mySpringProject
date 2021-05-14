package com.example.mySpringProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// @RestController annotation is a combination of Spring’s @Controller and @ResponseBody annotations.
// The @Controller annotation is used to define a controller and the
// @ResponseBody annotation is used to indicate that the return value of a method should be used as the response body of the request.
public class MyController {

    //After Spring 4.3 If your class has only single constructor then there is no need to put @Autowired
    private final AuthorsRepository authorsRepository;

    private final MyService service;

    public MyController(AuthorsRepository authorsRepository, MyService service){
        this.authorsRepository= authorsRepository;
        this.service = service;
    }

    @GetMapping("/authors")
    public List<Authors> getAllNotes() {
        return authorsRepository.findAll();
    }

    @GetMapping("/users")
    public String getUsers() {
        return service.getUsers();
    }
}
