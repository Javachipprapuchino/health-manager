package com.greedy.member.view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.greedy.member.controller.LoginController;
import com.greedy.member.model.dto.DataDTO;

import java.awt.*;
import java.util.List;

public class mypage extends JFrame {
	private Font f1,f2;
	private LoginController loginController = new LoginController();
	
	public mypage(String loginId) {
		
		DataDTO dataDTO = loginController.showExp(loginId);
		List<DataDTO> listDTO = loginController.updateInformation(loginId);
		
		Dimension dim = new Dimension(350, 550);//단순 2차원값 입력을 위한 클래스
		
		JFrame frame = new JFrame("마이페이지");
        frame.setLocation(0, 0);				  //출력 위치를 화면 좌상단에 위치
        frame.setPreferredSize(dim);              //위 코드에서 지정한 좌표를 프레임 사이즈로 사용
        frame.setLayout(null);                    //레이아웃을 사용하지 않고 절대좌표계 사용
        
        f1 = new Font("돋움",Font.PLAIN,15);
        f2 = new Font("바탕",Font.BOLD,30);
        
        String header[]={"운동명", "횟수"};
        DefaultTableModel model = new DefaultTableModel(header,0);
        JTable table = new JTable(model);
		for (int i = 0; i < 9; i++) {
			model.addRow(new Object[] { listDTO.get(i).getExerciseName(), listDTO.get(i).getExerciseCount() });
		};

//        JTable table = new JTable(contents, header);
       
        JScrollPane jscp1 = new JScrollPane(table); //이런식으로 생성시에 테이블을 넘겨주어야 정상적으로 볼 수 있다.
                                                    //jscp1.add(table); 과 같이 실행하면, 정상적으로 출력되지 않음.
        
        table.getColumnModel().getColumn(0).setPreferredWidth(300);
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        
        TableColumnModel tcm = table.getColumnModel();
        
        for(int i=0; i<tcm.getColumnCount(); i++) {
        	tcm.getColumn(i).setCellRenderer(dtcr);
        }

        
        jscp1.setLocation(7,180);
        jscp1.setSize(300,160);
        frame.add(jscp1);
        


        JLabel jl = new JLabel("내 정보");
        jl.setLocation(130,10);
        jl.setSize(100,20);
        frame.add(jl);
        jl.setFont(f1);
        
        JLabel jl1 = new JLabel(dataDTO.getNickName() + "님의 레벨 : " + dataDTO.getExp()/1000);
        jl1.setLocation(50,30);
        jl1.setSize(300,40);
        frame.add(jl1);
        jl1.setFont(f2);
        
        JLabel jl2 = new JLabel("지금까지 한 운동들");
        jl2.setLocation(90,150);
        jl2.setSize(130,20);
        frame.add(jl2);
        jl2.setFont(f1);
        
        JProgressBar progress = new JProgressBar();
        progress.setStringPainted(true);
        progress.setLocation(100,70);
        progress.setSize(100,20);
        progress.setValue(dataDTO.getExp()/10000);
        frame.add(progress);
        
        frame.pack();
        frame.setVisible(true);
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //닫기버튼 클릭시 프로그램 종료
        
	}

//    public static void main(String args[]){
//        new mypage();
//    }
}