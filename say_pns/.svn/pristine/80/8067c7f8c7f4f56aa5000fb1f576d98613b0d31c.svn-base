package push.module;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import push.vo.GcmSendFeedBackVo;
import push.vo.GcmSenderVo;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

public class GCM {
	
	
	private final String APPID	 		= "AIzaSyCeYcS0cRe0OOtyY--KnRKloGGVnYaSKyc"; // APPID (google developer 사이트 관리자계정으로 확인 가능) 
	private final String MESSAGE_ID 	= String.valueOf(Math.random() % 100 + 1);	// 메세지 고유 아이디값 부여
	private final boolean SHOW_ON_IDLE 	= false;	 								// 기기가 활성화 상태일때 보여줄것인지 
	private final int LIVE_TIME 		= 1800;	 									// 기기가 비활성화 상태일때 GCM가 메시지를 유효화하는 시간 
	private final int RETRY 			= 5;	 									// 메시지 전송실패시 재시도 횟수
	
	/** 발송 method **/
	public List<GcmSendFeedBackVo> sender(GcmSenderVo vo){
		
		Message message = new Message.Builder()
		.collapseKey(MESSAGE_ID)
		.delayWhileIdle(SHOW_ON_IDLE)
		.timeToLive(LIVE_TIME)
		.addData("msg",vo.getMsg())
		.addData("title", vo.getTitle())
		.build();
		
		List<GcmSendFeedBackVo> feedbackList = new ArrayList<GcmSendFeedBackVo>();
		
		try {
			
			vo.getPushIdList().toArray();
			
			Sender sender = new Sender(APPID);		
			MulticastResult feedback = sender.send(message, vo.getPushIdList(), RETRY);
			System.out.println("GCM 성공 건수 : "+ feedback.getSuccess());
			System.out.println("GCM 실패 건수 : "+ feedback.getFailure());
			
			List<Result> results = feedback.getResults();
			
			for(int i=0; i<results.size(); i++){
				Result result = results.get(i);
				
				GcmSendFeedBackVo feedBackVo = new GcmSendFeedBackVo();
				
				feedBackVo.setErrorCodeName(result.getErrorCodeName());
				feedBackVo.setMessageId(result.getMessageId());
				feedBackVo.setCanonicalRegistrationId(result.getCanonicalRegistrationId());
				
				feedbackList.add(feedBackVo);
				System.out.println(feedBackVo.toString());
			}

			return feedbackList;

		}catch (IOException e) {
			// appId 가 잘못되었을때 일로 빠지게 된다.
			// "verify pushId.. can't GCM connecting";
		
			System.out.println(e.toString());
			return feedbackList;
		}
		
		
	}

	/** 1000개씩 나눠서 하나의 배열로 return 함. **/
	public List<Object> splitPushId(List<String> pushList){
		List<Object> splitList = new ArrayList<Object>();
		List<Object> tmpList = new ArrayList<Object>();

		/* 1000개씩 끊어서 다시 집어넣음 */
		for(int i=0; i<pushList.size(); i++){
			tmpList.add(pushList.get(i));
			if(i>0 && i%1000==0){
				splitList.add(tmpList);
				System.out.println(tmpList.toString());
				tmpList = new ArrayList<Object>();
			}
		}
		
		/* 남은거 마저 집어넣음 */
		if(pushList.size()>0)
			splitList.add(tmpList);
		return splitList;
	}
	
}
