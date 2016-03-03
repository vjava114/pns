package push.module;

import java.util.ArrayList;
import java.util.List;

import javapns.back.PushNotificationManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
import javapns.data.PayLoad;

public class MultiAPNS {

	private static final String HOST = "gateway.push.apple.com";
	private static final int PORT = 2195;

	// Badge
	private static final int BADGE = 1;

	// iPhone's UDID (64-char device token)
	private static String iPhoneId1 = "65af3bb9bc6b795793b13cfc6192e9da1a04cdb6535ae7ed99df9d4ab862774c";
	private static String iPhoneId2 = "65af3bb9bc6b795793b13cfc6192e9da1a04cdb6535ae7ed99df9d4ab862774c";
	private static List<String> iphoneIdList = new ArrayList<String>();
	private static String certificate = "D:/rcm_prj/SayPns/iosAuth/say_apns_prod.p12";
	private static String passwd = "rocomo123";

	public static void main(String[] args) throws Exception {

		// device id add
		
		iphoneIdList.add(iPhoneId1);
		iphoneIdList.add(iPhoneId2);
		
		for(int i=0; i<900; i++){
			iphoneIdList.add("65af3bb9bc6b795793b13cfc6192e9da1a04cdb6535ae7ed99df9d4ab862774c");
		}

		try {

			// Setup up a simple message
			PayLoad aPayload = new PayLoad();
			aPayload.addBadge(BADGE);
			aPayload.addAlert("hello changwoo 안녕!");
			aPayload.addSound("default");

			// Get PushNotification Instance
			PushNotificationManager pushManager = PushNotificationManager.getInstance();

			// Link iPhone's UDID (64-char device token) to a stringName
			for (int i = 0; i < iphoneIdList.size(); i++) {
				String iPhoneId = iphoneIdList.get(i).toString();
				String deviceNum = String.valueOf(i);
				
				System.out.println("deviceNum : " + deviceNum);
				
				pushManager.addDevice(deviceNum, iPhoneId);
				// Get iPhone client
				Device client = pushManager.getDevice(deviceNum);

				// Initialize connection
				pushManager.initializeConnection(HOST, PORT, certificate, passwd, SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);

				// Send message
				pushManager.sendNotification(client, aPayload);
				System.out.println("Message sent! " + i);
				
			}
			System.out.println("# of attempts: " + pushManager.getRetryAttempts());
			pushManager.stopConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}