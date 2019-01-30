package it.just.practicessssss.dao;

import java.util.List;

import it.just.practicessssss.util.Page;
import it.just.practicessssss.vo.Freeboard;

public interface FreeboardMapper {

	Page getPage(Page pvo);

	List<Freeboard> getBoard(Page result);

	List<Freeboard> getNotice();

	int insertFreeboard(Freeboard fb);

	int getNextSeq();

	

}
