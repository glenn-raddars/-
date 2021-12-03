package com.travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.travel.model.Bus;
import com.travel.model.Flights;
import com.travel.util.StringDeal;

public class BusDao {
	//大巴车增添
	public int add(Connection con,Bus bus)throws Exception
	{
		String sql = "insert into bus values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bus.getLocation());
		pstmt.setInt(2, bus.getPrice());
		pstmt.setInt(3, bus.getNumBus());
		pstmt.setInt(4, bus.getNumAvail());
		pstmt.setString(5,bus.getBusKey());
		return pstmt.executeUpdate();
	}
	//查询大巴车集合
			public ResultSet list(Connection con,Bus bus)throws Exception{
				StringBuffer sb = new StringBuffer("select * from bus");
				//当flightNum不为空时才加上查询条件
				if(StringDeal.isNotEmpty(bus.getLocation())) {
					sb.append(" and location like '%"+bus.getLocation()+"%'");
				}
				if(StringDeal.isNotEmpty(bus.getBusKey())) {
					sb.append(" and BusKey like '%"+bus.getBusKey()+"%'");
				}
				PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));//将上述字符串中的and替换成where
				//返回结果集
				return pstmt.executeQuery();
			}
			/**
			 * 更新大巴车班次
			 * @param con
			 * @param bus
			 * @return
			 * @throws Exception
			 */
			public int update(Connection con,Bus bus)throws Exception{
				String sql = "update bus set price=?,numBus=?,numAvail=?,BusKey=? where location=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bus.getPrice());//原理同上
				pstmt.setInt(2, bus.getNumBus());
				pstmt.setInt(3, bus.getNumAvail());
				pstmt.setString(5, bus.getLocation());
				pstmt.setString(4, bus.getBusKey());
				return pstmt.executeUpdate();
			}
}
