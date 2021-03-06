package com.greedy.member.view;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.greedy.member.model.dto.DataDTO;
import com.greedy.member.model.service.MemberService;

public class ViewIntermediate extends JFrame {

	private Font font1;

	public ViewIntermediate() {}

	public ViewIntermediate(String userId) {

		//프레임 생성하기
		JFrame frm = new JFrame("중급리스트");

		font1 = new Font("맑은고딕",Font.BOLD,12);


		//프레임 크기 설정
		frm.setSize(350, 550);

		//창 화면을 가운데 띄우기
		frm.setLocationRelativeTo(null);

		//null 레이아웃 설정
		frm.setLayout(null);

		//배경이미지
		Image backimg = new ImageIcon("icon/background.png").getImage();
		JLabel back = new JLabel(new ImageIcon(backimg));
		back.setBounds(0,0,350,550);


		Image icon = new ImageIcon("intermediate/jung.png").getImage();
		JLabel btn = new JLabel(new ImageIcon(icon));
		btn.setLocation(70, 20);
		btn.setSize(200,100);
		back.add(btn);
		frm.add(back);

		//=============================================================

		//버튼1


		Image icon1 = new ImageIcon("intermediate/benchpress.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		JLabel btn1 = new JLabel(new ImageIcon(icon1));
		btn1.setLocation(20, 100);
		btn1.setSize(80, 80);

		JLabel lb1 = new JLabel("벤치프레스");
		lb1.setLocation(140, 110);
		lb1.setSize(100, 30);
		lb1.setFont(font1);



		//=======================================================================================

		JSpinner spinner1 = new JSpinner();
		SpinnerNumberModel numberModel1 = new SpinnerNumberModel(0,0,10000,1);
		spinner1 = new JSpinner(numberModel1);
		spinner1.setLocation(140,150);
		spinner1.setSize(60,20);

		ImageIcon lookCon = new ImageIcon("icon/돋보기.png");
		JButton lb11 = new JButton(lookCon);
		lb11.setContentAreaFilled(false);
		lb11.setBorderPainted(false);
		lb11.setLocation(230, 110);
		lb11.setSize(70, 70);
		lb11.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new popup1();			
			}
		}); 




		//================================== 버튼 2 =====================================================


		Image icon2 = new ImageIcon("intermediate/dumbellfly.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		JLabel btn2 = new JLabel(new ImageIcon(icon2));
		btn2.setLocation(20, 200);
		btn2.setSize(80, 80);

		JLabel lb2 = new JLabel("덤벨플라이");
		lb2.setLocation(140, 210);
		lb2.setSize(100, 30);
		lb2.setFont(font1);

		//=======================================================================================

		JSpinner spinner2 = new JSpinner();
		SpinnerNumberModel numberModel2 = new SpinnerNumberModel(0,0,10000,1);
		spinner2 = new JSpinner(numberModel2);
		spinner2.setLocation(140,250);
		spinner2.setSize(60,20);		

		JButton lb21 = new JButton(lookCon);
		lb21.setContentAreaFilled(false);
		lb21.setBorderPainted(false);
		lb21.setLocation(230, 220);
		lb21.setSize(70, 70);
		lb21.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new popup2();			
			}
		}); 




		//=======================================================================================

		//   버튼3

		Image icon3 = new ImageIcon("intermediate/pullup.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		JLabel btn3 = new JLabel(new ImageIcon(icon3));
		btn3.setLocation(20, 300);
		btn3.setSize(80, 80);

		JLabel lb3 = new JLabel("풀업");
		lb3.setLocation(140, 310);
		lb3.setSize(100, 30);
		lb3.setFont(font1);


		//=======================================================================================

		JSpinner spinner3 = new JSpinner();
		SpinnerNumberModel numberModel3 = new SpinnerNumberModel(0,0,10000,1);
		spinner3 = new JSpinner(numberModel3);
		spinner3.setLocation(140,350);
		spinner3.setSize(60,20);

		JButton lb31 = new JButton(lookCon);
		lb31.setContentAreaFilled(false);
		lb31.setBorderPainted(false);
		lb31.setLocation(230, 320);
		lb31.setSize(70, 70);
		lb31.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new popup3();			
			}
		}); 
		//=======================================================================================



		ImageIcon okCon = new ImageIcon("icon/ok.png");
		JButton btn4 = new JButton(okCon);
		btn4.setContentAreaFilled(false);
		btn4.setBorderPainted(false);
		btn4.setLocation(130, 400);
		btn4.setSize(80, 40);
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


				DataDTO dt = new DataDTO();
				MemberService bm = new MemberService();

				/* 이벤트 실행 내용을 적는다 */

				int value1 = (int) numberModel1.getValue();
				if(value1>=1) {
					dt.setId(userId);
					dt.setNo1(value1);
					dt.setExcode1("E04");
					bm.insertSpinnerMem1(dt);
					bm.insertSpinnerMem21(dt);
				}

				int value2 = (int) numberModel2.getValue();
				if(value2>=1) {
					dt.setId(userId);
					dt.setNo2(value2);
					dt.setExcode2("E05");
					bm.insertSpinnerMem2(dt);
					bm.insertSpinnerMem22(dt);
				}

				int value3 = (int) numberModel3.getValue();
				if(value3>=1) {
					dt.setId(userId);
					dt.setNo3(value3);
					dt.setExcode3("E06");
					bm.insertSpinnerMem3(dt);
					bm.insertSpinnerMem23(dt);
				}
				new mainmenu(userId);
				frm.dispose();

			}
		});

		//=======================================================================================

		back.add(lb1);
		back.add(lb2);
		back.add(lb3);
		back.add(lb11);
		back.add(lb21);
		back.add(lb31);

		back.add(btn1);


		back.add(btn2);
		back.add(btn3);
		back.add(btn4);

		back.add(spinner1);
		back.add(spinner2);
		back.add(spinner3);

		frm.add(back);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


	public int test(int value) {
		int k = 0;
		if(value>=1) {
			k= value;
		}

		return k;
	}
	//	--------------------------------------------------------------

	public class popup1 extends JFrame{

		public popup1(){
			JScrollPane scrollPane;
			ImageIcon icon;

			/* Layout지정 없이 위치 지정하면서 배치하는 방법 */
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(300, 60, 350, 550);
			setVisible(true);
			setLocationRelativeTo(null);
			setTitle("벤치프레스");
			icon = new ImageIcon("icon/background.png");

			// 배경 Panel 생성후 컨텐츠페인으로 지정
			JPanel background = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(icon.getImage(), 0, 0, null);

					setOpaque(false);
					super.paintComponent(g);
				}
			};

			//			------------------------------------------------------------------
			background.setLayout(null);

			ImageIcon deepCon = new ImageIcon("icon/play.png");
			JButton btn4 = new JButton(deepCon);
			btn4.setContentAreaFilled(false);
			btn4.setBorderPainted(false);
			btn4.setLocation(18, 24);
			btn4.setSize(300, 300);
			btn4.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					try {
						Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=0DsXTSHo3lU"));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			});

			ImageIcon backCon = new ImageIcon("icon/back.png");
			JButton backb = new JButton(backCon);
			backb.setLocation(0,461);
			backb.setSize(70,50);
			backb.setContentAreaFilled(false);
			backb.setBorderPainted(false);
			add(backb);
			backb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setVisible(false);
					dispose();
				}
			});

			background.add(backb);
			background.add(btn4);

			scrollPane = new JScrollPane(background);
			setContentPane(scrollPane);
		}}

	public class popup2 extends JFrame{

		public popup2(){
			JScrollPane scrollPane;
			ImageIcon icon;

			/* Layout지정 없이 위치 지정하면서 배치하는 방법 */
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(300, 60, 350, 550);
			setVisible(true);
			setLocationRelativeTo(null);
			setTitle("덤벨플라이");
			icon = new ImageIcon("icon/background.png");

			// 배경 Panel 생성후 컨텐츠페인으로 지정
			JPanel background = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(icon.getImage(), 0, 0, null);

					setOpaque(false);
					super.paintComponent(g);
				}
			};

			//			------------------------------------------------------------------
			background.setLayout(null);

			ImageIcon deepCon = new ImageIcon("icon/play.png");
			JButton btn4 = new JButton(deepCon);
			btn4.setContentAreaFilled(false);
			btn4.setBorderPainted(false);
			btn4.setLocation(18, 24);
			btn4.setSize(300, 300);
			btn4.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					try {
						Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=HcDzxNNrSBo"));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			});

			ImageIcon backCon = new ImageIcon("icon/back.png");
			JButton backb = new JButton(backCon);
			backb.setLocation(0,461);
			backb.setSize(70,50);
			backb.setContentAreaFilled(false);
			backb.setBorderPainted(false);
			add(backb);
			backb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setVisible(false);
					dispose();
				}
			});

			background.add(backb);
			background.add(btn4);

			scrollPane = new JScrollPane(background);
			setContentPane(scrollPane);
		}}

	public class popup3 extends JFrame{

		public popup3(){
			JScrollPane scrollPane;
			ImageIcon icon;

			/* Layout지정 없이 위치 지정하면서 배치하는 방법 */
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(300, 60, 350, 550);
			setVisible(true);
			setLocationRelativeTo(null);
			setTitle("풀업");
			icon = new ImageIcon("icon/background.png");

			// 배경 Panel 생성후 컨텐츠페인으로 지정
			JPanel background = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(icon.getImage(), 0, 0, null);

					setOpaque(false);
					super.paintComponent(g);
				}
			};

			//			------------------------------------------------------------------
			background.setLayout(null);

			ImageIcon deepCon = new ImageIcon("icon/play.png");
			JButton btn4 = new JButton(deepCon);
			btn4.setContentAreaFilled(false);
			btn4.setBorderPainted(false);
			btn4.setLocation(18, 24);
			btn4.setSize(300, 300);
			btn4.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					try {
						Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=nWhS28U6bCY"));
					} catch (IOException | URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			});

			ImageIcon backCon = new ImageIcon("icon/back.png");
			JButton backb = new JButton(backCon);
			backb.setLocation(0,461);
			backb.setSize(70,50);
			backb.setContentAreaFilled(false);
			backb.setBorderPainted(false);
			add(backb);
			backb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setVisible(false);
					dispose();
				}
			});

			background.add(backb);
			background.add(btn4);

			scrollPane = new JScrollPane(background);
			setContentPane(scrollPane);
		}}


}


