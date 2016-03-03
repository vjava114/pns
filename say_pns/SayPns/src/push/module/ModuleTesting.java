package push.module;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import push.vo.ApnsSendFeedBackVo;
import push.vo.GcmSendFeedBackVo;
import push.vo.GcmSenderVo;
import push.vo.ApnsSenderVo;

public class ModuleTesting {

	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 
		
		ModuleTesting mt = new ModuleTesting();
		mt.apnsTest();		// change here!
//		mt.gcmTest();		// change here!
	}
	
	
	/**
	 * 	APNS 푸시 테스트
	 */
	private void apnsTest(){
		
		/** Test 푸시아이디 셋팅 **/
		List<String> pushIdList = new ArrayList<String>();
		pushIdList.add("65af3bb9bc6b795793b13cfc6192e9da1a04cdb6535ae7ed99df9d4ab862774c");
		pushIdList.add("65af3bb9bc6b795793b13cfc6192e9da1a04cdb6535ae7ed99df9d4ab862774c");

		/** 푸시아이디 중복체크 **/
		ArrayList<String> uniqueItems = new ArrayList<String>(new HashSet<String>(pushIdList));
		
		/** 푸시모듈 발신 인자 셋팅 **/
		ApnsSenderVo vo = new ApnsSenderVo();
		vo.setMsg("hoho");
		vo.setPushIdList(uniqueItems);
		
		/** 발송 **/
		APNS apns = new APNS(false);			// apns는 sandbox용과 prod용 2가지 인증서가 있다.	
		List<ApnsSendFeedBackVo> apnsFeedbackList = apns.sender(vo);
		
		/** 피드백 체크 **/
		System.out.println("feedback message : "+apnsFeedbackList.toString());
	}
	
	/**
	 *  GCM 푸시 테스트!
	 */
	private void gcmTest(){
		
		/** Test 푸시아이디 셋팅 **/
		ArrayList<String> pushIdList = new ArrayList<String>();
		pushIdList.add("APA91bFgU9o5-pTuIMn5ehxmYzFMXikcto6vBMLBHGWIBbhf0RqWHUUtgxHPPHhHugdH9EfumkvuPjjqoZ4aCao8T7U16ozFw_E5Xn54Bv_FDcFqENNIu2fzM88s7Gt-s7tT_BXL5c7e");
		pushIdList.add("BBB91bFgU9o5-pTuIMn5ehxmYzFMXikcto6vBMLBHGWIBbhf0RqWHUUtgxHPPHhHugdH9EfumkvuPjjqoZ4aCao8T7U16ozFw_E5Xn54Bv_FDcFqENNIu2fzM88s7Gt-s7tT_BXL5c7e");
		
		/** 푸시아이디 중복체크 **/
		ArrayList<String> uniqueItems = new ArrayList<String>(new HashSet<String>(pushIdList));

		/** 푸시모듈 발신 인자 셋팅 **/
		GcmSenderVo vo = new GcmSenderVo();		
		vo.setPushIdList(uniqueItems);
		vo.setTitle("test");
		vo.setMsg("test msg");
		
		/** 발송 **/
		GCM gcm = new GCM();
		List<GcmSendFeedBackVo> gcmFeedbackList = gcm.sender(vo);
		
		/** 피드백 체크 **/
		System.out.println("feedback message : " + gcmFeedbackList.toString());
	}
	
	

}
