package com.user.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from DB_USER where uid = #{uid}")
    User getUserById(Integer uid);

}
