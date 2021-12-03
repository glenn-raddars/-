package com.travel.util;

public class StringDeal {
	//是否为空串
		public static boolean isEmpty(String str)
		{
			if(str==null || "".equals(str.trim()))
				return true;
			else
				return false;
		}
		//是否不为空串
		public static boolean isNotEmpty(String str)
		{
			if(str!=null && !"".equals(str.trim()))
				return true;
			else
				return false;
		}
}
