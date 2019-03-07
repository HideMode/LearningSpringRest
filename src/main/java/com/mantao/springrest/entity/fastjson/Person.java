package com.mantao.springrest.entity.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Manito on 2019/3/7.
 */
@Getter
@Setter
@ToString
public class Person {

    private int age;

    @JSONField(name = "full_name")
    private String fullName;

    @JSONField(name = "date_of_birth", format = "yyyy-MM-dd HH:mm:ss")
    private Date dateOfBirth;

    @JsonIgnore
    private String password;

}
