package com.greedy.member.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.greedy.member.controller.LoginController;

public class LoginView extends JFrame {
	
	LoginController controller = new LoginController();
	String id = "";
	private Font font1;
	
	public LoginView() {
		
		super("로그인");
		this.setSize(350, 550);
		setLocationRelativeTo(null); // 윈도우 창에서 가운데 화면으로 띄우는 역학을 한다.
		JPanel panel = new JPanel();
		setContentPane(panel);
		this.setLayout(null);
		font1 = new Font("Bauhaus 93",Font.PLAIN,30);
		
		JLabel lblLogin = new JLabel("ID");
		lblLogin.setBounds(41,120, 69, 35); //버튼 위치와 크기 설정
		lblLogin.setFont(font1);
		panel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("PWD");
		lblPassword.setBounds(41, 170, 69, 35);
		lblPassword.setFont(font1);
		panel.add(lblPassword);
		
		JTextField text = new JTextField();
		text.setBounds(120, 120, 170, 35);
		panel.add(text);
		text.setColumns(10); //최대 columns 갯수만큼의 텍스트를 입력할 수 있는 입력공간을 만듭니다.
		
		ImageIcon joinCon = new ImageIcon("icon/join.png"); //회원가입버튼이미지
		JButton btnJoin = new JButton(joinCon);
		btnJoin.setBounds(200, 250, 106, 50);
		panel.add(btnJoin);
	
		ImageIcon loginCon = new ImageIcon("icon/login.png"); //로그인버튼이미지
		JButton btnLogin = new JButton(loginCon);
		btnLogin.setBounds(50, 250, 106, 50);
		panel.add(btnLogin);
		
		JPasswordField password = new JPasswordField(); //패스워드필드로 변경함
		password.setColumns(10); 
		password.setBounds(120, 170, 170, 35);
		panel.add(password);
		
		Image backimg = new ImageIcon("icon/background.png").getImage();
		JLabel back = new JLabel(new ImageIcon(backimg));
		back.setBounds(0, 0, 350, 550);
		
		// 비밀번호 입력후 키 이벤트를 이용해서 엔터키를 적용
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					id = text.getText();
					String firstLoginCheck = "";
					int changeLoginInformation = 0;
					
					firstLoginCheck = controller.loginCheck(text.getText(),password.getText());
					
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
				
				
			}
		});
		
		panel.add(back);
		
		// 로그인
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				id = text.getText();
				String firstLoginCheck = "";
				int changeLoginInformation = 0;
				
				firstLoginCheck = controller.loginCheck(text.getText(),password.getText());
				
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
