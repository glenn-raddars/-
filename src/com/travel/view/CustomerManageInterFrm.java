package com.travel.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.travel.dao.CustomersDao;
import com.travel.model.Bus;
import com.travel.model.Customers;
import com.travel.util.Dbutil;
import com.travel.util.StringDeal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerManageInterFrm extends JInternalFrame {
	private JTable CustomerTable;
	private JTextField CustNameTxt;
	private JTextField CustIDTxt;
	private JTextField s_CustNameTxt;

	private Dbutil dbUtil = new Dbutil();
	private CustomersDao customersDao = new CustomersDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerManageInterFrm frame = new CustomerManageInterFrm();
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
	public CustomerManageInterFrm() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1105, 526);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		
		JButton btnNewButton = new JButton("\u66F4\u65B0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerUpdateActionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("\u67E5\u8BE2\u7528\u6237\u4FE1\u606F");
		
		s_CustNameTxt = new JTextField();
		s_CustNameTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerSearchActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(79)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 924, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 921, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(429)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(136)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(s_CustNameTxt, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
							.addGap(102)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(s_CustNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addGap(38)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnNewButton)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("custName");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		
		CustNameTxt = new JTextField();
		CustNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("custID");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		CustIDTxt = new JTextField();
		CustIDTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(42)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(CustNameTxt, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(146)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(66)
					.addComponent(CustIDTxt, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(208, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(CustNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(CustIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		CustomerTable = new JTable();
		CustomerTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CustomerTableMousePressedActionperformed(e);
			}
		});
		CustomerTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"custName", "custID"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(CustomerTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new Customers());
	}
	
	protected void CustomerSearchActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s_CustName = this.s_CustNameTxt.getText();
		Customers customers = new Customers();
		customers.setCustName(s_CustName);;
		this.fillTable(customers);
	}

	protected void CustomerTableMousePressedActionperformed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = CustomerTable.getSelectedRow();//获取选中的行
		CustNameTxt.setText((String)CustomerTable.getValueAt(row, 0));//得到第row行的第零列元素
		CustIDTxt.setText((String)CustomerTable.getValueAt(row, 1));
		
	}

			//填充初始表格
			private void fillTable(Customers Customers) {
				DefaultTableModel dtm = (DefaultTableModel)CustomerTable.getModel();
				dtm.setRowCount(0);//把表格设置成0行，相当于把表格清空。
				//进行数据库查询
				Connection con=null;
				try {
					con=dbUtil.getCon();
					ResultSet rs = customersDao.list(con, Customers);//拿到查询的结果集
					while(rs.next()) {
						Vector v = new Vector();
						v.add(rs.getString("custName"));
						v.add(rs.getString("custID"));
						
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
			
			protected void CustomerUpdateActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				String custName = CustNameTxt.getText();
				String custID = CustIDTxt.getText();
				
				
				if(StringDeal.isEmpty(custName)) {
					JOptionPane.showMessageDialog(null, "请选择要修改的客户");
					return;
				}
				Customers customers = new Customers(custName, custID);
				Connection con=null;
				try {
					con=dbUtil.getCon();
					int modifyNum = customersDao.update(con, customers);//返回影响的记录条数
					if(modifyNum==1) {
						JOptionPane.showMessageDialog(null, "修改成功");
						this.resetValue();//重置表单
						this.fillTable(new Customers());//还要填进去
					}else {
						JOptionPane.showMessageDialog(null, "修改失败");
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
			}
			
			private void resetValue() {
				// TODO Auto-generated method stub
				this.CustNameTxt.setText("");
				this.CustIDTxt.setText("");
				
			}
}
