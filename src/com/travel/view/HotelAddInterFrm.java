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

import com.travel.dao.HotelsDao;
import com.travel.model.Hotels;
import com.travel.util.Dbutil;
import com.travel.util.StringDeal;

public class HotelAddInterFrm extends JInternalFrame {
	private JTextField LocationTxt;
	private JTextField PriceTxt;
	private JTextField NumRoomsTxt;
	private JTextField NumAvailTxt;
	
	private Dbutil dbUtil = new Dbutil();
	private HotelsDao hotelsDao = new HotelsDao(); 
	private JTextField HotelKeyTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelAddInterFrm frame = new HotelAddInterFrm();
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
	public HotelAddInterFrm() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 822, 508);
		
		JLabel lblNewLabel = new JLabel("location");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		LocationTxt = new JTextField();
		LocationTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("price");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		PriceTxt = new JTextField();
		PriceTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("numRooms");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		NumRoomsTxt = new JTextField();
		NumRoomsTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("numAvail");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		NumAvailTxt = new JTextField();
		NumAvailTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u589E\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HotelAddActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetValueActionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("HotelKey");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		
		HotelKeyTxt = new JTextField();
		HotelKeyTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(166)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(NumRoomsTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(LocationTxt, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(69)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(PriceTxt, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_3)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(NumAvailTxt))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(HotelKeyTxt, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(218)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(106)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(145, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(111)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(LocationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(PriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(HotelKeyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(NumRoomsTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(NumAvailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(59))
		);
		getContentPane().setLayout(groupLayout);

	}
	protected void ResetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	//增加旅馆按钮
	protected void HotelAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String location = this.LocationTxt.getText();
		String price = this.PriceTxt.getText();
		String numRooms = this.NumRoomsTxt.getText();
		String numAvail = this.NumAvailTxt.getText();
		String HotelKey = this.HotelKeyTxt.getText();
		
		if(StringDeal.isEmpty(location)) {
			JOptionPane.showMessageDialog(null, "location不能为空");
			return;
		}
		if(StringDeal.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "price不能为空");
			return;
		}
		if(StringDeal.isEmpty(numRooms)) {
			JOptionPane.showMessageDialog(null, "numRooms不能为空");
			return;
		}
		if(StringDeal.isEmpty(numAvail)) {
			JOptionPane.showMessageDialog(null, "numAvail不能为空");
			return;
		}
		if(StringDeal.isEmpty(HotelKey)) {
			JOptionPane.showMessageDialog(null, "HotelKey不能为空");
			return;
		}
		
		Hotels hotels = new Hotels(location, Integer.parseInt(price), Integer.parseInt(numRooms), Integer.parseInt(numAvail),HotelKey);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			//在添加图书时，还会返回影像的记录条数
			int n = hotelsDao.add(con, hotels);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "旅馆信息添加成功!");
				//成功之后把窗口内的信息消除
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "旅馆信息添加失败!");
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "旅馆信息添加失败!");
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
		this.LocationTxt.setText("");
		this.PriceTxt.setText("");
		this.NumRoomsTxt.setText("");
		this.NumAvailTxt.setText("");
		this.HotelKeyTxt.setText("");
	}
}
