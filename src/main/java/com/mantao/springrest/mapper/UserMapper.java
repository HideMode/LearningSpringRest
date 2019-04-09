package com.mantao.springrest.mapper;

import com.mantao.springrest.entity.mybatis.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * Created by Manito on 2019/4/8.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER")
    List<User> getAllUser();

    User selectUserById(int id);
}
