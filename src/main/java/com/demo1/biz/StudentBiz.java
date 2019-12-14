package com.demo1.biz;

import com.demo1.po.Clazz;
import com.demo1.po.Student;

import java.util.List;

public interface StudentBiz {
    public int save(Student st);
    public int update(Student st);
    public int delById(Integer sid);
    public Student findById(Integer sid);
    //使用map集合用来封装封页所需要的数据  page当前页数  rows每页记录数
    public List<Student> findPageAll(int page,int rows);
    public int findMaxRow();
    public List<Clazz> doinit();
}
