package com.greedy.yujin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class defaultGUIkyj {
	
	public static void main(String[] args) {
		//프레임 생성하기
		JFrame frm = new JFrame("난이도 선택");
		
		//프레임 크기 설정
		frm.setSize(820, 500);
		
		//창 화면을 가운데 띄우기
		frm.setLocationRelativeTo(null);
		
		//null 레이아웃 설정
		frm.setLayout(null);
		
		//이미지 받기
		ImageIcon basicCon = new ImageIcon("icon/basic.png");
		ImageIcon normalCon = new ImageIcon("icon/normal.png");
		ImageIcon hardCon = new ImageIcon("icon/hard.png");
		
		//버튼 생성 (초급, 중급, 고급)
		JButton basic = new JButton(basicCon);
		JButton normal = new JButton(normalCon);
		JButton hard = new JButton(hardCon);
		
		//버튼 위치와 크기생성
		basic.setBounds(50, 120, 200, 180);
		normal.setBounds(300, 120, 200, 180);
		hard.setBounds(550, 120, 200, 180);
		
		//초급 버튼이 눌렸을 때
		basic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//초급 클래스 가져오기
			}
		});
		
		//중급 버튼이 눌렸을 때
		normal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//중급 클래스 가져오기
			}
		});
		
		//고급 버튼이 눌렸을 때
		hard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//고급 클래스 가져오기
			}
		});
		
		//폰트설정
		Font font = new Font("맑은 고딕", Font.PLAIN, 30);
		
		//운동강도 선택 라벨
		JLabel title = new JLabel("운동강도를 선택해 주세요.");
		title.setBounds(235, 50, 500, 50);
		title.setFont(font);

	
		
		
		
		//프레임에 버튼 추가
		frm.add(basic);
		frm.add(normal);
		frm.add(hard);
		frm.add(title);
		
		
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
