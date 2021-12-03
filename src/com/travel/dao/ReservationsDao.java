package com.travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.travel.model.Reservations;
import com.travel.util.StringDeal;

public class ReservationsDao {
	//预定信息增添
		public int add(Connection con,Reservations reservations)throws Exception
		{
			String sql = "insert into reservations values(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reservations.getCustName());
			pstmt.setInt(2, reservations.getResvType());
			pstmt.setString(3, reservations.getResvKey());
			
			return pstmt.executeUpdate();
		}
		
		public ResultSet list1(Connection con,Reservations reservations)throws Exception{
			StringBuffer sb = new StringBuffer("select * from reservations");
			if(StringDeal.isNotEmpty(reservations.getCustName())) {
				sb.append(" and custName like '%"+reservations.getCustName()+"%'");
			}
			PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));//将上述字符串中的and替换成where
			//返回结果集
			return pstmt.executeQuery();
		}

}
