package push.controller;

import java.util.ArrayList;
import java.util.List;

import push.module.APNS;
import push.module.GCM;
import push.vo.GcmSendFeedBackVo;
import push.vo.GcmSenderVo;
import push.vo.ApnsSenderVo;

public class PushController {
	

	/**
	 * @author 강준영 
	 * @param args {osType}	==> 'ios' or 'android'
	 * @param args {pushId}	==> '단말기의 유일한 id값 필요'
	 * @param args {msg}	==> '메세지'
	 * @param args {title}	==> '제목' (안드로이드폰만 사용가능 ios는 그냥 '' 넣어줄것)
	 */
	public static void main(String[] args) {
		try {
			
			if(args.length != 4){
				StringBuilder stb = new StringBuilder();
				stb.append("\n[command ex] java -jar PushController.jar '{osType}' '{pushId}' '{msg}' '{title}' ");
				stb.append("\n required parameter input plrease..");
				stb.append("\nios sample pushId--");
				stb.append("65af3bb9bc6b795793b13cfc6192e9da1a04cdb6535ae7ed99df9d4ab862774c");
				stb.append("\nandroid sample pushId--");
				stb.append("APA91bFgU9o5-pTuIMn5ehxmYzFMXikcto6vBMLBHGWIBbhf0RqWHUUtgxHPPHhHugdH9EfumkvuPjjqoZ4aCao8T7U16ozFw_E5Xn54Bv_FDcFqENNIu2fzM88s7Gt-s7tT_BXL5c7e");
				throw new Exception(stb.toString());
			}
			
			String osType 	= args[0];		//   ios or android 
			String pushId 	= args[1];
			String msg		= args[2];
			String title	= args[3];	
			
			ArrayList<String> pushIdList = new ArrayList<String>();
			pushIdList.add(pushId);
	
			if (osType.equals("ios")){
				
				ApnsSenderVo vo = new ApnsSenderVo();
				vo.setMsg(msg);
				vo.setPushIdList(pushIdList);
				
				APNS apns = new APNS(true);	// real		
				apns.sender(vo);
				
			}else if (osType.equals("android")){
				
				GcmSenderVo vo = new GcmSenderVo();
				vo.setPushIdList(pushIdList);
				vo.setTitle(title);
				vo.setMsg(msg);
				
				GCM gcm = new GCM();
				
				List<GcmSendFeedBackVo> result = gcm.sender(vo);
				//System.out.println(result.toString());
				
			}else{
				throw new Exception("osType only 'ios' or 'android'");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		

		
		
	}

}
