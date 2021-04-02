package com.greedy.wonsuk;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Join extends JFrame {
	
	public Join() {
		this.setSize(430, 490);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel join = new JLabel("회원가입");
		join.setBounds(159, 41, 101, 20);
		panel.add(join);
		
		JLabel id = new JLabel("아이디");
		id.setBounds(69, 113, 64, 20);
		panel.add(id);
		
		JLabel password = new JLabel("비밀번호");
		password.setBounds(69, 163, 64, 20);
		panel.add(password);
		
		JLabel confirm = new JLabel("비밀번호확인");
		confirm.setBounds(69, 210, 90, 20);
		panel.add(confirm);
		
		JLabel username = new JLabel("닉네임");
		username.setBounds(69, 257, 64, 20);
		panel.add(username);
		
		JTextField ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(159, 106, 186, 35);
		panel.add(ID);
		
		JTextField Password = new JTextField();
		Password.setColumns(10);
		Password.setBounds(159, 156, 186, 35);
		panel.add(Password);
		
		JTextField Confirm = new JTextField();
		Confirm.setColumns(10);
		Confirm.setBounds(159, 203, 186, 35);
		panel.add(Confirm);
		
		JTextField Username = new JTextField();
		Username.setColumns(10);
		Username.setBounds(159, 250, 186, 35);
		panel.add(Username);
		
		JButton button = new JButton("가입");
		button.setBounds(206, 363, 139, 29);
		panel.add(button);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
	
