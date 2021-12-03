package com.travel.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("\u65C5\u884C\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 445);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u822A\u73ED\u754C\u9762");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u589E\u6DFB");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightAddInterFrm flightAddInterFrm = new FlightAddInterFrm();
				flightAddInterFrm.setVisible(true);
				table.add(flightAddInterFrm);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u66F4\u65B0");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightManageInterFrm flightManageInterFrm = new FlightManageInterFrm();
				flightManageInterFrm.setVisible(true);
				table.add(flightManageInterFrm);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u5927\u5DF4\u8F66\u754C\u9762");
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u589E\u6DFB");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusAddInterFrm busAddInterFrm = new BusAddInterFrm();
				busAddInterFrm.setVisible(true);
				table.add(busAddInterFrm);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u66F4\u65B0");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusManageInterFrm busManageInterFrm = new BusManageInterFrm();
				busManageInterFrm.setVisible(true);
				table.add(busManageInterFrm);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("\u5BBE\u9986\u754C\u9762");
		mnNewMenu_2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u589E\u6DFB");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HotelAddInterFrm hotelAddInterFrm = new HotelAddInterFrm();
				hotelAddInterFrm.setVisible(true);
				table.add(hotelAddInterFrm);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u66F4\u65B0");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HotelManageInterFrm hotelManageInterFrm = new HotelManageInterFrm();
				hotelManageInterFrm.setVisible(true);
				table.add(hotelManageInterFrm);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_3 = new JMenu("\u7528\u6237\u754C\u9762");
		mnNewMenu_3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u589E\u6DFB");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerAddInterFrm customerAddInterFrm = new CustomerAddInterFrm();
				customerAddInterFrm.setVisible(true);
				table.add(customerAddInterFrm);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u66F4\u65B0");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerManageInterFrm customerManageInterFrm = new CustomerManageInterFrm();
				customerManageInterFrm.setVisible(true);
				table.add(customerManageInterFrm);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_4 = new JMenu("\u7528\u6237\u9884\u8BA2");
		mnNewMenu_4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u9884\u5B9A");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RservationAddInterFrm rservationAddInterFrm = new RservationAddInterFrm();
				rservationAddInterFrm.setVisible(true);
				table.add(rservationAddInterFrm);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u67E5\u8BE2");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationManageInterFrm reservationManageInterFrm = new ReservationManageInterFrm();
				reservationManageInterFrm.setVisible(true);
				table.add(reservationManageInterFrm);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_9);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		table.setBackground(Color.CYAN);
		contentPane.add(table, BorderLayout.CENTER);
	}
}
