package com.greedy.wonsuk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorPage extends JFrame  {

	public ErrorPage() {
		
		
		this.setSize(250, 150);
		setLocationRelativeTo(null); // 윈도우 창에서 가운데 화면으로 띄우는 역학을 한다.
		JPanel panel = new JPanel();
		setContentPane(panel);
		this.setLayout(null);
		
		JLabel join = new JLabel("비밀번호 확인이 잘못되었습니다.");
		join.setBounds(30, 10, 200, 20);
		panel.add(join);
		
		JButton exit = new JButton("닫기");
		exit.setBounds(80, 50, 80, 40);
		panel.add(exit);
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				
			}
		});

		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
