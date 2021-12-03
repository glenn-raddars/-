package com.travel.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.travel.dao.BusDao;
import com.travel.dao.CustomersDao;
import com.travel.dao.FlightsDao;
import com.travel.dao.HotelsDao;
import com.travel.dao.ReservationsDao;
import com.travel.model.Bus;
import com.travel.model.Flights;
import com.travel.model.Hotels;
import com.travel.model.Reservations;
import com.travel.util.Dbutil;

public class ReservationManageInterFrm extends JInternalFrame {
	private JTable ReservationTable;

	
	private Dbutil dbUtil = new Dbutil();
	private ReservationsDao reservationsDao = new ReservationsDao();
	private CustomersDao customersDao = new CustomersDao();
	private FlightsDao flightsDao = new FlightsDao();
	private HotelsDao hotelsDao = new HotelsDao();
	private BusDao busDao = new BusDao();
	private JTextField s_reservationTxt;
	private JTextArea ReservationTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationManageInterFrm frame = new ReservationManageInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReservationManageInterFrm() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 994, 546);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u7528\u6237\u9884\u8BA2\u4FE1\u606F");
		
		s_reservationTxt = new JTextField();
		s_reservationTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationSearchActionPerformed(e);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u9884\u5B9A\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(85)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(s_reservationTxt, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
							.addGap(70)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 887, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 882, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_reservationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		
		ReservationTxt =  new JTextArea();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(ReservationTxt, GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(ReservationTxt, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		ReservationTable = new JTable();
		ReservationTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"custName", "resvType", "resvKey"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ReservationTable.setFont(new Font("宋体", Font.PLAIN, 14));
		scrollPane.setViewportView(ReservationTable);
		getContentPane().setLayout(groupLayout);

	}
	
	protected void ReservationSearchActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s_reservation = this.s_reservationTxt.getText();
		Reservations reservations = new Reservations();
		reservations.setCustName(s_reservation);
		this.fillTable(reservations);
		this.PrintReservationTxt(reservations);
	}
	
	protected void PrintReservationTxt(Reservations reservations) {
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs = reservationsDao.list1(con, reservations);//拿到查询的结果集
			ResultSet rs1=null;
			ResultSet rs2 = null;
			ResultSet rs3 = null;
			while(rs.next()) {
				if(rs.getInt("resvtype") == 1) {
					rs1 = flightsDao.list(con, new Flights(rs.getString("resvKey")));
				}
				if(rs.getInt("resvtype") == 2) {
					rs2 = hotelsDao.list(con, new Hotels(rs.getString("resvKey")));
				}
				if(rs.getInt("resvtype") == 3) {
					rs3 = busDao.list(con, new Bus(rs.getString("resvKey")));
				}	
			}
			StringBuffer sb = new StringBuffer("这位用户预订的是");
			String FromCity=null;
			String ArivCity=null;
			String location2=null;
			String location3=null;
			while(rs1!=null && rs1.next()) {
				sb.append(rs1.getString("flightNum")+"次航班,从 "+rs1.getString("FromCity")+" 到 "+rs1.getString("ArivCity"));
				FromCity = rs1.getString("FromCity");
				ArivCity = rs1.getString("ArivCity");
			}
			while(rs2!=null && rs2.next()) {
				sb.append("\n"+"位于 "+rs2.getString("location")+" 的 "+rs2.getString("HotelKey")+" 号房间");
				location2 = rs2.getString("location");
			}
			while(rs3!=null && rs3.next()) {
				sb.append("\n"+"在 "+rs3.getString("location")+" 处的 "+rs3.getString("BusKey")+" 号大巴");
				location3 = rs3.getString("location");
			}
			int flag = 0;
			if(FromCity!=null && ArivCity!=null) {
				if(location2!=null) {
					if(!location2.equals(FromCity) && !location2.equals(ArivCity)) {
						sb.append("\n不满足一致性");
						flag=1;
					}
				}
				if(location3!=null) {
					if(!location3.equals(FromCity) && !location3.equals(ArivCity)) {
						sb.append("\n不满足一致性");
						flag=1;
					}
				}
			}
			if(flag==0) {
				sb.append("\n满足一致性");
			}
			ReservationTxt.setText(sb.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//关闭连接
			try {
				dbUtil.clossCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

	//填充初始表格
	private void fillTable(Reservations reservations) {
		DefaultTableModel dtm = (DefaultTableModel)ReservationTable.getModel();
		dtm.setRowCount(0);//把表格设置成0行，相当于把表格清空。
		//进行数据库查询
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs = reservationsDao.list1(con, reservations);//拿到查询的结果集
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("custName"));
				v.add(rs.getString("resvtype"));
				v.add(rs.getString("resvKey"));
				
				dtm.addRow(v);//数据添加到表格中
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//关闭连接
			try {
				dbUtil.clossCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
