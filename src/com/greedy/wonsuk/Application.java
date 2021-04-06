package com.greedy.wonsuk;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Application {

	public static void main(String[] args) {

		DataDTO dto = new DataDTO();
		dto.setId("입력한 id");
		dto.setPwd("입력한 pwd");
		dto.setName("입력한 닉네임");
		
		Connection con = getConnection();
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		Properties prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			String query = prop.getProperty("insertMenu");
			pstmt.setString(1, "id");
			pstmt.setString(2, "pwd");
			pstmt.setString(3, "name");
			
			
			
			result = pstmt.executeUpdate();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			//close(con);
		}
//		if(result > 0) {
//			System.out.println("메뉴 등록 성공");
//		}else {
//			System.out.println("메뉴 등록 실패");
//		} 	
	}

}
