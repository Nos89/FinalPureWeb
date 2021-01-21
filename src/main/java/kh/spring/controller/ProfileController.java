package kh.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
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

import kh.spring.dao.ProFileDAO;
import kh.spring.dto.ProFileDTO;

@Controller
@RequestMapping("/proFile")
public class ProfileController {
	private Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final String SP = File.separator;
	private static final String PATH = "resources"+SP+"ProFile";  //서버 첨부파일 경로
	private static String sUserPath = "";   //사용자 폴더경로
	
	
	@Autowired
	private WebApplicationContext appContext;
	
	@Autowired
	private ProFileDAO pdao;
	/*
    파일 저장 후 저장파일 정보 반환 (화면에서 호출)
	 */     
	@RequestMapping(value = "/uploadImg.nex" )
	public NexacroResult uploadImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");

		System.out.println("신호옴"+id + name);
		//MultipartHttpServletRequest 체크
		if(!(request instanceof MultipartHttpServletRequest)) {
			
			if(logger.isDebugEnabled()) {
				logger.debug("Request is not a MultipartHttpServletRequest");
			}
			return new NexacroResult();
		}
		
		logger.debug("-------------------- nexacro platform uploadFiles ---------------------------");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		//파라미터 처리
		uploadParameters(multipartRequest);
		
		
		int result = uploadMultipartFiles(multipartRequest,id,name);

		NexacroResult nexacroResult = new NexacroResult();
		nexacroResult.setErrorCode(0);
		nexacroResult.setErrorMsg("Success");
		return nexacroResult;
	}//uploadFiles
	
	/*
	  파라미터 셋팅
		 */
		private void uploadParameters(MultipartHttpServletRequest multipartRequest) throws NexacroException {
			// parameter and multipart parameter
			Enumeration<String> parameterNames = multipartRequest.getParameterNames();
			
			while(parameterNames.hasMoreElements()) {

				String parameterName = parameterNames.nextElement();
				if(parameterName == null || parameterName.length() == 0) {
					continue;
				}

				String value = multipartRequest.getParameter(parameterName);

				//화면 FileUpTransfer 의 setPostData 로 셋팅한 저장될 파일경로 String을 셋팅한다. ("file")
				if("filepath".equals(parameterName)) {
					if(value != null && !value.equals("")) {
						// "WEB-INF/attachFile/" + "sample"
						sUserPath = SP + "file";
					}
					continue;                
				}
			}//while
		}//uploadParameters


		/*
	실제파일 저장 및 저장파일정보 셋팅
		 */
		private int uploadMultipartFiles(MultipartHttpServletRequest multipartRequest, String id,String name) throws IOException {
			String filePath = getFilePath();
			int result = 0;
				System.out.println("넘ㄴ어오는중");
				MultipartFile multipartFile = multipartRequest.getFile(name);
				
				String originalFilename = multipartFile.getOriginalFilename();
				String uid = UUID.randomUUID().toString().replaceAll("-", "");
				String savedName = uid+"_"+originalFilename;
				
				// IE에서 파일업로드 시 DataSet 파라매터의 Content-Type이 설정되지 않아 여기로 옴. 무시.
				//if(originalFilename == null || originalFilename.length() == 0) {
				//	continue;
				//}

				File destination = new File(filePath);
				System.out.println(filePath);
				if( destination.exists() == false) {
					boolean mkdirs = destination.mkdirs();
					destination.setWritable(true);

					logger.debug("-------------- create directory ----------------------" + mkdirs);
				}
				ProFileDTO dto = new ProFileDTO(0,id,originalFilename,savedName,null);
				ProFileDTO dto2 = pdao.checkImg(dto.getId());
				if(dto2 != null) {
					//파일있으면 지우기
					File file = new File(filePath+"/"+dto2.getSavedName());
					file.delete();
					pdao.updateImg(dto);
				}else {
					//파일없으면 그대로 입력
				   result = pdao.uploadImg(dto);
				}
				File targetFile = new File(filePath+SP+savedName);
				
				InputStream inputStream = multipartFile.getInputStream();
				FileCopyUtils.copy(inputStream, new FileOutputStream(targetFile));


				logger.debug("uploaded file write success. file="+originalFilename);
			//}//for
			return result;
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
			System.out.println("uploadPath : " + uploadPath);
			return uploadPath;
		}//getFilePath
}
