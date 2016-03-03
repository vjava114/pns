package push.module;
import java.util.LinkedList;
import java.util.ListIterator;
 
import javapns.back.FeedbackServiceManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
 
public class ApnsFeedback {
     // APNs Server Host & port
     private static final String HOST = "feedback.push.apple.com";
     private static final int PORT = 2196;
  
     private static String certificate = "D:/rcm_prj/SayPns/iosAuth/say_apns_prod.p12";
     private static String passwd = "rocomo123";
  
     public static void main( String[] args ) throws Exception {
  
        try {
             // Get FeedbackServiceManager Instance
             FeedbackServiceManager feedbackManager = FeedbackServiceManager.getInstance();
  
             // Initialize connection
             LinkedList<Device> devices = feedbackManager.getDevices( HOST, PORT, certificate, passwd, SSLConnectionHelper.KEYSTORE_TYPE_PKCS12 );
             System.out.println( "Devices returned: " + devices.size() );
  
             for (Device device : devices) {
            	 System.out.println("device : "+device.getLastRegister());
			}
             
             ListIterator<Device> itr = devices.listIterator();
             while ( itr.hasNext() ) {
                 Device device = itr.next();
                 System.out.println( "Device: id=[" + device.getId() +
                " token=[" + device.getToken() + "]" );
             }
  
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
}