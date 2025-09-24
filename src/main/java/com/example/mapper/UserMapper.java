package com.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Peng
 * @date 2025-09-24 22:47
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
