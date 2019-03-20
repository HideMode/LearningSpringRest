package com.mantao.springrest.fastjson;

import com.mantao.springrest.controller.fastjson.FastJsonTry;
import com.mantao.springrest.entity.fastjson.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Manito on 2019/3/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class FastJsonTryTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetMethod() {
        String URI = "http://localhost:" + port + "/fastjson?age=1";
        Person person = restTemplate.getForObject(URI, Person.class, "1");
        log.info("person object: {}", person);
        Assert.assertEquals(1, person.getAge());
    }
}
