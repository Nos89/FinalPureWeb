package kh.spring.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.CommentsDTO;
import kh.spring.service.BoardService;
import kh.spring.service.CommentService;

@Controller
@RequestMapping("/main")
public class MainBoardController {

	@Autowired
	HttpSession session;
	@Autowired
	BoardService bservice;
	@Autowired
	CommentService cservice;

	// 게시글 목록 보기
	@RequestMapping("/board.list")
	public String boardList(String pageGroup, String type, String page, Model model) {
		int currentPage = this.convertPage(page);
		session.setAttribute("loginID", "test");
		model.addAttribute("pageGroup", pageGroup);
		model.addAttribute("type", type);
		model.addAttribute("cont", bservice.getArticles(type, currentPage));
		model.addAttribute("page", currentPage);
		model.addAttribute("list", true);
		return "main/" + pageGroup + "/board";
	}

	// 게시판 작성 페이지로 전환
	@RequestMapping("/board")
	public String converseWritePage(String pageGroup, String type, String page, Model model) {
		model.addAttribute("pageGroup", pageGroup);
		model.addAttribute("type", type);
		model.addAttribute("write", true);
		model.addAttribute("page", this.convertPage(page));
		return "main/" + pageGroup + "/board";
	}

	// 게시글 작성 로직
	@RequestMapping("/board.write")
	public String writeArticle(String pageGroup, String type, BoardDTO bdto, Model model) {
		bdto.setBoardType(type);
		bdto.setWriter((String) session.getAttribute("loginID"));
		bservice.writeArticle(bdto);
		model.addAttribute("pageGroup", pageGroup);
		model.addAttribute("type", type);
		return "redirect:/main/board.list";
	}

	// 이미지 업로드 로직
	@RequestMapping(value="/uploadSummernoteImageFile", produces = "application/json; charset=utf8")
	@ResponseBody
	public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request )  {
		JsonObject jsonObject = new JsonObject();
		
		// 내부경로로 저장
		String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/");
		String fileRoot = contextRoot+"resources/img/board_free/";
		
		String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
		String savedFileName = UUID.randomUUID().toString().replaceAll("-", "") + extension;	//저장될 파일 명
		
		File targetFile = new File(fileRoot + savedFileName);	
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
			jsonObject.addProperty("url", "/boardImg/"+savedFileName); // contextroot + resources + 저장할 내부 폴더명
			jsonObject.addProperty("responseCode", "success");
				
		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	// 게시글 보기
	@RequestMapping("/board.view")
	public String viewArticle(String pageGroup, String type, int seq, String page, String purp, String commentPage, String search, Model model) {
		model.addAttribute("article", bservice.viewArticle(type, seq));
		model.addAttribute("pageGroup", pageGroup);
		model.addAttribute("type", type);
		model.addAttribute("page", this.convertPage(page));
		model.addAttribute("seq", seq);
		if( purp.contentEquals("modify")) {
			model.addAttribute("modify", true);
		} else {
			model.addAttribute("view", true);
		}
		if( search != null ) {
			model.addAttribute("search", search);
		}
		// 댓글
		model.addAttribute("commentPage", this.convertPage(commentPage));
		model.addAttribute("comments", cservice.getComments(seq, this.convertPage(commentPage)));
		return "main/" + pageGroup + "/board";
	}
	
	// 댓글 작성
	@RequestMapping(value="/insert.comments", produces="text/plain; charset=UTF8")
	@ResponseBody
	public String insertComments( CommentsDTO cdto, String commentPage ) {
		cservice.insertComment(cdto.getParent_code(), cdto.getWriter(), cdto.getContents());
		return this.ajaxGetComments(cdto.getParent_code(), 1);
	}
	
	// 댓글 삭제
	@RequestMapping(value="/delete.comments", produces="text/plain; charset=UTF8")
	@ResponseBody
	public String deleteComments( CommentsDTO cdto, String commentPage ) {
		cservice.deleteComment(cdto.getSeq());
		System.out.println(commentPage);
		return this.ajaxGetComments(cdto.getParent_code(), this.convertPage(commentPage));
	}
	
	private String ajaxGetComments( int parent_code, int commentPage ) {
		Map<String, Object> comments = cservice.getComments(parent_code, commentPage);
		Gson gson = new Gson();
		JsonArray arr = new JsonArray();
		arr.add(gson.toJson(comments.get("navi")));
		arr.add(gson.toJson(comments.get("list")));
		return arr.toString();
	}
	
	// 게시글 삭제
	@RequestMapping("/board.delete")
	public String deleteArticle(String pageGroup, String type, int seq, Model model) {
		bservice.deleteArticle(type, seq);
		model.addAttribute("pageGroup", pageGroup);
		model.addAttribute("type", type);
		return "redirect:/main/board.list";
	}
	
	// 게시글 수정
	@RequestMapping("/board.modify")
	public String modifyArticle(String pageGroup, String type, BoardDTO bdto, String page, Model model) {
		bservice.modifyArticle(bdto, type);
		model.addAttribute("pageGroup", pageGroup);
		model.addAttribute("type", type);
		model.addAttribute("page", this.convertPage(page));
		model.addAttribute("seq", bdto.getSeq());
		model.addAttribute("purp", "view");
		return "redirect:/main/board.view";
	}
	
	// 게시판 검색
	@RequestMapping("/board.search")
	public String boardSearch(String pageGroup, String type, String search, String page, Model model) {
		int currentPage = this.convertPage(page);
		model.addAttribute("pageGroup", pageGroup);
		model.addAttribute("type", type);
		model.addAttribute("search", search);
		model.addAttribute("page", currentPage);
		model.addAttribute("cont",bservice.boardSearch(type, search, currentPage));
 		model.addAttribute("page", currentPage);
		model.addAttribute("list", true);
		return "main/"+pageGroup+"/board";
	}
	
	// 페이지 유효성
	private int convertPage( String page ) {
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(page);
			System.out.println(currentPage);
		} catch(Exception e ) {
			currentPage = 1;
		}
		return currentPage;
	}
}
