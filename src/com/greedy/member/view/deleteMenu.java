package com.greedy.member.view;

import java.awt.Font;
import java.awt.MenuItem;
import java.awt.PopupMenu;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.greedy.member.model.service.MemberService;

public class deleteMenu extends JFrame {
   JPanel jp = new JPanel();
   private Font f1,f2;
   private MemberService memberService = new MemberService();
   
   
   public deleteMenu() { // 기본생성자
       
   }
   
   public deleteMenu(String loginId) {
	   super("삭제 메뉴");
       this.dispose();
       this.setVisible(true);
       this.setLayout(null);
       setLocationRelativeTo(null);
       // 팝업메뉴에 메뉴아이템 추가
       
		
       List<Map<String,Integer>> ExList = memberService.CheckEx(loginId);
       f1 = new Font("돋움",Font.PLAIN,15);
       f2 = new Font("돋움",Font.PLAIN,20);
       
       JButton back = new JButton("뒤");
       back.setLocation(0,0);
       back.setSize(100,50);
       add(back);
       back.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
			new mainmenu(loginId);
		}
	});
       
       JLabel jl1 = new JLabel("운동 삭제");
       jl1.setLocation(120,60);
       jl1.setSize(200,40);
       add(jl1);
       jl1.setFont(f2);
       
       JButton jb1 = new JButton("아직 설정되지 않았습니다.");
       jb1.setLocation(30,150); //150만 수정
       jb1.setSize(200,40);
       add(jb1);
       
       JButton jb11 = new JButton("삭제");
       jb11.setLocation(250,150);
       jb11.setSize(60,40);
       add(jb11);
       
       jb11.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			jb1.setText("아직 설정되지 않았습니다.");
			jb11.setEnabled(false);
		}
       });
       
       //
       
       JButton jb2 = new JButton("아직 설정되지 않았습니다.");
       jb2.setLocation(30,210); //150만 수정
       jb2.setSize(200,40);
       add(jb2);
       
       JButton jb21 = new JButton("삭제");
       jb21.setLocation(250,210);
       jb21.setSize(60,40);
       add(jb21);
       
       jb21.addActionListener(new ActionListener() {
   		
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			jb2.setText("아직 설정되지 않았습니다.");
   			jb21.setEnabled(false);
   		}
       });
       //
       
       JButton jb3 = new JButton("아직 설정되지 않았습니다.");
       jb3.setLocation(30,270); //150만 수정
       jb3.setSize(200,40);
       add(jb3);
       
       JButton jb31 = new JButton("삭제");
       jb31.setLocation(250,270);
       jb31.setSize(60,40);
       add(jb31);
       
       jb31.addActionListener(new ActionListener() {
   		
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			jb3.setText("아직 설정되지 않았습니다.");
   			jb31.setEnabled(false);
   		}
       });
       
       //
       
       JButton jb4 = new JButton("아직 설정되지 않았습니다.");
       jb4.setLocation(30,330); //150만 수정
       jb4.setSize(200,40);
       add(jb4);
       
       JButton jb41 = new JButton("삭제");
       jb41.setLocation(250,330);
       jb41.setSize(60,40);
       add(jb41);
       
       
       jb41.addActionListener(new ActionListener() {
   		
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			
   			jb4.setText("아직 설정되지 않았습니다.");
   			jb41.setEnabled(false);
   		}
       });
       
       if(ExList.size()>=1) {
    	   for(String key : ExList.get(0).keySet()) {
        	   jb1.setText(key+"  횟수 : "+ExList.get(0).get(key));
           }
       }
       
       if(ExList.size()>=2) {
    	   for(String key : ExList.get(1).keySet()) {
        	   jb2.setText(key+"  횟수 : "+ExList.get(1).get(key));
           }
       }
       
       if(ExList.size()>=3) {
    	   for(String key : ExList.get(2).keySet()) {
        	   jb3.setText(key+"  횟수 : "+ExList.get(2).get(key));
           }
       }
       
       if(ExList.size()>=4) {
    	   for(String key : ExList.get(3).keySet()) {
        	   jb4.setText(key+"  횟수 : "+ExList.get(3).get(key));
           }
       }
       
       add(jp);
       
      
       //x 종료버튼
       this.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               System.exit(0);
           }
       });
      
       
    
		  setSize(350, 550);
	       setVisible(true);
		
   }
   
   
//   public static void main(String[] args) {
//       new mainmenu();
//       
//   }
}
