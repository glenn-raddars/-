package com.travel.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.travel.dao.BusDao;
import com.travel.dao.CustomersDao;
import com.travel.dao.FlightsDao;
import com.travel.dao.HotelsDao;
import com.travel.dao.ReservationsDao;
import com.travel.model.Bus;
import com.travel.model.Customers;
import com.travel.model.Flights;
import com.travel.model.Hotels;
import com.travel.model.Reservations;
import com.travel.util.Dbutil;
import com.travel.util.StringDeal;

public class RservationAddInterFrm extends JInternalFrame {
	private JTextField CustNameTxt;
	private JTextField ResvTypeTxt;
	private JTextField ResvKeyTxt;
	
	private Dbutil dbUtil = new Dbutil();
	private ReservationsDao reservationsDao = new ReservationsDao();
	private CustomersDao customersDao = new CustomersDao();
	private FlightsDao flightsDao = new FlightsDao();
	private HotelsDao hotelsDao = new HotelsDao();
	private BusDao busDao = new BusDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RservationAddInterFrm frame = new RservationAddInterFrm();
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
	public RservationAddInterFrm() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1112, 535);
		
		JLabel lblNewLabel = new JLabel("custName");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		
		CustNameTxt = new JTextField();
		CustNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("resvType");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		ResvTypeTxt = new JTextField();
		ResvTypeTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("resvKey");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		
		ResvKeyTxt = new JTextField();
		ResvKeyTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationAddActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(206)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(ResvKeyTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(CustNameTxt, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
							.addGap(127)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(ResvTypeTxt, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(311)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(169)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(196, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(132)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(CustNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(ResvTypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(114)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(ResvKeyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(58))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void ResetActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	protected void ReservationAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String custName = this.CustNameTxt.getText();
		String resvtype = this.ResvTypeTxt.getText();
		String resvKey = this.ResvKeyTxt.getText();
		
		
		if(StringDeal.isEmpty(custName)) {
			JOptionPane.showMessageDialog(null, "custName不能为空");
			return;
		}
		Connection con = null;
		try {
			con=dbUtil.getCon();
			ResultSet rs = customersDao.list(con, new Customers());//拿到查询的结果集
			int flag = 0;
			while(rs.next()) {
				//System.out.println(custName.hashCode());
				//System.out.println(rs.getString("custName").hashCode());
				if(custName.equals((String)rs.getString("custName"))) {
					flag=1;
					break;
				}
				//System.out.println(flag);
			}
			if(flag==0) {
				JOptionPane.showMessageDialog(null, "你不能为一位不存在的用户预订");
				return;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.clossCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(StringDeal.isEmpty(resvtype)) {
			JOptionPane.showMessageDialog(null, "resvtype不能为空");
			return;
		}
		if(StringDeal.isEmpty(resvKey)) {
			JOptionPane.showMessageDialog(null, "resvKey不能为空");
			return;
		}
		
		
		if(Integer.parseInt(resvtype) == 1) {
			
			try {
				con = dbUtil.getCon();
				Flights flights = new Flights(resvKey);
				ResultSet rs = flightsDao.list(con, flights);//拿到查询的结果集
				while(rs.next()) {
					//System.out.println(rs.getInt("numAvail"));
					int numAvail = rs.getInt("numAvail")-1;
					if(numAvail < 0) {
						JOptionPane.showMessageDialog(null, "航班已预定完，没有多余航班");
						return;
					}
					Flights flights1 = new Flights(rs.getString("flightNum"),rs.getInt("price"),rs.getInt("numSeats"),numAvail,rs.getString("FromCity"),rs.getString("ArivCity"));
					flightsDao.update(con, flights1);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "预定失败,没有本次航班");
				e.printStackTrace();
			}finally {
				try {
					dbUtil.clossCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
if(Integer.parseInt(resvtype) == 2) {
			
			try {
				con = dbUtil.getCon();
				Hotels hotels = new Hotels(resvKey);
				ResultSet rs = hotelsDao.list(con, hotels);//拿到查询的结果集
				int flag=0;
				while(rs.next()) {
					//System.out.println(rs.getInt("numAvail"));
					flag=1;
					int numAvail = rs.getInt("numAvail")-1;
					if(numAvail < 0) {
						JOptionPane.showMessageDialog(null, "旅馆已预定完，没有多余");
						return;
					}
					Hotels hotels1 = new Hotels(rs.getString("location"),rs.getInt("price"),rs.getInt("numRooms"),numAvail,rs.getString("HotelKey"));
					hotelsDao.update(con, hotels1);
				}
				if(flag==0) {
					JOptionPane.showMessageDialog(null, "预定失败,没有这个旅馆");
					return;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "预定失败,没有这个旅馆");
				e.printStackTrace();
			}finally {
				try {
					dbUtil.clossCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
if(Integer.parseInt(resvtype) == 3) {
	
	try {
		con = dbUtil.getCon();
		Bus bus = new Bus(resvKey);
		ResultSet rs = busDao.list(con, bus);//拿到查询的结果集
		int flag=0;
		while(rs.next()) {
			//System.out.println(rs.getInt("numAvail"));
			flag=1;
			int numAvail = rs.getInt("numAvail")-1;
			if(numAvail < 0) {
				JOptionPane.showMessageDialog(null, "大巴车已预定完，没有多余");
				return;
			}
			Bus bus1 = new Bus(rs.getString("location"),rs.getInt("price"),rs.getInt("numBus"),numAvail,rs.getString("BusKey"));
			busDao.update(con, bus1);
		}
		if(flag==0) {
			JOptionPane.showMessageDialog(null, "预定失败,没有本次大巴车");
			return;
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null, "预定失败,没有本次大巴车");
		e.printStackTrace();
	}finally {
		try {
			dbUtil.clossCon(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
		
		Reservations reservations = new Reservations(custName, Integer.parseInt(resvtype), resvKey);
		
		//Connection con = null;
		try {
			con = dbUtil.getCon();
			//在添加预定信息，还会返回影像的记录条数
			int n = reservationsDao.add(con, reservations);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "预定信息添加成功!");
				//成功之后把窗口内的信息消除
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "预定信息添加失败!");
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "预定信息添加失败!");
			e.printStackTrace();
		}finally {
			try {
				dbUtil.clossCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void resetValue() {
		// TODO Auto-generated method stub
		this.CustNameTxt.setText("");
		this.ResvKeyTxt.setText("");
		this.ResvTypeTxt.setText("");
	}
}
