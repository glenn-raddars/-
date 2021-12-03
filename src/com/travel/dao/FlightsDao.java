package com.travel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.travel.model.Flights;
import com.travel.util.StringDeal;

public class FlightsDao {
	//�������
		public int add(Connection con,Flights flights)throws Exception
		{
			String sql = "insert into flights values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, flights.getFlightNum());
			pstmt.setInt(2, flights.getPrice());
			pstmt.setInt(3, flights.getNumSeats());
			pstmt.setInt(4, flights.getNumAvail());
			pstmt.setString(5, flights.getFromCity());
			pstmt.setString(6, flights.getArivCity());
			return pstmt.executeUpdate();
		}
		
		//��ѯ���༯��
		public ResultSet list(Connection con,Flights flights)throws Exception{
			StringBuffer sb = new StringBuffer("select * from flights");
			//��flightNum��Ϊ��ʱ�ż��ϲ�ѯ����
			if(StringDeal.isNotEmpty(flights.getFlightNum())) {
				sb.append(" and flightNum like '%"+flights.getFlightNum()+"%'");
			}
			PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));//�������ַ����е�and�滻��where
			//���ؽ����
			return pstmt.executeQuery();
		}
		
		/**
		 * ���º���
		 * @param con
		 * @param Flights
		 * @return
		 * @throws Exception
		 */
		public int update(Connection con,Flights flights)throws Exception{
			String sql = "update flights set price=?,numSeats=?,numAvail=?,FromCity=?,ArivCity=? where flightNum=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			//pstmt.setString(1, flights.getFlightNum());//��һ���ʺ�����flightNum;
			pstmt.setInt(1, flights.getPrice());//ԭ��ͬ��
			pstmt.setInt(2, flights.getNumSeats());
			pstmt.setInt(3, flights.getNumAvail());
			pstmt.setString(4, flights.getFromCity());
			pstmt.setString(5, flights.getArivCity());
			pstmt.setString(6, flights.getFlightNum());
			return pstmt.executeUpdate();
		}
}
