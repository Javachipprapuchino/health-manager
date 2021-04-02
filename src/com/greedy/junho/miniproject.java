package com.greedy.junho;

import java.awt.Graphics;
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

public class miniproject extends JFrame {

//	private Image background=new ImageIcon(miniproject.class.getResource("image/background.jpg")).getImage();//배경이미지

	

//	public miniproject() {
//		project();
//	}


	public miniproject() {
		
		JScrollPane scrollPane;
		ImageIcon icon;

		/* Layout지정 없이 위치 지정하면서 배치하는 방법 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 60, 600, 600);
		setVisible(true);
		setTitle("미니프로젝트");
		
		
//		------------------------------------------------------------------

		icon = new ImageIcon("image/background.png");

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

		JLabel lb = new JLabel("초급 운동 리스트");
		lb.setLocation(300, 20);
		lb.setSize(100, 50);

//		=============================================================

//		버튼1
		
		
		ImageIcon icon1 = new ImageIcon("image/running.png");
		JButton btn1 = new JButton("	  			 달리기", icon1);
		btn1.setLocation(50, 100);
		btn1.setSize(400, 100);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				/* 이벤트 실행 내용을 적는다 */
				if (e.getSource() == btn1) {

				}

			}
		});
		
//=======================================================================================
		
		   JSpinner spinner1 = new JSpinner();
		   SpinnerNumberModel numberModel1 = new SpinnerNumberModel(1,1,10000,1);
		   spinner1 = new JSpinner(numberModel1);
		   spinner1.setLocation(450,100);
		   spinner1.setSize(50,100);
		
		
		

//=======================================================================================
		   
//		   버튼2

		ImageIcon icon2 = new ImageIcon("image/pushup.png");
		JButton btn2 = new JButton("	  	 		푸쉬업", icon2);
		btn2.setLocation(50, 220);
		btn2.setSize(400, 100);

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				/* 이벤트 실행 내용을 적는다 */
				if (e.getSource() == btn2) {

				}

			}
		});

//=======================================================================================
		
		   JSpinner spinner2 = new JSpinner();
		   SpinnerNumberModel numberModel2 = new SpinnerNumberModel(1,1,10000,1);
		   spinner2 = new JSpinner(numberModel2);
		   spinner2.setLocation(450,220);
		   spinner2.setSize(50,100);		
		   
		   
//=======================================================================================

//		   버튼3
		   
		ImageIcon icon3 = new ImageIcon("image/pullup.png");
		JButton btn3 = new JButton("	  	 		풀업", icon3);
		btn3.setLocation(50, 340);
		btn3.setSize(400, 100);

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				/* 이벤트 실행 내용을 적는다 */
				if (e.getSource() == btn3) {

				}

			}
		});
//=======================================================================================
		
		   JSpinner spinner3 = new JSpinner();
		   SpinnerNumberModel numberModel3 = new SpinnerNumberModel(1,1,10000,1);
		   spinner3 = new JSpinner(numberModel3);
		   spinner3.setLocation(450,340);
		   spinner3.setSize(50,100);
		   
//=======================================================================================
		   
		   
		   
		   JButton btn4 = new JButton("추가");
			btn4.setLocation(250, 480);
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
