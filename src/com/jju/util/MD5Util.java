package com.jju.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	
	public static String getMD5(String str){
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes());
			byte[] bs = md5.digest();
			
			int i;
			StringBuffer buf = new StringBuffer("");  
            for (int offset = 0; offset < bs.length; offset++) {  
                i = bs[offset];  
                if (i < 0)  
                    i += 256;  
                if (i < 16)  
                    buf.append("0");  
                buf.append(Integer.toHexString(i));  
            }  
            //32位加密  
            return buf.toString();  
            // 16位的加密  
            //return buf.toString().substring(8, 24);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
            return null;  
        }  
	}
}
