package com.push.say.controller;

import java.util.List;
import java.util.Map;

import com.push.say.service.TestService;


/**
 * MVC 패턴 웹프로그램에서의 테스트를 위한 예제소스
 * @author vjava
 *
 */
public class TestController {

	public static void main(String[] args) {
		TestService t = TestService.getInstance();
		List<Map<String,Object>> list = t.selectMember("");
		
		for (Object object : list) {
			System.out.println(object.toString());
		}
		
	}
}
