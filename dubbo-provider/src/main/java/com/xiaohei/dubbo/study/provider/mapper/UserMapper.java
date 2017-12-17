package com.xiaohei.dubbo.study.provider.mapper;

import com.xiaohei.dubbo.study.common.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    List<User> getAll();

    @Insert("INSERT INTO user(name,age) VALUES(#{name}, #{age})")
    int insert(User user);

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    User getUser(long id);

    @Update("update user set name = #{user.name},age = #{user.age} where id = #{userId}")
    int update(@Param("userId") long id, @Param("user") User user);

    @Delete("delete from user where id = #{id}")
    int delete(long id);
}
