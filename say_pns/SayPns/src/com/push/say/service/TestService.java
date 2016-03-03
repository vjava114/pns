package com.push.say.service;

import java.util.List;
import java.util.Map;

import com.push.say.dao.TestDao;

public class TestService {
 
    private TestService(){}
     
    private static TestService service;
     
    private TestDao dao = TestDao.getInstance();
     
    public static TestService getInstance(){
        if(service == null){
            service = new TestService();
        }
        return service;
    }
 
    public List<Map<String,Object>> selectMember(String mem_id) {
        return  dao.selectTest(mem_id);
    }

     
}