package it.just.practicessssss.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.just.practicessssss.mapper.MinihitsMapper;
import it.just.practicessssss.vo.Minihits;

@Repository
public class MinihitsDAO {

	@Autowired
	SqlSession session;

	public ArrayList<String> selectOne(int userid) {
		ArrayList<String> result = null;

		MinihitsMapper mapper = session.getMapper(MinihitsMapper.class);
		result = mapper.selectOne(userid);

		return result;
	}

	public int insertOne(int userid, int visitorid) {
		int result = 0;

		Minihits insert = new Minihits();
		insert.setUserid(userid);
		insert.setVisitorid(visitorid);
		MinihitsMapper mapper = session.getMapper(MinihitsMapper.class);
		result = mapper.insertOne(insert);

		return result;
	}

}
