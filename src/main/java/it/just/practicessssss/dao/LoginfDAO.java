package it.just.practicessssss.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.just.practicessssss.vo.Userinfo;

@Repository
public class LoginfDAO {
	
	@Autowired
	SqlSession sqlsession;

	public String login(Userinfo uif) {
		LoginMapper mapper = sqlsession.getMapper(LoginMapper.class);
		String result = mapper.login(uif);
		if(result==null || result.length()<1) {
			return null;
		}
		return result;
	}
	
	
}
