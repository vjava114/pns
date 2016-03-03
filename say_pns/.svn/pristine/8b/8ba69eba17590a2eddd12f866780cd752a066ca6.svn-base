package push.module;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javapns.Push;
import javapns.back.FeedbackServiceManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotification;

import org.apache.log4j.Logger;

import push.vo.ApnsSendFeedBackVo;
import push.vo.ApnsSenderVo;

public class APNS {
	static Logger logger = Logger.getLogger(APNS.class);

	private final String HOST = "feedback.push.apple.com";
	private final int PORT = 2196;
	private final String authenticationPath = System.getProperty("user.dir") + "/iosAuth/say_apns_prod.p12";
	private final String authenticationPwd = "rocomo123";
	private boolean realYn = false;

	public APNS(boolean real_yn) {
		this.realYn = real_yn;
	}

	/** 발송 method **/
	public List<ApnsSendFeedBackVo> sender(ApnsSenderVo vo) {

		PushNotificationPayload payload = PushNotificationPayload.complex();

		try {

			payload.addAlert(vo.getMsg());
			// payload.addCustomAlertBody(msg);
			payload.addSound("default");
			payload.addBadge(0);
			payload.setExpiry(1000);

			List<PushedNotification> notifications = Push.payload(
					payload,
					this.authenticationPath, 
					this.authenticationPwd,
					this.realYn, 
					vo.getPushIdList());

			List<ApnsSendFeedBackVo> feedbackList = this.feedBack();

			System.out.println(notifications.toString());
			
			return feedbackList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	/** APNS는 feedBack 을 받기위해서 통신을 한번 더 해야 한다.  **/
	private List<ApnsSendFeedBackVo> feedBack() throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, NoSuchProviderException, IOException, Exception{
		

		List<ApnsSendFeedBackVo> feedbackList = new ArrayList<ApnsSendFeedBackVo>();
		

		// Get FeedbackServiceManager Instance
		FeedbackServiceManager feedbackManager = FeedbackServiceManager
				.getInstance();

		// Initialize connection
		LinkedList<Device> devices = feedbackManager.getDevices(
				this.HOST, 
				this.PORT,
				this.authenticationPath, 
				this.authenticationPwd,
				SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
		System.out.println("Connection initialized...");
		System.out.println("Devices returned: " + devices.size());

		for (Device device : devices) {
			ApnsSendFeedBackVo feedBackVo = new ApnsSendFeedBackVo();
			feedBackVo.setId(device.getId());
			feedBackVo.setToken(device.getToken());
			feedBackVo.setLastRegister(device.getLastRegister());
			
			feedbackList.add(feedBackVo);
		}
		
		return feedbackList;
	}
	
	/** 1000개씩 나눠서 하나의 배열로 return 함. **/
	public List splitPushId(List pushList){
		List splitList = new ArrayList();
		List tmpList = new ArrayList();

		/* 1000개씩 끊어서 다시 집어넣음 */
		for(int i=0; i<pushList.size(); i++){
			tmpList.add(pushList.get(i));
			if(i>0 && i%1000==0){
				splitList.add(tmpList);
				System.out.println(tmpList.toString());
				tmpList = new ArrayList();
			}
		}
		
		/* 남은거 마저 집어넣음 */
		if(pushList.size()>0)
			splitList.add(tmpList);
		return splitList;
	}

}
