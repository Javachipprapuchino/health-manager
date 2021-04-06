package com.greedy.wonsuk;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DataDAO {
	
	private Properties prop = new Properties();
	
	public DataDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertData(DataDTO dto) {

		Connection con = getConnection();

		PreparedStatement pstmt = null;

		int result = 0;

		try {

			String query = prop.getProperty("insertData");
			
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());

			result = pstmt.executeUpdate();

		} catch (Exception e) {

			System.out.println(e.toString());

		} finally {
			close(pstmt);
			close(con);
		}
		return result;
	}
	
	
	
}
