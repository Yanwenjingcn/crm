package com.ywj.utils;

import java.util.UUID;

/*
 * 文件上传相关工具
 */

public class UploadUtils {
/*
 * 将文件名替换成uuid,使之唯一
 */
	public static String getUUIDName(String filename){
		int index=filename.lastIndexOf(".");
		//获取图片文件的后缀名
		String lastName=filename.substring(index, filename.length());
		//取得一个新的uuid
		String uuid=UUID.randomUUID().toString().replace("-", "");
		return uuid+lastName;	
	}
}
