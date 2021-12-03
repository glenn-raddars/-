package com.travel.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.travel.dao.FlightsDao;
import com.travel.model.Flights;
import com.travel.util.Dbutil;
import com.travel.util.StringDeal;

public class FlightAddInterFrm extends JInternalFrame {
	private JTextField flightNumTxt;
	private JTextField priceTxt;
	private JTextField numSeatsTxt;
	private JTextField numAvailTxt;
	private JTextField FromCityTxt;
	private JTextField ArivCityTxt;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	
	private Dbutil dbUtil = new Dbutil();
	private FlightsDao flightsDao = new FlightsDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightAddInterFrm frame = new FlightAddInterFrm();
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
	public FlightAddInterFrm() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 751, 501);
		
		JLabel lblNewLabel = new JLabel("flightNum");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		flightNumTxt = new JTextField();
		flightNumTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("price");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("numSeats");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		numSeatsTxt = new JTextField();
		numSeatsTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("numAvail");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		numAvailTxt = new JTextField();
		numAvailTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("FromCity");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		
		FromCityTxt = new JTextField();
		FromCityTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("ArivCity");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 16));
		
		ArivCityTxt = new JTextField();
		ArivCityTxt.setColumns(10);
		
		btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flightAddActionPerformed(e);
			}
		});
		
		btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(135)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(numSeatsTxt)
								.addComponent(flightNumTxt)
								.addComponent(FromCityTxt, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
							.addGap(95)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(ArivCityTxt)
								.addComponent(numAvailTxt)
								.addComponent(priceTxt, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))))
					.addContainerGap(147, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(flightNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(103)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(numAvailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(numSeatsTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(83)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5)
						.addComponent(ArivCityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(FromCityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(66))
		);
		getContentPane().setLayout(groupLayout);

	}
	//重置面板信息
	protected void ResetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	//航班增加按钮设置
	protected void flightAddActionPerformed(ActionEvent evt) {
		//先拿到输入
		String flightNum = this.flightNumTxt.getText();
		String price = this.priceTxt.getText();
		String numSeats = this.numSeatsTxt.getText();
		String numAvail = this.numAvailTxt.getText();
		String FromCity = this.FromCityTxt.getText();
		String ArivCity = this.ArivCityTxt.getText();
		
		if(StringDeal.isEmpty(flightNum)) {
			JOptionPane.showMessageDialog(null, "flightNum不能为空");
			return;
		}
		if(StringDeal.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "price不能为空");
			return;
		}
		if(StringDeal.isEmpty(numSeats)) {
			JOptionPane.showMessageDialog(null, "numSeats不能为空");
			return;
		}
		if(StringDeal.isEmpty(numAvail)) {
			JOptionPane.showMessageDialog(null, "numAvail不能为空");
			return;
		}
		if(StringDeal.isEmpty(FromCity)) {
			JOptionPane.showMessageDialog(null, "FromCity不能为空");
			return;
		}
		if(StringDeal.isEmpty(ArivCity)) {
			JOptionPane.showMessageDialog(null, "ArivCity不能为空");
			return;
		}
		
		Flights flights = new Flights(flightNum, Integer.parseInt(price), Integer.parseInt(numSeats), Integer.parseInt(numAvail), FromCity,ArivCity);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			//在添加图书时，还会返回影像的记录条数
			int n = flightsDao.add(con, flights);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "航班信息添加成功!");
				//成功之后把窗口内的信息消除
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "航班信息添加失败!");
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "航班信息添加失败!");
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
		this.flightNumTxt.setText("");
		this.priceTxt.setText("");
		this.numSeatsTxt.setText("");
		this.numAvailTxt.setText("");
		this.FromCityTxt.setText("");
		this.ArivCityTxt.setText("");
	}
}
