package it.just.practicessssss.vo;

/**
 * 
 * @author igorh 
 * 1차작성	igorh 오후 3:28:40 2019. 1. 24.
 * 2차작성	변수 대문자제거 igorh 오후 3:33:15 2019. 1. 24.	
 */
public class Minihits {
//	DB TABLE
//	miniHits_Seq	number          primary key
//	, userId	    number          not null references UserInfo(UserNo) on delete cascade
//	, visitorId	    number          not null references UserInfo(UserNo) on delete cascade
//	, dateLogger	date            default sysdate

	private int minihits_seq;
	private int userid;
	private int visitorid;
	private String datelogger;

	public Minihits() {
	}

	public Minihits(int minihits_seq, int userid, int visitorid, String datelogger) {
		this.minihits_seq = minihits_seq;
		this.userid = userid;
		this.visitorid = visitorid;
		this.datelogger = datelogger;
	}

	public int getMinihits_seq() {
		return minihits_seq;
	}

	public void setMinihits_seq(int minihits_seq) {
		this.minihits_seq = minihits_seq;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getVisitorid() {
		return visitorid;
	}

	public void setVisitorid(int visitorid) {
		this.visitorid = visitorid;
	}

	public String getDatelogger() {
		return datelogger;
	}

	public void setDatelogger(String datelogger) {
		this.datelogger = datelogger;
	}

	@Override
	public String toString() {
		return "Minihits [minihits_seq=" + minihits_seq + ", userid=" + userid + ", visitorid=" + visitorid
				+ ", datelogger=" + datelogger + "]";
	}
}
