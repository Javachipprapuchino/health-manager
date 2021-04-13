package com.greedy.member.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.IDN;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.greedy.member.controller.LoginController;

public class LoginView extends JFrame {
	
	LoginController controller = new LoginController();
	String id = "";
	
	public LoginView() {
		
		this.setSize(350, 550);
		setLocationRelativeTo(null); // 윈도우 창에서 가운데 화면으로 띄우는 역학을 한다.
		JPanel panel = new JPanel();
		//panel.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(panel);
		this.setLayout(null);
		
		JLabel lblLogin = new JLabel("ID");
		lblLogin.setBounds(41,250, 69, 35); //버튼 위치와 크기 설정
		panel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(41, 300, 69, 35);
		panel.add(lblPassword);
		
		JTextField text = new JTextField();
		text.setBounds(120, 252, 170, 35);
		panel.add(text);
		text.setColumns(10); //최대 columns 갯수만큼의 텍스트를 입력할 수 있는 입력공간을 만듭니다
		
		JButton btnJoin = new JButton("회원가입");
		btnJoin.setBounds(200, 354, 104, 29);
		panel.add(btnJoin);
	
		JButton btnLogin = new JButton("로그인");
		btnLogin.setBounds(50, 354, 106, 29);
		panel.add(btnLogin);
		
		JPasswordField Password = new JPasswordField(); //패스워드필드로 변경함
		Password.setColumns(10); 
		Password.setBounds(120, 303, 170, 35);
		panel.add(Password);
		
		Image backimg = new ImageIcon("icon/로그인.png").getImage();
		JLabel back = new JLabel(new ImageIcon(backimg));
		back.setBounds(0,0,400,600);
		
		panel.add(back);
		
		// 로그인
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				id = text.getText();
				String firstLoginCheck = "";
				int changeLoginInformation = 0;
				
				firstLoginCheck = controller.loginCheck(text.getText(),Password.getText());
				
				if(firstLoginCheck.trim().equals("Y")) {
						JOptionPane.showMessageDialog(null, "메인 화면으로 이동합니다");
						setVisible(false);
						new mainmenu(text.getText());
				}else if(firstLoginCheck.trim().equals("N")){
					changeLoginInformation = controller.changeLoginInformation(id);
					if(changeLoginInformation == 1) { //그래서 위의 조건문을 통과한 것은 오라클(쿼리문)에서 1행이 실행되었습니다 
													  //여기서 1만 나오기 때문에 이 조건을 통과해 업데이트가 실행되고 아래의 코드가 실행된다.
						JOptionPane.showMessageDialog(null, "운동 강도 선택 화면으로 이동합니다");
						setVisible(false);
						new Difficulty(text.getText());
					}
				} else {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 다시 확인해 주세요.");
					setVisible(false);
					new LoginView();
				}
			}
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String firstLoginCheck = "";
//				firstLoginCheck = controller.loginCheck(text.getText());
//				if(firstLoginCheck.trim().equals("Y")) {
//					JOptionPane.showMessageDialog(null, "메인 화면으로 이동합니다");
//					setVisible(false);
//					new mainmenu();
//				}else if(firstLoginCheck.trim().equals("N")){
//					JOptionPane.showMessageDialog(null, "운동 강도 선택 화면으로 이동합니다");
//					setVisible(false);
//					new difficulty();
//				} else {
//					JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
//					setVisible(false);
//					new LoginView();
//					
//				}
//			}

		});
		
		// 회원가입 & 중복체크
		btnJoin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new JoinView();
			}
		});
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }
}
