package com.travel.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.travel.dao.FlightsDao;
import com.travel.model.Flights;
import com.travel.util.Dbutil;
import com.travel.util.StringDeal;

public class FlightManageInterFrm extends JInternalFrame {
	private JTable FlightTable;
	private JTextField FlightNumTxt;
	private JTextField PriceTxt;
	private JTextField NumSeatsTxt;
	private JTextField NumAvailTxt;
	private JTextField FromCityTxt;
	private JTextField ArivCityTxt;
	
	
	private Dbutil dbUtil = new Dbutil();
	private FlightsDao flightsDao = new FlightsDao();
	private JTextField s_flightsNumTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightManageInterFrm frame = new FlightManageInterFrm();
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
	public FlightManageInterFrm() {
		setTitle("\u822A\u73ED\u7CFB\u7EDF\u7BA1\u7406");
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 928, 608);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u67E5\u770B\u66F4\u65B0\u9762\u677F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightUpdateActionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("\u822A\u73ED\u67E5\u8BE2");
		
		s_flightsNumTxt = new JTextField();
		s_flightsNumTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightSearchActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 870, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 865, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(404)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(104)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(s_flightsNumTxt, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
							.addGap(87)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(s_flightsNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("flightNum");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		
		FlightNumTxt = new JTextField();
		FlightNumTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("price");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		PriceTxt = new JTextField();
		PriceTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("numSeats");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		
		NumSeatsTxt = new JTextField();
		NumSeatsTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("numAvail");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		
		NumAvailTxt = new JTextField();
		NumAvailTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("FromCity");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		
		FromCityTxt = new JTextField();
		FromCityTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("ArivCity");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 14));
		
		ArivCityTxt = new JTextField();
		ArivCityTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(NumAvailTxt)
						.addComponent(FlightNumTxt, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(PriceTxt, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(FromCityTxt)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(NumSeatsTxt, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(ArivCityTxt)))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(FlightNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(PriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(NumSeatsTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(62)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(NumAvailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(FromCityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(ArivCityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		FlightTable = new JTable();
		FlightTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				FlightTableMouseActionPerformed(e);
			}
		});
		FlightTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"flightNum", "price", "numSeats", "numAvail", "FromCity", "ArivCity"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(FlightTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new Flights());
	}
	
	protected void FlightSearchActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s_flightsNum = this.s_flightsNumTxt.getText();
		Flights flights = new Flights();
		flights.setFlightNum(s_flightsNum);
		this.fillTable(flights);
	}

	protected void FlightUpdateActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String flightNum = FlightNumTxt.getText();
		String price = PriceTxt.getText();
		String numSeats = NumSeatsTxt.getText();
		String numAvail = NumAvailTxt.getText();
		String FromCity = FromCityTxt.getText();
		String ArivCity = ArivCityTxt.getText();
		if(StringDeal.isEmpty(flightNum)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的航班");
			return;
		}
		Flights flights = new Flights(flightNum, Integer.parseInt(price), Integer.parseInt(numSeats),Integer.parseInt(numAvail), FromCity,ArivCity);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int modifyNum = flightsDao.update(con, flights);//返回影响的记录条数
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();//重置表单
				this.fillTable(new Flights());//还要填进去
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
		this.FlightNumTxt.setText("");
		this.PriceTxt.setText("");
		this.NumSeatsTxt.setText("");
		this.NumAvailTxt.setText("");
		this.FromCityTxt.setText("");
		this.ArivCityTxt.setText("");
	}

	//鼠标按压操作，选中修改行
	protected void FlightTableMouseActionPerformed(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = FlightTable.getSelectedRow();//获取选中的行
		FlightNumTxt.setText((String)FlightTable.getValueAt(row, 0));//得到第row行的第零列元素
		PriceTxt.setText((String)FlightTable.getValueAt(row, 1));
		NumSeatsTxt.setText((String)FlightTable.getValueAt(row, 2));
		NumAvailTxt.setText((String)FlightTable.getValueAt(row, 3));
		FromCityTxt.setText((String)FlightTable.getValueAt(row, 4));
		ArivCityTxt.setText((String)FlightTable.getValueAt(row, 5));
	}

	//填充初始表格
	private void fillTable(Flights flights) {
		DefaultTableModel dtm = (DefaultTableModel)FlightTable.getModel();
		dtm.setRowCount(0);//把表格设置成0行，相当于把表格清空。
		//进行数据库查询
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs = flightsDao.list(con, flights);//拿到查询的结果集
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("flightNum"));
				v.add(rs.getString("price"));
				v.add(rs.getString("numSeats"));
				v.add(rs.getString("numAvail"));
				v.add(rs.getString("FromCity"));
				v.add(rs.getString("ArivCity"));
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
