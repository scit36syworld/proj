package it.just.practicessssss.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.just.practicessssss.vo.Filemng;

@Repository
public class FileDAO {

	@Autowired
	SqlSession sqlsession;

	public int insertFile(Filemng fm) {
		FileMapper mapper = sqlsession.getMapper(FileMapper.class);
		int result = mapper.insertFile(fm);
		
		return result;
	}

	public int getSeqUpload() {
		FileMapper mapper = sqlsession.getMapper(FileMapper.class);
		int map = mapper.getSeqUpload();
		return map;
	}

	public int setUploadfile(int board_seq, int file_seq) {
		FileMapper mapper = sqlsession.getMapper(FileMapper.class);
		int result = mapper.setUploadfile(board_seq,file_seq);
		
		return result;
	}
}
