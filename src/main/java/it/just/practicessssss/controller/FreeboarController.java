package it.just.practicessssss.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import it.just.practicessssss.dao.FileDAO;
import it.just.practicessssss.dao.FreeboardDAO;
import it.just.practicessssss.util.FileService;
import it.just.practicessssss.util.Page;
import it.just.practicessssss.vo.Filemng;
import it.just.practicessssss.vo.Freeboard;

@Controller
public class FreeboarController {

	@Autowired
	FreeboardDAO fdao;
	
	@Autowired
	FileDAO fd;
	
	private String uploadpath = "d:/syworld/board/";
	private int view=10;
	
	private static final Logger logger = LoggerFactory.getLogger(FreeboarController.class);
	
	@RequestMapping(value="freeboardmain", method=RequestMethod.GET)
	public String freeboardmain(Model model, Page pvo) {
		
		if(pvo.getPage()==0) {
			pvo.setPage(1);
		}
		if(pvo.getSearchtype()==null || pvo.getSearchvalue().length()==0) {
			pvo = new Page(pvo.getPage(), view);			
		} else {
			pvo = new Page(pvo.getPage(), view, pvo.getSearchtype(),pvo.getSearchvalue());
		}
		logger.info("{}",pvo);
		Page result = fdao.getPage(pvo);
		pvo.setLast(result.getLast());
		if(pvo.getFirst()>pvo.getLast()) {
			pvo.setLast(pvo.getFirst());
		}
		if(pvo.getLast()<pvo.getPageend()) {
			pvo.setPageend(pvo.getLast());
		}
		logger.info("{}",pvo);
		model.addAttribute("pvo", pvo);
		List<Freeboard> notice = fdao.getNotice();
		List<Freeboard> list = fdao.getBoard(pvo);
		logger.info("{}",list+"controller");
		model.addAttribute("notice", notice);
		model.addAttribute("list",list);
		return "freeboardmain";
	}
	
	@RequestMapping(value="freeboardsearchpage", method=RequestMethod.GET)
	public String freeboardsearchpage(Model model, Page pvo) {
		Page result = fdao.getPage(pvo);
		if(pvo.getSearchtype()!=null) {
			result.setSearchtype(pvo.getSearchtype());
			result.setSearchvalue(pvo.getSearchvalue());
		}
		model.addAttribute("page", result);
		return "freeboardmain";
	}
	
	@RequestMapping(value="freeboardwrite", method=RequestMethod.GET)
	public String boardwrite() {
		
		return "freeboardwrite";
	}
	
	@RequestMapping(value="gofreeboardwrite", method=RequestMethod.POST)
	public String sendfreeboardwrite(Freeboard fb, MultipartFile upload, HttpSession session,Model model) {
		logger.info("{}",fb);
		logger.info("{}",upload);
		int result = fdao.insertFreeboard(fb);
		if(!upload.isEmpty()) {
			String path = uploadpath + fb.getBoardname(); //"d:/syworld/board/"+"freeboard"
			
			int file_seq = fd.getSeqUpload();
			int board_seq = fdao.getNextSeq();
			
			logger.info("{}",file_seq);
			String savename=board_seq+"_"+"1";		//map.get("files");
			savename = FileService.saveFile(upload, path, savename);
			Filemng fm = new Filemng(file_seq,upload.getOriginalFilename(), savename, path);
			logger.info("{}",fm);
			int up = fd.insertFile(fm);
			if(up!=1) {
				FileService.deleteFile(path+"/"+savename);
				model.addAttribute("msg", "파일 업로드 에러 다시 시도해주세요");
				return "freeboardwrite";
			}
			fb.setUploadfile(file_seq);
			logger.info("업로드완료");
		}
		logger.info("{}",fb);
		return "freeboardwrite";
	}
	
	
}
