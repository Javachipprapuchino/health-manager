package com.greedy.member.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.greedy.member.controller.JoinController;



public class JoinView extends JFrame {

	private JoinController controller = new JoinController();
	JPasswordField Password,Confirm;
	JTextField ID;
	JTextField Username;
	private Font font1;
	private Font font2;
	
	
	public JoinView() {

		super("회원가입");
		this.setSize(350, 550);
		setLocationRelativeTo(null);
		font1 = new Font("Bauhaus 93",Font.PLAIN,50);
		font2 = new Font("맑은 고딕", Font.BOLD, 15);

		JPanel panel = new JPanel();
		panel.setSize(400, 600);
		panel.setLayout(null);
		setContentPane(panel);

		
		JLabel join = new JLabel("JOIN");
		join.setFont(font1);
		join.setBounds(130, -55, 221, 220);
		panel.add(join); // 패널에 라벨을 붙착한거다.
		

		JLabel id = new JLabel("아이디");
		id.setBounds(40, 113, 64, 20);
		id.setFont(font2);
		panel.add(id);

		JLabel password = new JLabel("비밀번호");
		password.setBounds(40, 163, 64, 20);
		password.setFont(font2);
		panel.add(password);

		JLabel confirm = new JLabel("비번확인");
		confirm.setBounds(40, 210, 90, 20);
		confirm.setFont(font2);
		panel.add(confirm);

		JLabel username = new JLabel("닉네임");
		username.setBounds(40, 257, 64, 20);
		username.setFont(font2);
		panel.add(username);

		ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(120, 106, 186, 35);
		panel.add(ID);
		
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
	    		new LoginView();
				dispose();
			}
		});
		
		
		Password = new JPasswordField();
		Password.setColumns(10);
		Password.setBounds(120, 156, 186, 35);
		panel.add(Password);

		Confirm = new JPasswordField();
		Confirm.setColumns(10);
		Confirm.setBounds(120, 203, 186, 35);
		panel.add(Confirm);

		Username = new JTextField();
		Username.setColumns(10);
		Username.setBounds(120, 250, 186, 35);
		panel.add(Username);

		ImageIcon joinCon = new ImageIcon("icon/가입.png"); //가입버튼이미지
		JButton button = new JButton(joinCon);
		button.setBounds(120, 300, 139, 29);
		panel.add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(controller.checkId(ID.getText()) > 0) { //텍스트 박스에서 가져오기 USER01안에 들어가는걸

					JOptionPane.showMessageDialog(null, "중복된 아이디 입니다");
					setVisible(false);
					new JoinView();
				}else {
					char[] pass = Password.getPassword(); //***로 되어있는 비밀번호를 해독
					String pwd = "";
					for(int i = 0; i < pass.length; i++) {
						//System.out.print(pass[i]);
						pwd += pass[i];
					}
					
					char[] con = Confirm.getPassword();
					String conf = "";
					for(int i = 0; i < con.length; i++) {
						//System.out.print(pass[i]);
						conf += con[i];
					}
					if(ID.getText().equals("")||pwd.equals("")||conf.equals("")||Username.getText().equals("")) {
						new ErrorPage2();

					}
					else {
						if(conf.equals(pwd)) {
							controller.registNewMember(inputMember(ID.getText(), pwd, Username.getText()));
							setVisible(false);
							new PopupPage();
							
						}
						else {
							new ErrorPage();
						}
					}
				}
		
				
				// Controller.registNewMember(inputMember(ID.getText(), Password.getText(),
				// Username.getText()));

			}
		});

		Image backimg = new ImageIcon("icon/background.png").getImage();
		JLabel back = new JLabel(new ImageIcon(backimg));
		back.setBounds(0, 0, 350, 550);

		panel.add(back);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	

	public Map<String, String> inputMember(String id, String pwd, String name) {

		Map<String, String> map = new HashMap<>();

		map.put("id", id);
		map.put("pwd", pwd);
		map.put("name", name);

		return map;

	}
}
