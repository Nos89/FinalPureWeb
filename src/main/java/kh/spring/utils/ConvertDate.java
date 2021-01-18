package kh.spring.utils;

import java.sql.Date;

public class ConvertDate {
	public static Date utilToSql(java.util.Date util) {
		return new java.sql.Date(util.getTime());
	
	}
	
	
	public static java.util.Date sqlToUtil(java.sql.Date sql){
		return new java.util.Date(sql.getTime());
		
	}
}
