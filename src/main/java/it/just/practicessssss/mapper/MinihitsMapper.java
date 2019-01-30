package it.just.practicessssss.mapper;

import java.util.ArrayList;

import it.just.practicessssss.vo.Minihits;

public interface MinihitsMapper {

	ArrayList<String> selectOne(int userid);

	int insertOne(Minihits insert);
}
