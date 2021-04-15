package com.greedy.member.model.dao;

import static com.greedy.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.greedy.member.model.dto.DataDTO;

public class UpdateAndDeleteDAO {
	
	private Properties prop = new Properties();
	
	public UpdateAndDeleteDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public String selectExName(Connection con, DataDTO dto){
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String result = "";
		
		String query = prop.getProperty("selectExName");
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getExName());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				result = rset.getString("EX_CODE");
				System.out.println("결과값 : " + result);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
		
	}	
	
	
	public int updateCount(Connection con, DataDTO dto) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("totalCounting");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getExCode());
			pstmt.setString(3, dto.getId());
			pstmt.setString(4, dto.getExCode());
			
			result = pstmt.executeUpdate();
			
			System.out.println("결과값 : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		if(result > 0) {
			System.out.println("업데이트 성공!");
		} else {
			System.out.println("업데이트 실패!");
		}
		
		return result;
	}
	

	public int deleteCount(Connection con, DataDTO dto) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			
			String query = prop.getProperty("deleteCount");
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getExCode());
			
			result = pstmt.executeUpdate();
			
			System.out.println("결과값 : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		if(result > 0) {
			System.out.println("삭제 성공!");
		} else {
			System.out.println("삭제 실패!");
		}
		
		return result;
		
		
	}


	public int updateExp(Connection con, DataDTO dto) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateExp");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getId());
			
			result = pstmt.executeUpdate();
			
			System.out.println("결과값 : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		if(result > 0) {
			System.out.println("경험치 업데이트 성공!");
		} else {
			System.out.println("경험치 업데이트 실패!");
		}
	
		return result;
				
				
	}



	

}
