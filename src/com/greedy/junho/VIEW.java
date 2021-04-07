package com.greedy.junho;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VIEW extends JFrame {
	
	private Controller controller = new Controller();
	public static void main(String[] args) {
		VIEW V = new VIEW();
		
	}
	
	public VIEW() {

		
		this.setSize(420, 620);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setSize(400,600);
		panel.setLayout(null);
//		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
//		panel.setLayout(null);
		
		JLabel join = new JLabel("회원가입");
		join.setBounds(159, 41, 101, 20);
		panel.add(join); //패널에 라벨을 붙착한거다.
		
		JLabel id = new JLabel("아이디");
		id.setBounds(69, 113, 64, 20);
		panel.add(id);
		
		JLabel password = new JLabel("비밀번호");
		password.setBounds(69, 163, 64, 20);
		panel.add(password);
		
		JLabel confirm = new JLabel("비밀번호확인");
		confirm.setBounds(69, 210, 90, 20);
		panel.add(confirm);
		
		JLabel username = new JLabel("닉네임");
		username.setBounds(69, 257, 64, 20);
		panel.add(username);
		
		JTextField ID = new JTextField();
		ID.setColumns(10);
		ID.setBounds(159, 106, 186, 35);
		panel.add(ID);
		
		JTextField Password = new JTextField();
		Password.setColumns(10);
		Password.setBounds(159, 156, 186, 35);
		panel.add(Password);
		
		JTextField Confirm = new JTextField();
		Confirm.setColumns(10);
		Confirm.setBounds(159, 203, 186, 35);
		panel.add(Confirm);
		
		JTextField Username = new JTextField();
		Username.setColumns(10);
		Username.setBounds(159, 250, 186, 35);
		panel.add(Username);
		
		JButton button = new JButton("가입");
		button.setBounds(206, 363, 139, 29);
		panel.add(button);
		
		
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.registNewMember(inputMember(ID.getText(), Password.getText(), Username.getText()));
				//Controller.registNewMember(inputMember(ID.getText(), Password.getText(), Username.getText()));
					
					
			}
		});

		
		Image backimg = new ImageIcon("icon/회원가입.png").getImage().getScaledInstance(500, 800, 0);
		JLabel back = new JLabel(new ImageIcon(backimg));
		back.setBounds(0,0,400,600);

		panel.add(back);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
   }
	
public Map<String, String> inputMember(String id, String pwd, String name) {
		
		Map<String, String> map = new HashMap<>();
		
		map.put("id", id );
		map.put("pwd", pwd );
		map.put("name", name );
		
		
		return map;
		
	}


//public static String inputID(String id) {
//	
//	HashSet<String> hset = new HashSet<>();
//	
//	hset.add(id);
//	
//	Object[] arrid = hset.toArray();
//	
//	
//	return arrid[0].toString();
//	
//}
//
//public static String inputPwd(String pwd) {
//HashSet<String> hset = new HashSet<>();
//
//hset.add(pwd);
//
//Object[] arrpwd = hset.toArray();
//
//
//return arrpwd[0].toString();
//}
//
//public static String inputName(String name) {
//
//HashSet<String> hset = new HashSet<>();
//
//hset.add(name);
//
//Object[] arrname = hset.toArray();
//
//
//return arrname[0].toString();
//
//}
}
	
