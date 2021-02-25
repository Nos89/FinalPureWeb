package kh.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
			System.out.println( d.getDirID() + " : " + d.getDirectoryName());
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
	
	public int getStorage(String userID) {
		return wdao.getStorage(userID);
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
		
		List<DirectoryDTO> listAll = this.getList(id);
		
		System.out.println(dirList.size() + " : " + parentID + " : " + listAll.get(0).getDirID());
		if( dirList.size() != 0 ) {
			if( dirList.get(0).getLv() != 1 ) {
				InDirDTO i = new InDirDTO();
				i.setName("...");
				i.setIsFolder("true");
				indirList.add(i);
			}
		} else {
			if( listAll.get(0).getDirID() != parentID ) {
				InDirDTO i = new InDirDTO();
				i.setName("...");
				i.setIsFolder("true");
				indirList.add(i);
			} 
		}
		
		for( DirectoryDTO d : dirList ) {
			InDirDTO i = new InDirDTO();
			i.setName(d.getDirectoryName());
			i.setIsFolder("true");
			i.setSavedName(d.getDirectoryName());
			i.setSize(wdao.getFolderSize(d.getDirID()));
			i.setDate(d.getCrtDate());
			indirList.add(i);
		}
		for( CloudDTO c : fileList ) {
			InDirDTO i = new InDirDTO();
			i.setName(c.getFile_oriName());
			i.setIsFolder("false");
			i.setSize(c.getFile_size());
			i.setDate(c.getFile_date());
			i.setSavedName(c.getFile_savedName());
			indirList.add(i);
		}
		return indirList;
	}
	
	// 파일 삭제
	public int delFile(String name, int location ) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("location", location);
		return wdao.delFile(map);
	}
	
	// 폴더 삭제
	@Transactional
	public Map<String, Object> delFolder(int parentID, String name, String userID) {
		// 하위 폴더들 가져오기
		List<DirectoryDTO> delList = new ArrayList<>();
		List<DirectoryDTO> directoryList = this.getList(userID);
		
		for( DirectoryDTO d : directoryList ) {
			if( d.getParentID() == parentID && d.getDirectoryName().contentEquals(name)) {
				delList.add(d);
			} else if( delList.size() != 0){
				System.out.println(delList.size());
				if( d.getLv() > delList.get(0).getLv() ) {
					delList.add(d);
				} else {
					break;
				}
			}
		}
		for( DirectoryDTO d : delList ) {
			System.out.println(d.getDirectoryName());
		}
		
		// 하위 폴더 내 파일 정보
		List<CloudDTO> clist = new ArrayList<>();
		for( DirectoryDTO d : delList ) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", userID);
			map.put("parentID", d.getDirID());
			clist.addAll(wdao.getFiles(map));
		}
		
		for( CloudDTO c : clist ) {
			System.out.println(c.getFile_oriName());
		}
		// 폴더 정보 삭제 로직
		if( delList.size() != 0) {
			wdao.delFolder(delList);
		}
		if( clist.size() != 0 ) {
			wdao.delFileByFolder(clist);
		}
		
		// return Map setting
		Map<String, Object> result = new HashMap<>();
		result.put("directory", this.getList(userID));
		result.put("flist", clist);
		return result;
	}
	
	// 삭제 폴더 하위 폴더들 모두 가져오기
	private List<DirectoryDTO> getFolders(int parentID, List<DirectoryDTO> delList ){
		
		return delList;
	}
	
	// 폴더 이동
	public int moveFolder( String id, String name, int location, int moveLocation ) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		map.put("location", location);
		map.put("moveLocation", moveLocation);
		return wdao.moveFolder(map);
	}
	
	// 파일 이동
	public int moveFile( String name, int moveLocation ) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("moveLocation", moveLocation);
		return wdao.moveFile(map);
	}
}
