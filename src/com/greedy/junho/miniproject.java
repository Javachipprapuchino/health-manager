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

public class miniproject extends JFrame {

//	private Image background=new ImageIcon(miniproject.class.getResource("image/background.jpg")).getImage();//배경이미지

	JScrollPane scrollPane;
	ImageIcon icon;

	public miniproject() {
		project();
	}

	public void project() {

		/* Layout지정 없이 위치 지정하면서 배치하는 방법 */

//		------------------------------------------------------------------

		icon = new ImageIcon("image/background.png");

		// 배경 Panel 생성후 컨텐츠페인으로 지정
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				// Approach 1: Dispaly image at at full size
				g.drawImage(icon.getImage(), 0, 0, null);
				// Approach 2: Scale image to size of component
				// Dimension d = getSize();
				// g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};

//    		------------------------------------------------------------------
		background.setLayout(null);

		JLabel lb = new JLabel("초급 운동 리스트");
		lb.setLocation(50, 30);
		lb.setSize(100, 50);

//		=============================================================

		
		ImageIcon icon1 = new ImageIcon("image/running.png");
		JButton btn1 = new JButton("	  			 달리기", icon1);
		btn1.setLocation(50, 100);
		btn1.setSize(500, 100);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				/* 이벤트 실행 내용을 적는다 */
				if (e.getSource() == btn1) {

				}

			}
		});

		

//=======================================================================================

		ImageIcon icon2 = new ImageIcon("image/pushup.png");
		JButton btn2 = new JButton("	  	 		푸쉬업", icon2);
		btn2.setLocation(50, 250);
		btn2.setSize(500, 100);

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				/* 이벤트 실행 내용을 적는다 */
				if (e.getSource() == btn2) {

				}

			}
		});

		
//=======================================================================================

		ImageIcon icon3 = new ImageIcon("image/pullup.png");
		JButton btn3 = new JButton("	  	 		풀업", icon3);
		btn3.setLocation(50, 400);
		btn3.setSize(500, 100);

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				/* 이벤트 실행 내용을 적는다 */
				if (e.getSource() == btn3) {

				}

			}
		});

//=======================================================================================
		
		
		background.add(lb);
		background.add(btn1);
		background.add(btn2);
		background.add(btn3);

		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);

	}

//	public void paint(Graphics g) {//그리는 함수
//	g.drawImage(background, 0, 0, null);//background를 그려줌
//	}

	public static void main(String[] args) {
		miniproject frame = new miniproject();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(300, 50, 600, 600);
		frame.setVisible(true);
		frame.setTitle("미니프로젝트");
	}
}
