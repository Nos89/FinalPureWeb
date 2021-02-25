package kh.spring.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ConvertDate {
	public static Date utilToSql(java.util.Date util) {
		return new java.sql.Date(util.getTime());
	
	}
	
	public static java.util.Date sqlToUtil(java.sql.Date sql){
		return new java.util.Date(sql.getTime());
		
	}
	
	// String to Date
	public static Date stringToDate(String str) throws Exception {
		if(str==null||str.trim().isEmpty()) {
			return null;
		}else {
			System.out.println("original String: "+str);
			str = str.substring(0, 8);
			System.out.println("modified String: "+str);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			java.util.Date uDate = sdf.parse(str);
			System.out.println("uDate: "+uDate);
			Date sDate = utilToSql(uDate);
			System.out.println("sDate: "+sDate);
			return sDate;
		}
	}
	
	// Date to String
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}
}
