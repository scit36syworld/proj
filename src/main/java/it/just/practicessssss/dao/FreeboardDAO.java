package it.just.practicessssss.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.just.practicessssss.util.Page;
import it.just.practicessssss.vo.Freeboard;
import it.just.practicessssss.vo.Freeboardcomment;

@Repository
public class FreeboardDAO {

	@Autowired
	SqlSession sqlsession;

	public Page getPage(Page pvo) {
		FreeboardMapper mapper = sqlsession.getMapper(FreeboardMapper.class);
		Page result = mapper.getPage(pvo);
		return result;
	}

	public List<Freeboard> getBoard(Page result) {
		FreeboardMapper mapper = sqlsession.getMapper(FreeboardMapper.class);
		List<Freeboard> list = mapper.getBoard(result);
		System.out.println(list + "dao");
		
		return list;
	}

	public List<Freeboard> getNotice() {
		FreeboardMapper mapper = sqlsession.getMapper(FreeboardMapper.class);
		List<Freeboard> list = mapper.getNotice();
		return list;
	}

	public int insertFreeboard(Freeboard fb) {
		FreeboardMapper mapper = sqlsession.getMapper(FreeboardMapper.class);
		int result = mapper.insertFreeboard(fb);
		return result;
	}

	public int getNextSeq() {
		FreeboardMapper mapper = sqlsession.getMapper(FreeboardMapper.class);
		int result = mapper.getNextSeq();
		return result;
	}

	public Freeboard freeboardSelectOne(int board_seq) {
		FreeboardMapper mapper = sqlsession.getMapper(FreeboardMapper.class);
		Freeboard result = mapper.freeboardSelectOne(board_seq);
		return result;
	}

	public List<Freeboardcomment> freeboardComments(int board_seq) {
		FreeboardMapper mapper = sqlsession.getMapper(FreeboardMapper.class);
		List<Freeboardcomment> list = mapper.freeboardComments(board_seq);
		return list;
	}
}
