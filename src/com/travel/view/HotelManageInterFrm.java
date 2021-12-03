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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.travel.dao.HotelsDao;
import com.travel.model.Bus;
import com.travel.model.Hotels;
import com.travel.util.Dbutil;
import com.travel.util.StringDeal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HotelManageInterFrm extends JInternalFrame {
	private JTable HotelTable;
	private JTextField LocationTxt;
	private JTextField PriceTxt;
	private JTextField NumRoomsTxt;
	private JTextField NumAvailTxt;
	private JTextField s_locationTxt;
	
	
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
					HotelManageInterFrm frame = new HotelManageInterFrm();
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
	public HotelManageInterFrm() {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 14));
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 1121, 545);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		
		JPanel panel = new JPanel();
		
		JButton btnNewButton = new JButton("\u66F4\u65B0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HotelUpdateActionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("\u65C5\u9986\u67E5\u8BE2");
		
		s_locationTxt = new JTextField();
		s_locationTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HotelSearchActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(444)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(122)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(s_locationTxt, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addGap(78)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(s_locationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(btnNewButton)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("location");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		
		LocationTxt = new JTextField();
		LocationTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("price");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		PriceTxt = new JTextField();
		PriceTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("numRooms");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		
		NumRoomsTxt = new JTextField();
		NumRoomsTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("numAvail");
		
		NumAvailTxt = new JTextField();
		NumAvailTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("HotelKey");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 14));
		
		HotelKeyTxt = new JTextField();
		HotelKeyTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(45)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LocationTxt, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(PriceTxt, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(NumRoomsTxt, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(NumAvailTxt, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(308)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(HotelKeyTxt, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(LocationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(PriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(NumRoomsTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(NumAvailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(HotelKeyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		HotelTable = new JTable();
		HotelTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				HotelMousePressedActionPerformed(e);
			}
		});
		HotelTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"location", "price", "numRooms", "numAvail", "HotelKey"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(HotelTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new Hotels());
	}
	
	protected void HotelUpdateActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String location = LocationTxt.getText();
		String price = PriceTxt.getText();
		String numRooms = NumRoomsTxt.getText();
		String numAvail = NumAvailTxt.getText();
		String HotelKey = HotelKeyTxt.getText();
		
		if(StringDeal.isEmpty(location)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的旅馆信息");
			return;
		}
		Hotels hotels = new Hotels(location, Integer.parseInt(price), Integer.parseInt(numRooms),Integer.parseInt(numAvail),HotelKey);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int modifyNum = hotelsDao.update(con, hotels);//返回影响的记录条数
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();//重置表单
				this.fillTable(new Hotels());//还要填进去
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

	protected void HotelSearchActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s_location = this.s_locationTxt.getText();
		Hotels hotels = new Hotels();
		hotels.setLocation(s_location);;
		this.fillTable(hotels);
	}

	protected void HotelMousePressedActionPerformed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = HotelTable.getSelectedRow();//获取选中的行
		LocationTxt.setText((String)HotelTable.getValueAt(row, 0));//得到第row行的第零列元素
		PriceTxt.setText((String)HotelTable.getValueAt(row, 1));
		NumRoomsTxt.setText((String)HotelTable.getValueAt(row, 2));
		NumAvailTxt.setText((String)HotelTable.getValueAt(row, 3));
		HotelKeyTxt.setText((String)HotelTable.getValueAt(row, 4));
	}

			//填充初始表格
			private void fillTable(Hotels hotels) {
				DefaultTableModel dtm = (DefaultTableModel)HotelTable.getModel();
				dtm.setRowCount(0);//把表格设置成0行，相当于把表格清空。
				//进行数据库查询
				Connection con=null;
				try {
					con=dbUtil.getCon();
					ResultSet rs = hotelsDao.list(con, hotels);//拿到查询的结果集
					while(rs.next()) {
						Vector v = new Vector();
						v.add(rs.getString("location"));
						v.add(rs.getString("price"));
						v.add(rs.getString("numRooms"));
						v.add(rs.getString("numAvail"));
						v.add(rs.getString("HotelKey"));
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
				this.NumRoomsTxt.setText("");
				this.NumAvailTxt.setText("");
				this.HotelKeyTxt.setText("");
			}


}
