package it.just.practicessssss.vo;

public class Freeboard {
	private int board_seq;
	private String boardname;
	private int writerid;
	private String writedate;
	private String title;
	private String content;
	private int uploadfile;
	private int board_hits;

	public Freeboard() {
		super();
	}
	public Freeboard(int board_seq, String boardname, int writerid, String writedate, String title, String content,
			int uploadfile, int board_hits) {
		super();
		this.board_seq = board_seq;
		this.boardname = boardname;
		this.writerid = writerid;
		this.writedate = writedate;
		this.title = title;
		this.content = content;
		this.uploadfile = uploadfile;
		this.board_hits = board_hits;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getBoardname() {
		return boardname;
	}
	public void setBoardname(String boardname) {
		this.boardname = boardname;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(int uploadfile) {
		this.uploadfile = uploadfile;
	}
	public int getBoard_hits() {
		return board_hits;
	}
	public void setBoard_hits(int board_hits) {
		this.board_hits = board_hits;
	}
	@Override
	public String toString() {
		return "Freeboard [board_seq=" + board_seq + ", boardname=" + boardname + ", writerid=" + writerid
				+ ", writedate=" + writedate + ", title=" + title + ", content=" + content + ", uploadfile="
				+ uploadfile + ", board_hits=" + board_hits + "]";
	}
	
	
}
