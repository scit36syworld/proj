package it.just.practicessssss.vo;

public class Filemng {
	private int file_seq;
	private String originalname;
	private String savename;
	private String path;
	public Filemng() {
		super();
	}

	public Filemng(int file_seq, String originalname, String savename, String path) {
		super();
		this.file_seq = file_seq;
		this.originalname = originalname;
		this.savename = savename;
		this.path = path;
	}

	public int getFile_seq() {
		return file_seq;
	}

	public void setFile_seq(int file_seq) {
		this.file_seq = file_seq;
	}

	public String getOriginalname() {
		return originalname;
	}
	public void setOriginalname(String originalname) {
		this.originalname = originalname;
	}
	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = savename;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "File [originalname=" + originalname + ", savename=" + savename + ", path=" + path + "]";
	}
	
	
}
