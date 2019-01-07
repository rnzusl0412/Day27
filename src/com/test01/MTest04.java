package com.test01;

import java.awt.BorderLayout;
import MyScore.score;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class MTest04 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTable table;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MTest04 frame = new MTest04();
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
	public MTest04() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 2));

		JLabel lblNewLabel = new JLabel("이름");
		panel.add(lblNewLabel);

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);

		lblNewLabel_1 = new JLabel("국어");
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);

		lblNewLabel_2 = new JLabel("수학");
		panel.add(lblNewLabel_2);

		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);

		lblNewLabel_3 = new JLabel("영어");
		panel.add(lblNewLabel_3);

		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);

		btnNewButton = new JButton("확인");
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				score s = new score();
				Vector<Object> v = new Vector<Object>();
				v.addElement(s.getName());
				v.addElement(s.getKor());
				v.addElement(s.getMat());
				v.addElement(s.getEng());
				v.addElement(s.getTot());
				v.addElement(s.getAvg());
				table.getModel();
			}
		});
		
		btnNewButton_1 = new JButton("초기화");
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		

		table = new JTable();
		contentPane.add(table);
	}

}
