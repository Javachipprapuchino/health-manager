package com.greedy.wonsuk;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
	
public Login() {
		
		this.setSize(420, 600);
		setLocationRelativeTo(null); // 윈도우 창에서 가운데 화면으로 띄우는 역학을 한다.
		JPanel panel = new JPanel();
		//panel.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(panel);
		this.setLayout(null);
		
		JLabel lblLogin = new JLabel("ID");
		lblLogin.setBounds(41, 352, 69, 35); //버튼 위치와 크기 설정
		panel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(41, 403, 69, 35);
		panel.add(lblPassword);
		
		JTextField text = new JTextField();
		text.setBounds(157, 352, 176, 35);
		panel.add(text);
		text.setColumns(10); //최대 columns 갯수만큼의 텍스트를 입력할 수 있는 입력공간을 만듭니다
		
		JButton button = new JButton("회원가입");
		button.setBounds(229, 454, 104, 29);
		panel.add(button);
	
		JButton login = new JButton("로그인");
		login.setBounds(108, 454, 106, 29);
		panel.add(login);
		
		JTextField Password = new JTextField();
		Password.setColumns(10); 
		Password.setBounds(157, 403, 176, 35);
		panel.add(Password);
		
		Image backimg = new ImageIcon("icon/로그인.png").getImage();
		JLabel back = new JLabel(new ImageIcon(backimg));
		back.setBounds(0,0,400,600);
		
		panel.add(back);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Join();
			}
		});
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }
}
