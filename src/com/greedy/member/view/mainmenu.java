package com.greedy.member.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.greedy.member.controller.UpdateDeleteController;
import com.greedy.member.model.service.MemberService;

public class mainmenu extends JFrame {
   JPanel jp = new JPanel();
   private Font f1,f2;
   private MemberService memberService = new MemberService();
   String name1;
   String name2;
   String name3;
   String name4;

   

   PopupMenu pm = new PopupMenu();
   MenuItem pm_item1 = new MenuItem("마이페이지");
   MenuItem pm_item2 = new MenuItem("운동 추가");
   MenuItem pm_item3 = new MenuItem("운동 삭제");
   
   
   
   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
   Date date = new Date();        
   String dateToStr = dateFormat.format(date);
   String[] week = new String[] {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
   Calendar cal = Calendar.getInstance();
   
   JLabel jl = new JLabel(dateToStr);
   public mainmenu() { // 기본생성자
     
   }
   
   public mainmenu(String loginId) {
	   
	   
	   
	   super("메인 메뉴");
       this.dispose();
       this.setVisible(true);
       this.setLayout(null);
       this.setLocationRelativeTo(null);
       
       // 팝업메뉴에 메뉴아이템 추가
       pm.add(pm_item1);
       pm.addSeparator(); // 구분선
       pm.add(pm_item2);
       pm.add(pm_item3);
	
       
       List<Map<String,Integer>> ExList = memberService.CheckEx(loginId);
       System.out.println(ExList);
       
       
       pm_item1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
			new mypage(loginId);

		}
       });
       
       
       pm_item2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
			new Difficulty(loginId);
		}
	});
       //////
       Image backimg = new ImageIcon("icon/background.png").getImage(); //배경이미지
       JLabel back = new JLabel(new ImageIcon(backimg));
       back.setBounds(0,0,350,550); 
       
       
//       JButton backb = new JButton("뒤");
//       backb.setLocation(0,0);
//       backb.setSize(100,50);
//       backb.setFocusPainted(false);
//       add(backb);
//       backb.addActionListener(new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			setVisible(false);
//			new Difficulty(loginId);
//		}
//	});
     // ///// 
       pm_item3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
			new deleteMenu(loginId);
		}
	});
       
       f1 = new Font("맑은 고딕",Font.PLAIN,15);
       f2 = new Font("맑은 고딕",Font.BOLD,30);
       
       cal.setTime(date);
       int dayNum = cal.get(Calendar.DAY_OF_WEEK)-1;
       
		
       
       
       JLabel jlday = new JLabel(week[dayNum]);
       jlday.setSize(200,30);
       jlday.setLocation(190,40);
       jlday.setFont(f1);
       add(jlday);
       
       jl.setSize(200,30);
       jl.setLocation(100,40);
       jl.setFont(f1);
      
       JLabel jl1 = new JLabel("오늘의 운동");
       jl1.setLocation(90,60);
       jl1.setSize(200,40);
       add(jl1);
       jl1.setFont(f2);
       
       JButton jb1 = new JButton("설정되지 않았습니다.");
       jb1.setLocation(30,150); //150만 수정
       jb1.setSize(200,40);
       jb1.setBackground(Color.orange);
       jb1.setFont(f1);
       jb1.setFocusPainted(false);
       add(jb1);
       
       ImageIcon okCon = new ImageIcon("icon/체크박스2.png");
       JButton jb11 = new JButton(okCon);
       jb11.setContentAreaFilled(false);
       jb11.setBorderPainted(false);
       jb11.setLocation(250,150);
       jb11.setSize(60,40);
       add(jb11);
       
       jb11.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = loginId; //현재 로그인중인 아이디 값을 가져온다
			String exName = name1;
			System.out.println("버튼1 호출");
			int result = new UpdateDeleteController().updateCount(id,exName);
			System.out.println("결과값 : " + result);
			if(result > 0) {
				new UpdateDeleteController().updateExp(id);
			}
			jb11.setEnabled(false);
			//controller의 updateCount에 id와 exName을 담아 호출한다
			//리턴 받은 값을 result에 담는다

		}
       });
       
       //
       
       JButton jb2 = new JButton("설정되지 않았습니다.");
       jb2.setLocation(30,210); //150만 수정
       jb2.setSize(200,40);
       jb2.setFocusPainted(false);
       jb2.setBackground(Color.orange);
       jb2.setFont(f1);
       add(jb2);
       
       ImageIcon okCon2 = new ImageIcon("icon/ok.png");
       JButton jb21 = new JButton(okCon);
       jb21.setContentAreaFilled(false);
       jb21.setBorderPainted(false);
       jb21.setLocation(250,210);
       jb21.setSize(60,40);
       add(jb21);
       
       jb21.addActionListener(new ActionListener() {
   		
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			String id = loginId; //현재 로그인중인 아이디 값을 가져온다
			String exName = name2;
			System.out.println("버튼2 호출");
			int result = new UpdateDeleteController().updateCount(id,exName);
			System.out.println("결과값 : " + result);
			if(result > 0) {
				new UpdateDeleteController().updateExp(id);
			}
			jb21.setEnabled(false);
			//controller의 updateCount에 id와 exName을 담아 호출한다
			//리턴 받은 값을 result에 담는다
   		}
       });
       //
       
       JButton jb3 = new JButton("설정되지 않았습니다.");
       jb3.setLocation(30,270); //150만 수정
       jb3.setSize(200,40);
       jb3.setFocusPainted(false);
       jb3.setBackground(Color.orange);
       jb3.setFont(f1);
       add(jb3);
       
       JButton jb31 = new JButton(okCon);
       jb31.setContentAreaFilled(false);
       jb31.setBorderPainted(false);
       jb31.setLocation(250,270);
       jb31.setSize(60,40);
       add(jb31);
       
       jb31.addActionListener(new ActionListener() {
   		
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			String id = loginId; //현재 로그인중인 아이디 값을 가져온다
			String exName = name3;
			System.out.println("버튼3 호출");
			int result = new UpdateDeleteController().updateCount(id,exName);
			System.out.println("결과값 : " + result);
			if(result > 0) {
				new UpdateDeleteController().updateExp(id);
			}
			jb31.setEnabled(false);
			//controller의 updateCount에 id와 exName을 담아 호출한다
			//리턴 받은 값을 result에 담는다
   		}
       });
       
       // 앞의 운동 선택 페이지에 운동이 최대 3개로 설정되어있음
       
//       JButton jb4 = new JButton("아직 설정되지 않았습니다.");
//       jb4.setLocation(30,330); //150만 수정
//       jb4.setSize(200,40);
//       add(jb4);
//       
//       JButton jb41 = new JButton("완료");
//       jb41.setLocation(250,330);
//       jb41.setSize(60,40);
//       add(jb41);
//       
//       
//       jb41.addActionListener(new ActionListener() {
//   		
//   		@Override
//   		public void actionPerformed(ActionEvent e) {
//   			String id = loginId; //현재 로그인중인 아이디 값을 가져온다
//			String exName = name4;
//			System.out.println("버튼4 호출");
//			new UpdateDeleteController().updateCount(id,exName); 
//			jb41.setEnabled(false);
//			//controller의 updateCount에 id와 exName을 담아 호출한다
//			//리턴 받은 값을 result에 담는다
//   		}
//       });
       
       
       
     
       
       if(ExList.size()>=1) {
    	   for(String key : ExList.get(0).keySet()) {
        	   jb1.setText(key+"  횟수 : "+ExList.get(0).get(key));
        	   name1 = key.toString();
           }
       }
       
       if(ExList.size()>=2) {
    	   for(String key : ExList.get(1).keySet()) {
        	   jb2.setText(key+"  횟수 : "+ExList.get(1).get(key));
        	   name2 = key.toString();
           }
       }
       
       if(ExList.size()>=3) {
    	   for(String key : ExList.get(2).keySet()) {
        	   jb3.setText(key+"  횟수 : "+ExList.get(2).get(key));
        	   name3 = key.toString();
           }
       }
       
//       if(ExList.size()>=4) {
//    	   for(String key : ExList.get(3).keySet()) {
//        	   jb4.setText(key+"  횟수 : "+ExList.get(3).get(key));
//        	   name4 = key.toString();
//           }
//       }
       add(jp);
       add(jl);
       add(pm); // 팝업메뉴를 프레임에 추가
       
      
       //x 종료버튼
       this.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               System.exit(0);
           }
       });
     
       //팝업메뉴 보여주기 이벤트
       this.addMouseListener(new MouseAdapter() {

           @Override
           public void mousePressed(MouseEvent me) {
               // 오른쪽 마우스 버튼을 누르면 PopupMenu를 화면에 보여준다.
               if (me.getButton() == MouseEvent.BUTTON3)
                   pm.show(mainmenu.this, me.getX(), me.getY());
           }
       });
       
       
    
		  setSize(350, 550);
		  setLocationRelativeTo(null);
	      setVisible(true);
	      add(back);
		
   }
   
//   public static void main(String[] args) {
//       new mainmenu();
//       
//   }
}
