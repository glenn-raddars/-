package com.travel.util;

public class StringDeal {
	//�Ƿ�Ϊ�մ�
		public static boolean isEmpty(String str)
		{
			if(str==null || "".equals(str.trim()))
				return true;
			else
				return false;
		}
		//�Ƿ�Ϊ�մ�
		public static boolean isNotEmpty(String str)
		{
			if(str!=null && !"".equals(str.trim()))
				return true;
			else
				return false;
		}
}
