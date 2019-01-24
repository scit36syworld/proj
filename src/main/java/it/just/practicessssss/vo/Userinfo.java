package it.just.practicessssss.vo;

public class Userinfo {
	private int userno;
	private String userid;
	private String userpw;
	private String username;
	private String userphone;
	private String userbirth;
	private String joindate;
	public Userinfo() {
		super();
	}
	public Userinfo(int userno, String userid, String userpw, String username, String userphone, String userbirth,
			String joindate) {
		super();
		this.userno = userno;
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userphone = userphone;
		this.userbirth = userbirth;
		this.joindate = joindate;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUserbirth() {
		return userbirth;
	}
	public void setUserbirth(String userbirth) {
		this.userbirth = userbirth;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	@Override
	public String toString() {
		return "UserinfoVO [userno=" + userno + ", userid=" + userid + ", userpw=" + userpw + ", username=" + username
				+ ", userphone=" + userphone + ", userbirth=" + userbirth + ", joindate=" + joindate + "]";
	}
	
	
}
