package it.just.practicessssss.dao;

import java.util.List;

import it.just.practicessssss.util.Page;
import it.just.practicessssss.vo.Freeboard;
import it.just.practicessssss.vo.Freeboardcomment;

public interface FreeboardMapper {

	Page getPage(Page pvo);

	List<Freeboard> getBoard(Page result);

	List<Freeboard> getNotice();

	int insertFreeboard(Freeboard fb);

	int getNextSeq();

	Freeboard freeboardSelectOne(int board_seq);

	List<Freeboardcomment> freeboardComments(int board_seq);

	

}
