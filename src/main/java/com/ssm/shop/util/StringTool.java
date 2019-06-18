package com.ssm.shop.util;

import java.io.UnsupportedEncodingException;

/**
 * 字符串工具类
 * @author bojiangzhou
 *
 */
public class StringTool {
	
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return true: 空 | false: 不为空
	 */
	public static boolean isEmpty(String str){
		if(str == null || "".equals(str.trim())){
			return true;
		} else{
			return false;
		}
	}
	
	/**
	 * 将get方式传来的中文转为UTF-8格式
	 * @param str
	 * @return
	 */
	public static String messyCode(String str){
		String code = null;
		try {
			byte[] by = str.getBytes("ISO-8859-1");
			code = new String(by, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return code;
	}
	
	
	/**
	 * 判断参数是否为空
	 * @param param[] name[]
	 * @return String error
	 */
	public static String isEmpty(String[] param, String[] name){
		String error = "";
		for(int i=0; i<param.length; i++){
			if(param[i] == null || "".equals(param[i].trim())){
				error += ""+name[i]+"参数为空！";
			} 
		}
		return error;
	}
	
}
