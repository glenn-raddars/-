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

import com.travel.dao.BusDao;
import com.travel.model.Bus;
import com.travel.util.Dbutil;
import com.travel.util.StringDeal;

public class BusAddInterFrm extends JInternalFrame {
	private JTextField LocationTxt;
	private JTextField PriceTxt;
	private JTextField NumBusTxt;
	private JTextField NumAvailTxt;
	
	private Dbutil dbUtil = new Dbutil();
	private BusDao busDao = new BusDao();
	private JTextField BusKeyTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusAddInterFrm frame = new BusAddInterFrm();
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
	public BusAddInterFrm() {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 16));
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 827, 474);
		
		JLabel lblNewLabel = new JLabel("location");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		LocationTxt = new JTextField();
		LocationTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("price");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		PriceTxt = new JTextField();
		PriceTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("numBus");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		NumBusTxt = new JTextField();
		NumBusTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("numAvail");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		NumAvailTxt = new JTextField();
		NumAvailTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusAddActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetValueActionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("BusKey");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		
		BusKeyTxt = new JTextField();
		BusKeyTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(NumBusTxt)
								.addComponent(LocationTxt, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(NumAvailTxt)
								.addComponent(PriceTxt, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(247)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(127)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(283)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(BusKeyTxt, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(143, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(83)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(LocationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(PriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(BusKeyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(NumBusTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(NumAvailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(57))
		);
		getContentPane().setLayout(groupLayout);

	}
	//重置按钮
	protected void ResetValueActionPerformed(ActionEvent e) {
		this.resetValue();
		
	}

	//大巴车增加按钮
	protected void BusAddActionPerformed(ActionEvent evt) {
		String location = this.LocationTxt.getText();
		String price = this.PriceTxt.getText();
		String numBus = this.NumBusTxt.getText();
		String numAvail = this.NumAvailTxt.getText();
		String BusKey = this.BusKeyTxt.getText();
		
		if(StringDeal.isEmpty(location)) {
			JOptionPane.showMessageDialog(null, "location不能为空");
			return;
		}
		if(StringDeal.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "price不能为空");
			return;
		}
		if(StringDeal.isEmpty(numBus)) {
			JOptionPane.showMessageDialog(null, "numBus不能为空");
			return;
		}
		if(StringDeal.isEmpty(numAvail)) {
			JOptionPane.showMessageDialog(null, "numAvail不能为空");
			return;
		}
		if(StringDeal.isEmpty(BusKey)) {
			JOptionPane.showMessageDialog(null, "BusKey不能为空");
			return;
		}
		
		Bus bus = new Bus(location, Integer.parseInt(price), Integer.parseInt(numBus), Integer.parseInt(numAvail),BusKey);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			//在添加图书时，还会返回影像的记录条数
			int n = busDao.add(con, bus);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "大巴车信息添加成功!");
				//成功之后把窗口内的信息消除
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "大巴车信息添加失败!");
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "大巴车信息添加失败!");
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
		this.NumBusTxt.setText("");
		this.NumAvailTxt.setText("");
		this.BusKeyTxt.setText("");
	}
}
