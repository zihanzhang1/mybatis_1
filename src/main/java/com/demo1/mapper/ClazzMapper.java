package com.demo1.mapper;

import com.demo1.po.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface ClazzMapper {
    public List<Clazz> findAll();
}
