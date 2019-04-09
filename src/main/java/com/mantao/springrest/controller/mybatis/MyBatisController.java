package com.mantao.springrest.controller.mybatis;

import com.mantao.springrest.entity.mybatis.User;
import com.mantao.springrest.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Manito on 2019/4/8.
 */
@RestController
@RequestMapping("mybatis")
@Slf4j
public class MyBatisController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    SqlSession sqlSession;

    @GetMapping(value = "user")
    List<User> getAllUserController() {
        return this.userMapper.getAllUser();
    }

    @GetMapping(value = "user/{id}")
    User getUserById(@PathVariable(value = "id", required = true) int id) {
        this.log.info("User ID: {}", id);
        return this.sqlSession.selectOne("selectUserById", id);
    }
}
