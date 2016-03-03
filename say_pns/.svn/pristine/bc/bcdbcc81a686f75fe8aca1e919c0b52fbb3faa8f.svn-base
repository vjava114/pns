package com.push.say.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.push.say.mybatis.SqlMapSessionFactory;

public class TestDao {
 
    private TestDao() {}
     
    private static TestDao dao;
     
    public static TestDao getInstance(){
        if(dao == null){
            dao = new TestDao();
        }
         
        return dao;
    }
     
    SqlSessionFactory factory = SqlMapSessionFactory.getSqlSessionFactory();
     
    public List<Map<String,Object>> selectTest(String mem_id) {
        SqlSession session = factory.openSession();
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        
        list= session.selectList("test.selectMember");
        session.close();
         
        return list;
    }
 
 
     
}