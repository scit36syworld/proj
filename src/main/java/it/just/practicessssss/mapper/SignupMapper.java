package it.just.practicessssss.mapper;

import it.just.practicessssss.vo.Userinfo;

public interface SignupMapper {

	int idcheck(String userid);

	int insertUserinfo(Userinfo uif);

}
