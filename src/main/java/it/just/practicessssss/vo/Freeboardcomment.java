package it.just.practicessssss.vo;

public class Freeboardcomment {
	private int boardcomments_seq;
	private int board_seq;
	private int writerid;
	private String writedate;
	private String content;
	private int parentseq;
	private int rcvid;
	private int deleteflag;
	public Freeboardcomment() {
		super();
	}
	public Freeboardcomment(int boardcomments_seq, int board_seq, int writerid, String writedate, String content,
			int parentseq, int rcvid, int deleteflag) {
		super();
		this.boardcomments_seq = boardcomments_seq;
		this.board_seq = board_seq;
		this.writerid = writerid;
		this.writedate = writedate;
		this.content = content;
		this.parentseq = parentseq;
		this.rcvid = rcvid;
		this.deleteflag = deleteflag;
	}
	public int getBoardcomments_seq() {
		return boardcomments_seq;
	}
	public void setBoardcomments_seq(int boardcomments_seq) {
		this.boardcomments_seq = boardcomments_seq;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public int getWriterid() {
		return writerid;
	}
	public void setWriterid(int writerid) {
		this.writerid = writerid;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getParentseq() {
		return parentseq;
	}
	public void setParentseq(int parentseq) {
		this.parentseq = parentseq;
	}
	public int getRcvid() {
		return rcvid;
	}
	public void setRcvid(int rcvid) {
		this.rcvid = rcvid;
	}
	public int getDeleteflag() {
		return deleteflag;
	}
	public void setDeleteflag(int deleteflag) {
		this.deleteflag = deleteflag;
	}
	@Override
	public String toString() {
		return "Freeboardcomment [boardcomments_seq=" + boardcomments_seq + ", board_seq=" + board_seq + ", writerid="
				+ writerid + ", writedate=" + writedate + ", content=" + content + ", parentseq=" + parentseq
				+ ", rcvid=" + rcvid + ", deleteflag=" + deleteflag + "]";
	}
	
	
}
