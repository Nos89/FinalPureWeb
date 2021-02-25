package kh.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dto.CloudDTO;
import kh.spring.dto.DirectoryDTO;
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
	@Transactional
	public NexacroResult onload() {
		NexacroResult nr = new NexacroResult();
		System.out.println("onload event");
		String loginID = (String) session.getAttribute("loginID");
		if( loginID.contentEquals("") || loginID == null ) {
			nr.setErrorCode(-1);
			nr.setErrorMsg("로그인 정보를 확인해주세요.");
			return nr;
		} else {
			nr.addDataSet("outds_dirList", wservice.getList(loginID));
			nr.addVariable("storage", wservice.getStorage(loginID));
			nr.setErrorCode(1);
			return nr;
		}
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
				nr.setErrorCode(-1);
				nr.setErrorMsg("파일 저장 실패");
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
	public NexacroResult getIndir(@ParamVariable(name = "parentID") int parentID) {
		NexacroResult nr = new NexacroResult();
		String loginID = (String) session.getAttribute("loginID");
		if( loginID.contentEquals("") || loginID == null ) {
			nr.setErrorCode(-1);
			nr.setErrorMsg("로그인 정보를 확인해주세요.");
			return nr;
		} else {
			List<InDirDTO> list = wservice.getInDir(loginID, parentID);
			nr.addDataSet("out_indir", wservice.getInDir(loginID, parentID));
			nr.setErrorCode(1);
			return nr;
		}
	}

	// 파일 및 폴더 삭제
	@RequestMapping("/delete")
	@Transactional
	public NexacroResult delIndir(@ParamVariable(name = "name") String name, @ParamVariable(name = "location") int location,
			@ParamVariable(name = "isFolder") boolean isFolder, HttpServletRequest request) {
		NexacroResult nr = new NexacroResult();

		System.out.println("삭제 " + name + " : " + location + " : " + isFolder);
		
		String userID = (String) session.getAttribute("loginID");
		String filePath = request.getSession().getServletContext().getRealPath("/resources/webhard/");

		if (isFolder) {
			System.out.println("Folder 삭제");
			Map<String, Object> result = wservice.delFolder(location, name, userID);
			List<CloudDTO> flist = (ArrayList<CloudDTO>) result.get("flist");
			for (int i = 0; i < flist.size(); i++) {
				this.delFile(flist.get(i).getFile_savedName(), flist.get(i).getFile_location(), filePath);
			}
			nr.addDataSet("out_directory", result.get("directory"));
			nr.setErrorCode(2);
		} else {
			System.out.println("File 삭제");
			this.delFile(name, location, filePath);
			wservice.delFile(name, location);
			nr.setErrorCode(1);
			nr.setErrorMsg("Delete File Success");
		}
		return nr;
	}

	// 파일 삭제
	private void delFile(String name, int location, String filePath) {
		File delFile = new File(filePath + "/" + name);
		if (delFile.exists()) {
			System.out.println("파일 존재");
			delFile.delete();
		}
	}

	// 파일 다운로드
	@RequestMapping("downFile")
	public NexacroResult downFile(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("File Down Request");

		NexacroResult nr = new NexacroResult();

		String filePath = request.getSession().getServletContext().getRealPath("/resources/webhard/");

		String name = request.getParameter("filename");
		String oriname = request.getParameter("oriname");

		File targetFile = new File(filePath + name);
		if (targetFile.exists()) {
			try {
				FileInputStream fis = new FileInputStream(targetFile);
				OutputStream out = response.getOutputStream();

				response.setContentType("application/octet-stream; charset=utf8");
				response.setContentLength((int) targetFile.length());

				String browser = getBrowser(request);
				String encodedFilename = this.encodingFileName(browser, oriname);
				response.setHeader("Content-Disposition", "attachment; filename=" + encodedFilename);
				if ("Opera".equals(browser)) {
					response.setContentType("application/octet-stream;charset=UTF-8");
				}

				FileCopyUtils.copy(fis, out);
				nr.setErrorCode(1);
				System.out.println("fileDownload filename==>" + oriname + ", 전송완료. ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("fileDownload filename==>" + oriname + ", 파일없음.");
			nr.setErrorCode(-1);
			nr.setErrorMsg("파일이 존재하지 않습니다.");
		}
		return nr;
	}

	// 한글 파일 이름 브라우저 별 인코딩 처리
	private String encodingFileName(String browser, String filename) throws Exception {
		String encodedFilename = null;
		System.out.println("=================================" + browser + "=============================");
		if (browser.equals("MSIE")) {
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
			return encodedFilename;
		} else if (browser.equals("Trident")) { // IE11 문자열 깨짐 방지
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
			return encodedFilename;
		} else if (browser.equals("Firefox")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
			return URLDecoder.decode(encodedFilename);
		} else if (browser.equals("Opera")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
			return encodedFilename;
		} else if (browser.equals("Chrome")) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < filename.length(); i++) {
				char c = filename.charAt(i);
				if (c > '~') {
					sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} else {
					sb.append(c);
				}
			}
			encodedFilename = sb.toString();
			return encodedFilename;
		} else if (browser.equals("Safari")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
			encodedFilename = URLDecoder.decode(encodedFilename);
			return encodedFilename;
		} else {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
			return encodedFilename;
		}
	}

	// 브라우저 이름
	private String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		if (header.indexOf("MSIE") > -1) {
			return "MSIE";
		} else if (header.indexOf("Trident") > -1) { // IE11 문자열 깨짐 방지
			return "Trident";
		} else if (header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if (header.indexOf("Opera") > -1) {
			return "Opera";
		} else if (header.indexOf("Safari") > -1) {
			return "Safari";
		}
		return "Firefox";
	}

	// 디렉토리 이동
	@RequestMapping("/moveContents")
	public NexacroResult moveContents(@ParamVariable(name = "name") String name, @ParamVariable(name = "location") int location,
			@ParamVariable(name = "moveLocation") int moveLocation, @ParamVariable(name = "type") String type) {
		System.out.println("Move Contents Request");
		String id = (String) session.getAttribute("loginID");
		System.out.println(name + " : " + location + " : " + moveLocation + " : " + type);
		NexacroResult nr = new NexacroResult();
		int result = 0;
		if (type.contentEquals("folder")) {
			// 폴더 이동
			result = wservice.moveFolder(id, name, location, moveLocation);
		} else {
			// 파일 이동
			result = wservice.moveFile(name, moveLocation);
		}
		if (result > 0) {
			nr.setErrorCode(1);
			if( type.contentEquals("folder") ) {
			}
		} else {
			nr.setErrorCode(-1);
		}
		return nr;
	}
	
	// 디렉토리 목록 다시 가져오기
	@RequestMapping("/getDirectory")
	public NexacroResult getDirectory() {
		NexacroResult nr = new NexacroResult();
		
		String loginID = (String)session.getAttribute("loginID");
		if( loginID.contentEquals("") || loginID == null ) {
			nr.setErrorCode(-1);
			nr.setErrorMsg("로그인 정보를 확인해주세요.");
			return nr;
		} else {
			nr.addDataSet("out_directory", wservice.getList(loginID));
			nr.setErrorCode(1);
			return nr;
		}
	}
}
