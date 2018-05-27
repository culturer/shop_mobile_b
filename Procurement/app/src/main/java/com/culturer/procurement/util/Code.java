package com.culturer.procurement.util;

import java.io.UnsupportedEncodingException;

public class Code {
	public static String encode(String str) throws UnsupportedEncodingException {
		return java.net.URLEncoder.encode(str,"utf-8");
	}
	
	public static  String decode(String str) throws UnsupportedEncodingException {
		return java.net.URLDecoder.decode(str,   "utf-8");
	}
}
