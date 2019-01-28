package it.just.practicessssss.vo;

/**
 * 
 * @author igorh 
 * 1차작성 igorh 오후 3:25:48 2019. 1. 24.
 * 2차작성 변수대문자 제거 igorh 오후 3:32:08 2019. 1. 24. 
 */
public class Minihome {
// DB table
//	minih_seq	    number          primary key
//	, userId	    number          not null references UserInfo(UserNo) on delete cascade
//	, userPhoto	    number          not null references FileMng(file_seq)
//	, userProfile	Varchar2(200)
//	, miniHits	    number          default 0
//	, privateFlag	Number(1)       default 0
	private int minih_seq;
	private int userid;
	private int userphoto;
	private String userprofile;
	private int minihits;
	private int privateFlag;

	public Minihome() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Minihome(int minih_seq, int userid, int userphoto, String userprofile, int minihits, int privateFlag) {
		super();
		this.minih_seq = minih_seq;
		this.userid = userid;
		this.userphoto = userphoto;
		this.userprofile = userprofile;
		this.minihits = minihits;
		this.privateFlag = privateFlag;
	}

	public int getminih_seq() {
		return minih_seq;
	}

	public void setminih_seq(int minih_seq) {
		this.minih_seq = minih_seq;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getUserphoto() {
		return userphoto;
	}

	public void setUserphoto(int userphoto) {
		this.userphoto = userphoto;
	}

	public String getUserprofile() {
		return userprofile;
	}

	public void setUserprofile(String userprofile) {
		this.userprofile = userprofile;
	}

	public int getMinihits() {
		return minihits;
	}

	public void setMinihits(int minihits) {
		this.minihits = minihits;
	}

	public int getPrivateFlag() {
		return privateFlag;
	}

	public void setPrivateFlag(int privateFlag) {
		this.privateFlag = privateFlag;
	}

	@Override
	public String toString() {
		return "Minihome [minih_seq=" + minih_seq + ", userid=" + userid + ", userphoto=" + userphoto + ", userprofile="
				+ userprofile + ", minihits=" + minihits + ", privateFlag=" + privateFlag + "]";
	}
}
