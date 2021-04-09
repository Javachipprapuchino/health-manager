package com.greedy.member.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class advanced extends JFrame {
public advanced() {
		
		JScrollPane scrollPane;
		ImageIcon icon;

		/* Layout지정 없이 위치 지정하면서 배치하는 방법 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 60, 350, 550);
		setVisible(true);
		setTitle("초급리스트");
		
		
//		------------------------------------------------------------------

		icon = new ImageIcon("icon/background.png");

		// 배경 Panel 생성후 컨텐츠페인으로 지정
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				
				setOpaque(false);
				super.paintComponent(g);
			}
		};

//    		------------------------------------------------------------------
		background.setLayout(null);

		JLabel lb = new JLabel("고급 운동 리스트",JLabel.CENTER);
//		lb.setLocation(center);
		lb.setSize(350, 100);

//		=============================================================

//		버튼1
		
		
		Image icon1 = new ImageIcon("advanced/dips.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		JLabel btn1 = new JLabel(new ImageIcon(icon1));
		btn1.setLocation(20, 100);
		btn1.setSize(80, 80);

		JLabel lb1 = new JLabel("딥스");
		lb1.setLocation(140, 110);
		lb1.setSize(100, 30);
		

		
//=======================================================================================
		
		   JSpinner spinner1 = new JSpinner();
		   SpinnerNumberModel numberModel1 = new SpinnerNumberModel(1,1,10000,1);
		   spinner1 = new JSpinner(numberModel1);
		   spinner1.setLocation(140,150);
		   spinner1.setSize(60,20);
		
		   JLabel lb11 = new JLabel("자세히");
			lb11.setLocation(260, 100);
			lb11.setSize(80, 80);
		

//================================== 버튼 2 =====================================================
		   

		   Image icon2 = new ImageIcon("advanced/upper-chest-training.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			JLabel btn2 = new JLabel(new ImageIcon(icon2));
			btn2.setLocation(20, 200);
			btn2.setSize(80, 80);

			JLabel lb2 = new JLabel("플랫벤치프레스");
			lb2.setLocation(140, 210);
			lb2.setSize(100, 30);

//=======================================================================================
		
		   JSpinner spinner2 = new JSpinner();
		   SpinnerNumberModel numberModel2 = new SpinnerNumberModel(1,1,10000,1);
		   spinner2 = new JSpinner(numberModel2);
		   spinner2.setLocation(140,250);
		   spinner2.setSize(60,20);		
		   
		   JLabel lb21 = new JLabel("자세히");
			lb21.setLocation(260, 200);
			lb21.setSize(80, 80);
		   
//=======================================================================================

//		   버튼3
		   
		   Image icon3 = new ImageIcon("advanced/cablecrunch.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			JLabel btn3 = new JLabel(new ImageIcon(icon3));
			btn3.setLocation(20, 300);
			btn3.setSize(80, 80);

			JLabel lb3 = new JLabel("케이블크런치");
			lb3.setLocation(140, 310);
			lb3.setSize(100, 30);
			
			
//=======================================================================================
		
		   JSpinner spinner3 = new JSpinner();
		   SpinnerNumberModel numberModel3 = new SpinnerNumberModel(1,1,10000,1);
		   spinner3 = new JSpinner(numberModel3);
		   spinner3.setLocation(140,350);
		   spinner3.setSize(60,20);
		   
		   JLabel lb31 = new JLabel("자세히");
			lb31.setLocation(260, 300);
			lb31.setSize(80, 80);
		   
//=======================================================================================
		   
		   
		   JButton btn4 = new JButton("추가");
			btn4.setLocation(130, 400);
			btn4.setSize(80, 40);
			btn4.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					/* 이벤트 실행 내용을 적는다 */
					if (e.getSource() == btn4) {

					}

				}
			});
		   
		   
//=======================================================================================
		   
		   
		
		
		background.add(lb);
		background.add(lb1);
		background.add(lb2);
		background.add(lb3);
		background.add(lb11);
		background.add(lb21);
		background.add(lb31);

		
		background.add(btn1);
		background.add(btn2);
		background.add(btn3);
		background.add(btn4);

		background.add(spinner1);
		background.add(spinner2);
		background.add(spinner3);
		
		

		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);

	}

//	public void paint(Graphics g) {//그리는 함수
//	g.drawImage(background, 0, 0, null);//background를 그려줌
//	}

//	public static void main(String[] args) {
//		miniproject frame = new miniproject();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setBounds(300, 50, 600, 600);
//		frame.setVisible(true);
//		frame.setTitle("미니프로젝트");
//	}
}
