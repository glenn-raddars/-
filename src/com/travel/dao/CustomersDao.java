package com.travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.travel.model.Bus;
import com.travel.model.Customers;
import com.travel.util.StringDeal;

public class CustomersDao {
	//增加顾客
	public int add(Connection con,Customers customers)throws Exception
	{
		String sql = "insert into customers values(?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, customers.getCustName());
		pstmt.setString(2, customers.getCustID());
		return pstmt.executeUpdate();
	}
	//查询用户信息集合
	public ResultSet list(Connection con,Customers customers)throws Exception{
		StringBuffer sb = new StringBuffer("select * from customers");
		//当flightNum不为空时才加上查询条件
		if(StringDeal.isNotEmpty(customers.getCustName())) {
			sb.append(" and custName like '%"+customers.getCustName()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));//将上述字符串中的and替换成where
		//返回结果集
		return pstmt.executeQuery();
	}
	
	public int update(Connection con,Customers customers)throws Exception{
		String sql = "update customers set custID=? where custName=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, customers.getCustID());//原理同上
		pstmt.setString(2, customers.getCustName());
		
		return pstmt.executeUpdate();
	}
}
