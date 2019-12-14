package com.demo1.action;

import com.demo1.biz.StudentBiz;
import com.demo1.po.Clazz;
import com.demo1.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentActionImp implements  StudentAction {

    @Autowired
    private StudentBiz studentBiz;


    public StudentBiz getStudentBiz() {
        return studentBiz;
    }

    public void setStudentBiz(StudentBiz studentBiz) {
        this.studentBiz = studentBiz;
    }

    @Override
    @RequestMapping(value = "save_Student.do")
    public int save(HttpServletRequest request, HttpServletResponse response, Student st) {
        return studentBiz.save(st);
    }

    @Override
    @RequestMapping(value = "update_Student.do")
    public int update(HttpServletRequest request, HttpServletResponse response, Student st) {
        return studentBiz.update(st);
    }

    @Override
    @RequestMapping(value = "delById_Student.do")
    public int delById(HttpServletRequest request, HttpServletResponse response, Integer sid) {
        return studentBiz.delById(sid);
    }

    @Override
    @RequestMapping(value = "findById_Student.do")
    public Student findById(HttpServletRequest request, HttpServletResponse response, Integer sid) {
        return studentBiz.findById(sid);
    }

    @Override
    @RequestMapping(value = "findPageAll_Student.do")
    public Map<String, Object> findPageAll(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) {
        page=page==null||page<1?1:page;
        rows=rows==null||rows<1?5:rows;

        //获取总记录数
        int maxrow=studentBiz.findMaxRow();
        int maxpage=1;//总页数
        if(rows>20)  rows=20;//限制当前页呈现的记录数不能超过20条
        if(maxrow>0){
            maxpage=maxrow%rows==0?maxrow/rows:maxrow/rows+1;
        }

        //获取每页记录的集合
        List<Student> list=studentBiz.findPageAll(page,rows);

        Map<String,Object> map=new HashMap<>();
        map.put("page",page);
        map.put("rows",rows);
        map.put("maxPage",maxpage);
        map.put("list",list);
        return map;
    }

    @Override
    @RequestMapping(value = "doinit_Student.do")
    public List<Clazz> doinit(HttpServletRequest request, HttpServletResponse response) {
        List<Clazz> lsca=studentBiz.doinit();
        return lsca;
    }
}
