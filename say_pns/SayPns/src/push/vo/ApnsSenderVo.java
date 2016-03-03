package push.vo;

import java.util.ArrayList;
import java.util.List;


public class ApnsSenderVo {
	
	private String msg;
	private List<String> pushIdList;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<String> getPushIdList() {
		return pushIdList;
	}
	public void setPushIdList(List<String> pushId) {
		this.pushIdList = pushId;
	}
	
	@Override
	public String toString() {
		return "IpnsSenderVo [msg=" + msg + ", pushId=" + pushIdList + "]";
	}



	
}
