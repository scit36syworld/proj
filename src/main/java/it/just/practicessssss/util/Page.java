package it.just.practicessssss.util;

public class Page {
	private int first;	//첫페이지
	private int last;	//마지막페이지
	private int view;	//출력할 숫자
	private int page;	//현재페이지
	private int pagestart;	//하단에 출력할 페이지번호 그룹의 첫번쨰
	private int pageend;	// 마지막
	private String searchtype;	//검색종류
	private String searchvalue;	//검색내용
	
	public Page() {
		super();
	}
	
	public Page(int page, int view) {
		this.first = 1;
		this.last = 1;
		this.pagestart = (page/5)*5+1;
		this.pageend = (page/5)*5+5;
		this.view = view;
		this.page = page;
	}
	public Page(int page, int view,String searchtype, String searchvalue) {
		this.first = 1;
		this.last = 1;
		this.pagestart = (page/5)*5+1;
		this.pageend = (page/5)*5+5;
		this.view = view;
		this.page = page;
		this.searchtype = searchtype;
		this.searchvalue = searchvalue;
	}
	
	public int getPagestart() {
		return pagestart;
	}

	public void setPagestart(int pagestart) {
		this.pagestart = pagestart;
	}

	public int getPageend() {
		return pageend;
	}

	public void setPageend(int pageend) {
		this.pageend = pageend;
	}

	public String getSearchtype() {
		return searchtype;
	}

	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}

	public String getSearchvalue() {
		return searchvalue;
	}

	public void setSearchvalue(String searchvalue) {
		this.searchvalue = searchvalue;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}


	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	

	@Override
	public String toString() {
		return "Page [first=" + first + ", last=" + last + ", view=" + view + ", page=" + page + ", pagestart="
				+ pagestart + ", pageend=" + pageend + ", searchtype=" + searchtype + ", searchvalue=" + searchvalue
				+ "]";
	}
}
