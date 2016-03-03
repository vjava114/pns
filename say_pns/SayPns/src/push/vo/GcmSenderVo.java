package push.vo;

import java.util.ArrayList;

public class GcmSenderVo {
	
	private String title = null;
	private String msg = null;
	private ArrayList<String> pushIdList = null;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ArrayList<String> getPushIdList() {
		return pushIdList;
	}
	public void setPushIdList(ArrayList<String> pushIdList) {
		this.pushIdList = pushIdList;
	}
	
	@Override
	public String toString() {
		return "GcmSenderVo [title=" + title + ", msg=" + msg + ", pushIdList="
				+ pushIdList + "]";
	}


	
	


	
	

}
