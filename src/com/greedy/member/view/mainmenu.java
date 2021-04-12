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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.greedy.member.controller.UpdateDeleteController;

public class mainmenu extends JFrame {
   JPanel jp = new JPanel();
   private Font f1,f2;
   
   
   
   
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
       super("메인 메뉴");
       this.dispose();
       this.setVisible(true);
       this.setLayout(null);
       // 팝업메뉴에 메뉴아이템 추가
       pm.add(pm_item1);
       pm.addSeparator(); // 구분선
       pm.add(pm_item2);
       pm.add(pm_item3);
       
       pm_item1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
   			new mypage();

		}
       });
       
       
       f1 = new Font("돋움",Font.PLAIN,15);
       f2 = new Font("돋움",Font.PLAIN,20);
       
       cal.setTime(date);
       int dayNum = cal.get(Calendar.DAY_OF_WEEK);
       
       
       JLabel jlday = new JLabel(week[dayNum]);
       jlday.setSize(200,30);
       jlday.setLocation(190,40);
       jlday.setFont(f1);
       add(jlday);
       
       jl.setSize(200,30);
       jl.setLocation(100,40);
       jl.setFont(f1);
      
       JLabel jl1 = new JLabel("오늘의 운동");
       jl1.setLocation(110,60);
       jl1.setSize(200,40);
       add(jl1);
       jl1.setFont(f2);
       
       JButton jb1 = new JButton("팔벌려뛰기");
       jb1.setLocation(30,150); //150만 수정
       jb1.setSize(200,40);
       add(jb1);
       
       JButton jb11 = new JButton("완료");
       jb11.setLocation(250,150);
       jb11.setSize(60,40);
       add(jb11);
       
       
       jb11.addActionListener(new ActionListener() {
    	   
    	 
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = "USER01";
			String exCode = "E01";
			UpdateDeleteController updatedeletecontroller = new UpdateDeleteController();
			updatedeletecontroller.updateCount(id, exCode);
			updatedeletecontroller.deleteCount(id, exCode);
			jb11.setEnabled(false);
			
		}
       });
       
       //
       
       JButton jb2 = new JButton("아직 설정되지 않았습니다.");
       jb2.setLocation(30,210); //150만 수정
       jb2.setSize(200,40);
       add(jb2);
       
       JButton jb21 = new JButton("완료");
       jb21.setLocation(250,210);
       jb21.setSize(60,40);
       add(jb21);
       
       jb21.addActionListener(new ActionListener() {
   		
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			jb21.setEnabled(false);
   		}
       });
       //
       
       JButton jb3 = new JButton("아직 설정되지 않았습니다.");
       jb3.setLocation(30,270); //150만 수정
       jb3.setSize(200,40);
       add(jb3);
       
       JButton jb31 = new JButton("완료");
       jb31.setLocation(250,270);
       jb31.setSize(60,40);
       add(jb31);
       
       jb31.addActionListener(new ActionListener() {
   		
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			jb31.setEnabled(false);
   		}
       });
       
       //
       
       JButton jb4 = new JButton("아직 설정되지 않았습니다.");
       jb4.setLocation(30,330); //150만 수정
       jb4.setSize(200,40);
       add(jb4);
       
       JButton jb41 = new JButton("완료");
       jb41.setLocation(250,330);
       jb41.setSize(60,40);
       add(jb41);
       
       
       jb41.addActionListener(new ActionListener() {
   		
   		@Override
   		public void actionPerformed(ActionEvent e) {
   			jb41.setEnabled(false);  	
   			
   		}
       });
       
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
	       setVisible(true);
		
   }
   
   
   
   public static void main(String[] args) {
       new mainmenu();
  }
}
