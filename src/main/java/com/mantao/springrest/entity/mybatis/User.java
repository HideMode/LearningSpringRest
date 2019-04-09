package com.mantao.springrest.entity.mybatis;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Manito on 2019/4/8.
 */
@Getter
@Setter
@ToString
public class User {
    Integer id;

    String username;

    String name;

    String phone;
}
