package com.mantao.springrest.controller.fastjson;

import com.mantao.springrest.entity.fastjson.Person;
import com.mantao.springrest.service.lifecycle.LifeCycleCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Manito on 2019/3/7.
 */
@RestController
@RequestMapping(value = "fastjson")
@Slf4j
public class FastJsonTryController {

    @Autowired
    LifeCycleCallback lifeCycleCallback;

    @GetMapping("")
    @ResponseBody
    public Person fetchPersonObject(@RequestParam("age") int age) {
        Person person = new Person();
        person.setAge(age);
        person.setFullName("Manito Tao");
        person.setDateOfBirth(new Date());
        log.info("person: {}", person);
        return person;
    }

    @PostMapping("post")
    @ResponseBody
    public Person postPersonObject(@RequestBody Person person) {
        log.info(person.toString());
        return person;
    }

}
