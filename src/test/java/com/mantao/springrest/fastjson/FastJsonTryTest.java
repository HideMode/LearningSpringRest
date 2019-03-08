package com.mantao.springrest.fastjson;

import com.mantao.springrest.entity.fastjson.Person;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Manito on 2019/3/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class FastJsonTryTest {
    public static String BASE_URL = "http://localhost:8080";

    @Test
    public void testGetMethod() {
        String URI = BASE_URL + "/fastjson?age={age}";
        RestTemplate restTemplate = new RestTemplate();
        Person person = restTemplate.getForObject(URI, Person.class, "1");
        log.info(person);
        Assert.assertEquals(1, person.getAge());
    }
}
