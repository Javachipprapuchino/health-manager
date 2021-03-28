package com.greedy.wonsuk;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
	
public Login() {
		
		this.setSize(400, 300);
		setLocationRelativeTo(null); // 윈도우 창에서 가운데 화면으로 띄우는 역학을 한다.
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		this.setLayout(null);
		
		JLabel lblLogin = new JLabel("ID");
		lblLogin.setBounds(41, 52, 69, 35); //버튼 위치와 크기 설정
		panel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(41, 103, 69, 35);
		panel.add(lblPassword);
		
		JTextField text = new JTextField();
		text.setBounds(157, 52, 176, 35);
		panel.add(text);
		text.setColumns(10); //최대 columns 갯수만큼의 텍스트를 입력할 수 있는 입력공간을 만듭니다
		
		JButton button = new JButton("회원가입");
		button.setBounds(229, 154, 104, 29);
		panel.add(button);
	
		JButton login = new JButton("로그인");
		login.setBounds(108, 154, 106, 29);
		panel.add(login);
		
		JTextField Password = new JTextField();
		Password.setColumns(10); 
		Password.setBounds(157, 103, 176, 35);
		panel.add(Password);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }
}
