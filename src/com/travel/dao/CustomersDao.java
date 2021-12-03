package com.travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.travel.model.Bus;
import com.travel.model.Customers;
import com.travel.util.StringDeal;

public class CustomersDao {
	//���ӹ˿�
	public int add(Connection con,Customers customers)throws Exception
	{
		String sql = "insert into customers values(?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, customers.getCustName());
		pstmt.setString(2, customers.getCustID());
		return pstmt.executeUpdate();
	}
	//��ѯ�û���Ϣ����
	public ResultSet list(Connection con,Customers customers)throws Exception{
		StringBuffer sb = new StringBuffer("select * from customers");
		//��flightNum��Ϊ��ʱ�ż��ϲ�ѯ����
		if(StringDeal.isNotEmpty(customers.getCustName())) {
			sb.append(" and custName like '%"+customers.getCustName()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));//�������ַ����е�and�滻��where
		//���ؽ����
		return pstmt.executeQuery();
	}
	
	public int update(Connection con,Customers customers)throws Exception{
		String sql = "update customers set custID=? where custName=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, customers.getCustID());//ԭ��ͬ��
		pstmt.setString(2, customers.getCustName());
		
		return pstmt.executeUpdate();
	}
}
