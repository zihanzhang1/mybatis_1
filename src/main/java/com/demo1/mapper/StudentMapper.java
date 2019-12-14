package com.demo1.mapper;


import com.demo1.po.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface StudentMapper {
    public int save(Student st);
    public int update(Student st);
    public int delById(Integer sid);
    public Student findById(Integer sid);
    //使用Map集合封装分页所需要的数据,page当前页数，rows每页记录数
    public List<Student> findPageAll(Map<String,Object> map);
    public int findMaxRow();

}

