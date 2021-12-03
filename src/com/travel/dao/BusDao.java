package com.travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.travel.model.Bus;
import com.travel.model.Flights;
import com.travel.util.StringDeal;

public class BusDao {
	//��ͳ�����
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
	//��ѯ��ͳ�����
			public ResultSet list(Connection con,Bus bus)throws Exception{
				StringBuffer sb = new StringBuffer("select * from bus");
				//��flightNum��Ϊ��ʱ�ż��ϲ�ѯ����
				if(StringDeal.isNotEmpty(bus.getLocation())) {
					sb.append(" and location like '%"+bus.getLocation()+"%'");
				}
				if(StringDeal.isNotEmpty(bus.getBusKey())) {
					sb.append(" and BusKey like '%"+bus.getBusKey()+"%'");
				}
				PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));//�������ַ����е�and�滻��where
				//���ؽ����
				return pstmt.executeQuery();
			}
			/**
			 * ���´�ͳ����
			 * @param con
			 * @param bus
			 * @return
			 * @throws Exception
			 */
			public int update(Connection con,Bus bus)throws Exception{
				String sql = "update bus set price=?,numBus=?,numAvail=?,BusKey=? where location=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bus.getPrice());//ԭ��ͬ��
				pstmt.setInt(2, bus.getNumBus());
				pstmt.setInt(3, bus.getNumAvail());
				pstmt.setString(5, bus.getLocation());
				pstmt.setString(4, bus.getBusKey());
				return pstmt.executeUpdate();
			}
}
