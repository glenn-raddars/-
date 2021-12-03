package com.travel.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.travel.dao.BusDao;
import com.travel.model.Bus;
import com.travel.model.Flights;
import com.travel.util.Dbutil;
import com.travel.util.StringDeal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BusManageInterFrm extends JInternalFrame {
	private JTable BusTable;
	private JTextField s_locationTxt;
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
					BusManageInterFrm frame = new BusManageInterFrm();
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
	public BusManageInterFrm() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1117, 558);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u5927\u5DF4\u8F66\u73ED\u6B21");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		
		s_locationTxt = new JTextField();
		s_locationTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusSearchActionPeformed(e);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u66F4\u65B0\u5927\u5DF4\u8F66", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton_1 = new JButton("\u66F4\u65B0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusUpdateActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(121)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(s_locationTxt, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addGap(134)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1015, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1014, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(452)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_locationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(44)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(btnNewButton_1)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("location");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		LocationTxt = new JTextField();
		LocationTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("price");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		
		PriceTxt = new JTextField();
		PriceTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("numBus");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		
		NumBusTxt = new JTextField();
		NumBusTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("numAvail");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		
		NumAvailTxt = new JTextField();
		NumAvailTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("BusKey");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 14));
		
		BusKeyTxt = new JTextField();
		BusKeyTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(30)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(LocationTxt, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(PriceTxt, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(168)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(BusKeyTxt)))
					.addGap(30)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(NumBusTxt, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(NumAvailTxt, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(LocationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(PriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(NumBusTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(NumAvailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(BusKeyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		BusTable = new JTable();
		BusTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BusTableMousePressedActionPerformed(e);
			}
		});
		BusTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"location", "price", "numBus", "numAvail", "BusKey"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(BusTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new Bus());
	}
	
	
	protected void BusUpdateActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String location = LocationTxt.getText();
		String price = PriceTxt.getText();
		String numBus = NumBusTxt.getText();
		String numAvail = NumAvailTxt.getText();
		String BusKey = BusKeyTxt.getText();
		
		if(StringDeal.isEmpty(location)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的大巴车班次");
			return;
		}
		Bus bus = new Bus(location, Integer.parseInt(price), Integer.parseInt(numBus),Integer.parseInt(numAvail),BusKey);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int modifyNum = busDao.update(con, bus);//返回影响的记录条数
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();//重置表单
				this.fillTable(new Bus());//还要填进去
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
	/**
	 * 查询按钮
	 * @param e
	 */
	protected void BusSearchActionPeformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String s_location = this.s_locationTxt.getText();
		Bus bus = new Bus();
		bus.setLocation(s_location);
		this.fillTable(bus);
	}

	protected void BusTableMousePressedActionPerformed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = BusTable.getSelectedRow();//获取选中的行
		LocationTxt.setText((String)BusTable.getValueAt(row, 0));//得到第row行的第零列元素
		PriceTxt.setText((String)BusTable.getValueAt(row, 1));
		NumBusTxt.setText((String)BusTable.getValueAt(row, 2));
		NumAvailTxt.setText((String)BusTable.getValueAt(row, 3));
		BusKeyTxt.setText((String)BusTable.getValueAt(row, 4));
	}
	
	//填充初始表格
		private void fillTable(Bus bus) {
			DefaultTableModel dtm = (DefaultTableModel)BusTable.getModel();
			dtm.setRowCount(0);//把表格设置成0行，相当于把表格清空。
			//进行数据库查询
			Connection con=null;
			try {
				con=dbUtil.getCon();
				ResultSet rs = busDao.list(con, bus);//拿到查询的结果集
				while(rs.next()) {
					Vector v = new Vector();
					v.add(rs.getString("location"));
					v.add(rs.getString("price"));
					v.add(rs.getString("numBus"));
					v.add(rs.getString("numAvail"));
					v.add(rs.getString("BusKey"));
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
		
		private void resetValue() {
			// TODO Auto-generated method stub
			this.LocationTxt.setText("");
			this.PriceTxt.setText("");
			this.NumBusTxt.setText("");
			this.NumAvailTxt.setText("");
			this.BusKeyTxt.setText("");
		}

}
