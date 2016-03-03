package com.push.say.mybatis;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
public class SqlMapSessionFactory {
 
    public static SqlSessionFactory ssf;
     
    static{
    	
    	String root = System.getProperty("user.dir");
    	
         
        String resource = "mybatis/configuration.xml";
        
        
        InputStream inputStream = null;
         
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        ssf = new SqlSessionFactoryBuilder().build(inputStream);
 
    }
     
     
    public static SqlSessionFactory getSqlSessionFactory(){
        return ssf;
    }
     
     
}