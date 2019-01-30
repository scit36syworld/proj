package it.just.practicessssss.dao;

import org.apache.ibatis.annotations.Param;

import it.just.practicessssss.vo.Filemng;

public interface FileMapper {

	int insertFile(Filemng fm);

	int getSeqUpload();

	int setUploadfile(@Param("board_seq")int board_seq,@Param("file_seq") int file_seq);

	

}
