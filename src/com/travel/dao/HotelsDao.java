package com.travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.travel.model.Bus;
import com.travel.model.Hotels;
import com.travel.util.StringDeal;

public class HotelsDao {
	public int add(Connection con,Hotels hotels)throws Exception
	{
		String sql = "insert into hotels values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, hotels.getLocation());
		pstmt.setInt(2, hotels.getPrice());
		pstmt.setInt(3, hotels.getNumRooms());
		pstmt.setInt(4, hotels.getNumAvail());
		pstmt.setString(5, hotels.getHotelKey());
		return pstmt.executeUpdate();
	}
	
	//��ѯ�ùݼ���
	public ResultSet list(Connection con,Hotels hotels)throws Exception{
		StringBuffer sb = new StringBuffer("select * from hotels");
		
		if(StringDeal.isNotEmpty(hotels.getLocation())) {
			sb.append(" and location like '%"+hotels.getLocation()+"%'");
		}
		if(StringDeal.isNotEmpty(hotels.getHotelKey())) {
			sb.append(" and HotelKey like '%"+hotels.getHotelKey()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));//�������ַ����е�and�滻��where
		//���ؽ����
		return pstmt.executeQuery();
	}
	
	/**
	 * �����ù���Ϣ
	 * @param con
	 * @param Hotels
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Hotels hotels)throws Exception{
		String sql = "update hotels set price=?,numRooms=?,numAvail=?,HotelKey=? where location=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, hotels.getPrice());//ԭ��ͬ��
		pstmt.setInt(2, hotels.getNumRooms());
		pstmt.setInt(3, hotels.getNumAvail());
		pstmt.setString(5, hotels.getLocation());
		pstmt.setString(4, hotels.getHotelKey());
		return pstmt.executeUpdate();
	}
}
