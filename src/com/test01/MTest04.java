package com.test01;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private JScrollPane scrollPane;
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

		btnNewButton_1 = new JButton("초기화");
		panel.add(btnNewButton_1);

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		DefaultTableModel tm = new DefaultTableModel(new String[] { "이름", "국어", "수학", "영어", "총점", "평균", "등급" }, 0);

		table.setModel(tm);

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Score s = new Score(textField.getText(), Integer.parseInt(textField_1.getText()),
						Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText()));
				Vector<Object> v = new Vector<Object>();
				v.addElement(s.getName());
				v.addElement(s.getKor());
				v.addElement(s.getMath());
				v.addElement(s.getEng());
				v.addElement(s.getSum());
				v.addElement(s.getAvg());
				v.addElement(s.getGrade());
				tm.addRow(v);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);

			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText(tm.getValueAt(table.getSelectedRow(), 0).toString());
				textField_1.setText(tm.getValueAt(table.getSelectedRow(), 1).toString());
				textField_2.setText(tm.getValueAt(table.getSelectedRow(), 2).toString());
				textField_3.setText(tm.getValueAt(table.getSelectedRow(), 3).toString());

			}
		});
	}
}
