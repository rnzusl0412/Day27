package com.test01;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MTest03 extends JFrame {

	JPanel jp1;
	JTextField jx1, jx2, jx3, jx4;
	JButton jb1, jb2;
	JLabel label;
	JScrollPane jp2;
	JTable jt;
	TableColumnModel cm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MTest03 frame = new MTest03();
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
	public MTest03() {
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		jp1 = new JPanel();
		jp1.setBackground(Color.WHITE);
		jp1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jp1);

		JPanel panel = new JPanel();
		jp1.add(panel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("이름");
		jp1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("국어");
		jp1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("수학");

		jp1.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("영어");
		jp1.add(lblNewLabel_3);

		jx1 = new JTextField();
		jp1.add(jx1);
		jx1.setColumns(10);

		jx2 = new JTextField();
		jp1.add(jx2);
		jx2.setColumns(10);

		jx3 = new JTextField();
		jp1.add(jx3);
		jx3.setColumns(10);

		jx4 = new JTextField();
		jp1.add(jx4);
		jx4.setColumns(10);

		jb1 = new JButton("확인");

		jb1 = new JButton("초기화");

		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jp1.add(jb1);

		DefaultTableModel tm = new DefaultTableModel(new String[] { "이름", "국어", "수학", "영어", "총점", "평균", "등급" }, 0);

		setLayout(new GridLayout(2, 1));
		jp1.setLayout(new GridLayout(5, 2));
	}

}
