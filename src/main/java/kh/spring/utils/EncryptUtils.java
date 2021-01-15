package kh.spring.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class EncryptUtils {
	public static String getSHA256(String input) throws Exception{

		String toReturn = null;
		
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			digest.reset();
			digest.update(input.getBytes("utf8"));
			toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));
		

		return toReturn;
	}
}
