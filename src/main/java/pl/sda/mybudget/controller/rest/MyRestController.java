package pl.sda.mybudget.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my-rest")
@Slf4j
public class MyRestController {

    @GetMapping("/my-data/{name}/{surname}")
    void printMyData(@PathVariable("name") String name, @PathVariable("surname") String surname) {
        log.info("my data: [{} {}]", name, surname);
    }
}
