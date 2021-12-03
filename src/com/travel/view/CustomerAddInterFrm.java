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

import com.travel.dao.CustomersDao;
import com.travel.model.Customers;
import com.travel.util.Dbutil;
import com.travel.util.StringDeal;

public class CustomerAddInterFrm extends JInternalFrame {
	private JTextField CustNameTxt;
	private JTextField CustIDTxt;
	
	private Dbutil dbUtil = new Dbutil();
	private CustomersDao customersDao = new CustomersDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerAddInterFrm frame = new CustomerAddInterFrm();
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
	public CustomerAddInterFrm() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 883, 509);
		
		JLabel lblNewLabel = new JLabel("custName");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		CustNameTxt = new JTextField();
		CustNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("custID");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		CustIDTxt = new JTextField();
		CustIDTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustAddActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(192)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(CustNameTxt, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(72)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(CustIDTxt, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(246)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(155)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(147, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(137)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(CustNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(CustIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(132)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(167, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	protected void ResetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
	}
	
	//增加顾客按钮
	protected void CustAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String custName = this.CustNameTxt.getText();
		String custID = this.CustIDTxt.getText();
		
		if(StringDeal.isEmpty(custName)) {
			JOptionPane.showMessageDialog(null, "custName不能为空");
			return;
		}
		if(StringDeal.isEmpty(custID)) {
			JOptionPane.showMessageDialog(null, "custID不能为空");
			return;
		}
		
		Customers customers = new Customers(custName, custID); 
		Connection con = null;
		try {
			con = dbUtil.getCon();
			//在添加用户信息时，还会返回影像的记录条数
			int n = customersDao.add(con, customers);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "用户信息添加成功!");
				//成功之后把窗口内的信息消除
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "用户信息添加失败!");
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "用户信息添加失败!");
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
			this.CustIDTxt.setText("");
			this.CustNameTxt.setText("");
		}
}
