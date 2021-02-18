package kh.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.nexacro.uiadapter17.spring.core.NexacroException;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dao.BoardDAO;
import kh.spring.dto.FilesDTO;

@Controller
public class BoardFileController {
	private Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final String SP = File.separator;
	private static final String PATH = "resources"+SP+"files"+SP+"board";  //서버 첨부파일 경로
	private static String sUserPath = "";   //사용자 폴더경로
	@Autowired
	private WebApplicationContext appContext;
	
	@Autowired
	private BoardDAO bdao;
	
	/*
    파일 저장 후 저장파일 정보 반환 (화면에서 호출)
	 */     
	@RequestMapping(value = "/uploadBoardFiles.nex" )
	public NexacroResult uploadFiles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("신호옴");
		int f_seq = Integer.parseInt(request.getParameter("param"));
		//MultipartHttpServletRequest 체크
		if(!(request instanceof MultipartHttpServletRequest)) {
			
			if(logger.isDebugEnabled()) {
				logger.debug("Request is not a MultipartHttpServletRequest");
			}
			return new NexacroResult();
		}
		
		logger.debug("-------------------- nexacro platform uploadFiles ---------------------------");


		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		
		List<FilesDTO> list = new ArrayList<>();
		list = uploadMultipartFiles(multipartRequest,f_seq);

		NexacroResult nexacroResult = new NexacroResult();
		nexacroResult.addDataSet("out_ds",list);
		nexacroResult.setErrorCode(0);
		nexacroResult.setErrorMsg("Success");
		return nexacroResult;
	}//uploadFiles




	/*
실제파일 저장 및 저장파일정보 셋팅
	 */
	private List<FilesDTO> uploadMultipartFiles(MultipartHttpServletRequest multipartRequest, int f_seq) throws IOException {
		//DataSet resultDs
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		String filePath = getFilePath();

		Set<String> keySet = fileMap.keySet();
		List<FilesDTO> list= new ArrayList<>();
		for(String name: keySet) {

			MultipartFile multipartFile = fileMap.get(name);
			
			String originalFilename = multipartFile.getOriginalFilename();
			String uid = UUID.randomUUID().toString().replaceAll("-", "");
			String savedName = uid+"_"+originalFilename;
			
			// IE에서 파일업로드 시 DataSet 파라매터의 Content-Type이 설정되지 않아 여기로 옴. 무시.
			if(originalFilename == null || originalFilename.length() == 0) {
				continue;
			}

			File destination = new File(filePath);
			System.out.println(filePath);
			if( destination.exists() == false) {
				boolean mkdirs = destination.mkdirs();
				destination.setWritable(true);

				logger.debug("-------------- create directory ----------------------" + mkdirs);
			}

			//File targetFile = new File(filePath+SP+originalFilename);
			File targetFile = new File(filePath+SP+savedName);
			
			InputStream inputStream = multipartFile.getInputStream();
			FileCopyUtils.copy(inputStream, new FileOutputStream(targetFile));
			
			FilesDTO dto = new FilesDTO(0,f_seq,originalFilename,savedName,null);
			bdao.insertFile(dto);
			list.add(dto);

			logger.debug("uploaded file write success. file="+originalFilename);
		}//for
		
		return list;
	}//uploadMultipartFiles

	/*
파일을 저장할 절대경로 반환    
	 */
	private String getFilePath() {
		ServletContext sc = appContext.getServletContext();
		System.out.println("sc : " + sc);
		String realPath = sc.getRealPath("/");
		
		System.out.println("realPath : "+ realPath );
		String uploadPath = realPath + PATH + sUserPath;
		return uploadPath;
	}//getFilePath


}
