package kh.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.WebhardDAO;
import kh.spring.dto.CloudDTO;
import kh.spring.dto.DirectoryDTO;
import kh.spring.dto.InDirDTO;

@Service
public class WebhardService {
	@Autowired
	WebhardDAO wdao;
	
	// Directory List
	public List<DirectoryDTO> getList(String userID){
		// DB 에서 LV로 정렬해서 가져온 List
		List<DirectoryDTO> list = wdao.getList(userID);

		// Tree 구조로 정렬해서 넣을 List
		List<DirectoryDTO> olist = new ArrayList<>();
		// 가져온 list에 대한 반복자
		Iterator<DirectoryDTO> iter = list.iterator();
		
		// 정렬
		while(iter.hasNext()) {
			DirectoryDTO d = iter.next();
			
			// 반복자에서 꺼낸 값이 userID와 같다면 => Root 폴더이므로 바로 olist에 넣기
			if( d.getDirectoryName().contentEquals(userID) ) {
				olist.add(d);
			} else {
				for(DirectoryDTO od : olist ) {
					// 반복자에서 꺼낸 값의 부모 폴더 ID 와 정렬된 olist에서 꺼낸 객체의 폴더 ID가 같은지 확인
					if( d.getParentID() == od.getDirID() ) {

						int index = olist.indexOf(od)+1;
						if( d.getLv() == 1 ) {
							olist.add(d);
							break;
						} else {
							Iterator<DirectoryDTO> oiter = olist.iterator();
							while(oiter.hasNext()) {
								DirectoryDTO oi = oiter.next();
								if( oi.getParentID() == d.getParentID() ) {
									index++;
								}
							}
						}
						olist.add(index, d);
						break;
					}
				}
			}
			iter.remove();
		}
		return olist;
	}
	
	// Create Folder
	public int createFolder( int parentID, String nFolder, String loginID ) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", loginID);
		map.put("dirName", nFolder);
		map.put("parentID", parentID);
		return wdao.createFolder(map);
	}
	
	// 파일 정보 저장
	public int saveFile( String id, int parentID, String oriName, String savedName, long size ) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("parentID", parentID);
		map.put("oriName", oriName);
		map.put("savedName", savedName);
		map.put("size", size);
		return wdao.saveFile(map);
	}
	
	// 폴더 파일 가져오기
	public List<CloudDTO> getFiles( String id, int parentID ){
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("parentID", parentID);
		return wdao.getFiles(map);
	}
	
	// 대상 폴더의 폴더 및 파일 가져오기
	public List<InDirDTO> getInDir( String id, int parentID ){
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("parentID", parentID);
		List<DirectoryDTO> dirList = wdao.getFolder(map);
		List<CloudDTO> fileList = wdao.getFiles(map);
		List<InDirDTO> indirList = new ArrayList<>();
		if( dirList.size() != 0 ) {
			if( parentID == dirList.get(0).getDirID() ) {
				InDirDTO i = new InDirDTO();
				i.setName("...");
				i.setIsFolder("true");
				indirList.add(i);
			}
		} else {
			InDirDTO i = new InDirDTO();
			i.setName("...");
			i.setIsFolder("true");
			indirList.add(i);
		}
		
		for( DirectoryDTO d : dirList ) {
			InDirDTO i = new InDirDTO();
			i.setName(d.getDirectoryName());
			i.setIsFolder("true");
			indirList.add(i);
		}
		for( CloudDTO c : fileList ) {
			InDirDTO i = new InDirDTO();
			i.setName(c.getFile_oriName());
			i.setIsFolder("false");
			i.setSize(c.getFile_size());
			i.setDate(c.getFile_date());
			indirList.add(i);
		}
		return indirList;
	}
}
