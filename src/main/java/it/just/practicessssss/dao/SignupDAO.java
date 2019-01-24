package it.just.practicessssss.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.just.practicessssss.vo.Userinfo;

@Repository
public class SignupDAO {
	
	@Autowired
	SqlSession sqlsession;

	public int idcheck(String userid) {
		SignupMapper mapper = sqlsession.getMapper(SignupMapper.class);
		int result = mapper.idcheck(userid);
		
		if(result == 1) {
			return result;
		}
		
		return 0;
	}

	public int insertUserinfo(Userinfo uif) {
		SignupMapper mapper = sqlsession.getMapper(SignupMapper.class);
		int result = mapper.insertUserinfo(uif);
		return 0;
	}
}
