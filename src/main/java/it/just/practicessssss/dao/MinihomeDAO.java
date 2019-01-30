package it.just.practicessssss.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.just.practicessssss.mapper.MinihomeMapper;
import it.just.practicessssss.vo.Minihome;

@Repository
public class MinihomeDAO {

	@Autowired
	SqlSession session;

	public Minihome selectOne(int minih_seq) {
		Minihome result = null;
		
		MinihomeMapper mapper = session.getMapper(MinihomeMapper.class);
		result = mapper.selectOne(minih_seq);
		
		return result;
	}
	
}
