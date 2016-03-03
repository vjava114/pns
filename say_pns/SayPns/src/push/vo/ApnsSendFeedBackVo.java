package push.vo;

import java.sql.Timestamp;

public class ApnsSendFeedBackVo {
	
	private String id;
	private String token;
	private Timestamp lastRegister;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Timestamp getLastRegister() {
		return lastRegister;
	}
	public void setLastRegister(Timestamp timestamp) {
		this.lastRegister = timestamp;
	}
	@Override
	public String toString() {
		return "ApnsSendFeedBackVo [id=" + id + ", token=" + token
				+ ", lastRegister=" + lastRegister + "]";
	}
	
	

}
