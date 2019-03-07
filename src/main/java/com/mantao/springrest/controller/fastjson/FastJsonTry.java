package com.mantao.springrest.controller.fastjson;

import com.mantao.springrest.entity.fastjson.Person;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Manito on 2019/3/7.
 */
@RestController
@RequestMapping(value = "fastjson")
@Log4j2
public class FastJsonTry {

    @GetMapping("")
    @ResponseBody
    public Person fetchPersonObject(@RequestParam("age") int age) {
        Person person = new Person();
        person.setAge(age);
        person.setFullName("Manito Tao");
        person.setDateOfBirth(new Date());

        return person;
    }

    @PostMapping("post")
    @ResponseBody
    public Person postPersonObject(@RequestBody Person person) {
        log.info(person.toString());
        return person;
    }

}
