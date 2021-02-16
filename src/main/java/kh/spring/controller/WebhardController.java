package kh.spring.controller;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dto.InDirDTO;
import kh.spring.service.WebhardService;

@Controller
@RequestMapping("/webhard")
public class WebhardController {

	@Autowired
	HttpSession session;
	@Autowired
	WebhardService wservice;

	@RequestMapping("/onload")
	public NexacroResult onload() {
		NexacroResult nr = new NexacroResult();
		String loginID = (String) session.getAttribute("loginID");
		nr.addDataSet("outds_dirList", wservice.getList(loginID));
		return nr;
	}

	@RequestMapping("/upload")
	public NexacroResult upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Request : File Upload");
		NexacroResult nr = new NexacroResult();
		if (!(request instanceof MultipartHttpServletRequest)) {
			System.out.println("Request is not Files");
			return new NexacroResult();
		}

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//		Enumeration<String> parameterNames = multipartRequest.getParameterNames();
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		String loginID = (String) session.getAttribute("loginID");
		int parentID = Integer.parseInt(request.getParameter("dir"));
		System.out.println(parentID);

		String filePath = request.getSession().getServletContext().getRealPath("/resources/webhard/");
		System.out.println(filePath);

		Set<String> keySet = fileMap.keySet();
		for (String name : keySet) {
			MultipartFile multipartFile = fileMap.get(name);
			// original File name
			String originalFilename = multipartFile.getOriginalFilename();
			System.out.println(originalFilename);
			// saved File name
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
			String savedName = UUID.randomUUID().toString().replaceAll("-", "") + extension;
			// create File
			File targetFile = new File(filePath + savedName);
			try {
				// save File
				InputStream fileStream = multipartFile.getInputStream();
				FileUtils.copyInputStreamToFile(fileStream, targetFile);
				// get File
				File savedFile = new File(filePath + savedName);
				// set File Size
				long size = 0;
				if (savedFile.exists()) {
					size = savedFile.length();
				}
				System.out.println(size);
				// save File Information
				wservice.saveFile(loginID, parentID, originalFilename, savedName, size);
				System.out.println("save complete");
				nr.setErrorCode(1);
				nr.setErrorMsg("파일 저장 완료.");
				nr.addDataSet("out_indir", wservice.getInDir(loginID, parentID));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return nr;
	}

	@RequestMapping("/createFolder")
	public NexacroResult createFolder(@ParamVariable(name = "nFolder") String nFolder,
			@ParamVariable(name = "parentID") int parentID) {
		System.out.println(nFolder + " : ");
		String loginID = (String) session.getAttribute("loginID");
		NexacroResult nr = new NexacroResult();

		int result = wservice.createFolder(parentID, nFolder, loginID);
		System.out.println(result);

		if (result > 0) {
			nr.setErrorCode(1);
			nr.setErrorMsg("Success");
			nr.addDataSet("outds_dirList", wservice.getList(loginID));
			nr.addDataSet("out_indir", wservice.getInDir(loginID, parentID));
			nr.addVariable("parentID", parentID);
			System.out.println("Success");
		} else {
			nr.setErrorCode(-1);
			nr.setErrorMsg("Fail");
			System.out.println("Fail");
		}
		return nr;
	}

	@RequestMapping("/getFiles")
	public NexacroResult getFiles(@ParamVariable(name = "parentID") int parentID) {
		String id = (String) session.getAttribute("loginID");
		System.out.println("Request : getFiles - " + parentID);
		NexacroResult nr = new NexacroResult();
		nr.addDataSet("out_files", wservice.getFiles(id, parentID));
		return nr;
	}
	
	@RequestMapping("/getIndir")
	public NexacroResult getIndir(@ParamVariable(name="parentID") int parentID) {
		String id = (String)session.getAttribute("loginID");
		NexacroResult nr = new NexacroResult();
		List<InDirDTO> list = wservice.getInDir(id, parentID);
		if( list.size() != 0 ) {
			nr.addDataSet("out_indir", wservice.getInDir(id, parentID));
		}
		return nr;
	}
}
