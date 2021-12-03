package com.travel.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.travel.util.Dbutil;

public class Dbutil {

	private String dbUrl = "jdbc:mysql://localhost:3306/travel?characterEncoding=utf-8&serverTimezone=GMT";
	private String dbUserName="root";//用户名
	private String dbPassword="cxh010506";//密码
	private String jdbcName="com.mysql.cj.jdbc.Driver";//驱动名称
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	
	public Connection getCon()throws Exception
	{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	
	public void clossCon(Connection con)throws Exception
	{
		if(con!=null)
		{
			con.close();
		}
	}
	
	public static void main(String[] args) 
	{
		Dbutil dbUtil = new Dbutil();
		try 
		{
			dbUtil.getCon();
			System.out.println("数据库连接成功!");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败!");
		}
	}
}
