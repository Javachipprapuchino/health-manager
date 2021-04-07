package com.greedy.yujin;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.greedy.junho.advanced;
import com.greedy.junho.elementary;
import com.greedy.junho.intermediate;

public class defaultGUIkyj {
	
	public static void main(String[] args) {
		//프레임 생성하기
		JFrame frm = new JFrame("난이도 선택");
		
		//프레임 크기 설정
		frm.setSize(350, 550);
		
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
		basic.setBounds(45, 200, 250, 50);
		normal.setBounds(45, 280, 250, 50);
		hard.setBounds(45, 360, 250, 50);
		
		//배경이미지
		Image backimg = new ImageIcon("icon/background.png").getImage();
		JLabel back = new JLabel(new ImageIcon(backimg));
		back.setBounds(0,0,350,550);
		
		
		//초급 버튼이 눌렸을 때
		basic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//초급 클래스 가져오기
				elementary a = new elementary();
			}
		});
		
		//중급 버튼이 눌렸을 때
		normal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//중급 클래스 가져오기
				intermediate b = new intermediate();
			}
		});
		
		//고급 버튼이 눌렸을 때
		hard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//고급 클래스 가져오기
				advanced c = new advanced();

			}
		});
		
		//폰트설정
		Font font = new Font("맑은 고딕", Font.PLAIN, 30);
		
		//운동강도 선택 라벨
		JLabel title = new JLabel("운동강도 선택");
		title.setBounds(75, 50, 500, 50);
		title.setFont(font);

	
		
		
		
		//프레임에 버튼 추가
		frm.add(basic);
		frm.add(normal);
		frm.add(hard);
		frm.add(title);
		frm.add(back);

		
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
