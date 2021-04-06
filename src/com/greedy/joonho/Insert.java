package com.greedy.joonho;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Insert {
	
	
	public static void main(String[] args) {
		
		DataDTO newUser = new DataDTO();
		newUser.setId();
		newUser.setPwd();
		newUser.setName();
		/* 입력받은 값을 뭉쳐서 보내기 위해 DTO에 담고 전송한다.*/
		
		Connection con = getConnection();
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			String query = prop.getProperty("insertMenu");
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newUser.getName());
			pstmt.setString(2, newUser.getPwd());
			pstmt.setString(3, newUser.getName());
			
			result = pstmt.executeUpdate(); //executeUpdate(): insert/update/delete일때 사용
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		if(result > 0) {
			System.out.println("메뉴 등록 성공!!");
		} else {
			System.out.println("메뉴 등록 실패!!");
		}
		
		
		
		
		
		
		
		
		
	}

}
