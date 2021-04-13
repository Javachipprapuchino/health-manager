package com.greedy.member.model.dao;

import static com.greedy.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.greedy.member.model.dto.DataDTO;

public class DataDAO {
	
	private Properties prop = new Properties();
	
	public DataDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertData(Connection con, DataDTO dto) {


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

	public int checkId(Connection con,DataDTO dto) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		
		int result = 0;
		String query = prop.getProperty("checkId");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getId()); // 왜빠져야 하나? 이거는 ? 물음표 쓸 때 사용한다.
			rset = pstmt.executeQuery();
			if(rset.next()) {
				if(rset.getInt(1) > 0){
					result = 1;
				}else {
					result = 0;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
		
	}
	
	public DataDTO loginConfirm(Connection con,DataDTO dto) { // 아이디와 비밀번호도 같아야 로그인 가능하게하는 기능
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("loginConfirm");
//		DataDTO loginInformation = new DataDTO(); //이렇게 설정한 이유는 아이디와 
		DataDTO loginInformation = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getId()); //쿼리문 ? 안에 view id텍스트 필드에서 적은 id를 넣는 문장이다.
//			pstmt.setString(2, dto.getPwd());
			rset = pstmt.executeQuery(); //작성한 셀렉트 구문을 실행하고 그 값을 rset으로 넣어줍니다.
			if(rset.next()) {
				loginInformation = new DataDTO();
				loginInformation.setConfirm(rset.getString(1)); // 내가 설정한 쿼리문에 있는 Y/N 값을 가져오기 위해 작성한 코드 
				loginInformation.setPwd(rset.getString(2)); // 내가 설정한 쿼리문에 있는 비밀번호 값을 가져오기 위해 작성한 코드 
			} 
//			else {
//				loginInformation = null;
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
	
		return loginInformation;
	}
	
	public int updateCount(Connection con, DataDTO dto) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("totalCounting");
		
		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "USER01");
			pstmt.setString(2, "E01");
			pstmt.setString(3, "USER01");
			pstmt.setString(4, "E01");
			
			result = pstmt.executeUpdate();
			
			
			System.out.println("결과값 :" +result);
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
			pstmt.setString(1, "USER01");
			pstmt.setString(2, "E01");
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		return result;
		
		
	}
	
	public List<Map<String,Integer>> checkEx(Connection con,String str) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		List<Map<String,Integer>> exList = null;
		String query = prop.getProperty("selectEx");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, str); 
			rset = pstmt.executeQuery();
			exList = new ArrayList<>();
			while(rset.next()) {
				Map<String,Integer> category = new HashMap<>();
				category.put(rset.getString("EX_NAME"), rset.getInt("COUNTING"));
				
				exList.add(category);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return exList;
		
	}
	
	public int changeLoginInformation(Connection con,DataDTO dto) { //y/n바꿔주는 업데이트문
		
		PreparedStatement pstmt = null;
		int changeLoginInformation = 0;
		
		String query = prop.getProperty("changeLoginInformation");
		
		try {
			pstmt = con.prepareStatement(query); //작성한 쿼리문을 실행을 시킨다.
			pstmt.setString(1, dto.getId()); // ? 안에 view에서 작성한 id를 넣는다.
			
			changeLoginInformation = pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
			
		return changeLoginInformation;
	}
	
	public List<DataDTO> updateInformation(Connection con,DataDTO dto) {// 마이페이지에서 사용하는 리스트에 값 넣어주기
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<DataDTO> List = null;
		
		String query = prop.getProperty("updateInformation");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getId()); 
			
			rset = pstmt.executeQuery();
			
			List = new ArrayList<>();
			
			while(rset.next()) {
				DataDTO updateInformation = new DataDTO();
				updateInformation.setExerciseName(rset.getString(1));
				updateInformation.setExerciseCount(rset.getString(2));
				
				List.add(updateInformation);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		return List;
	}
	
	public DataDTO showExp(Connection con, DataDTO dto) {// 경험치 올려주는 기능

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("showExp");
//		DataDTO showExp = new DataDTO(); //이렇게 설정한 이유는 아이디와 
		DataDTO showExp = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getId()); // 쿼리문 ? 안에 view id텍스트 필드에서 적은 id를 넣는 문장이다.
			rset = pstmt.executeQuery(); // 작성한 셀렉트 구문을 실행하고 그 값을 rset으로 넣어줍니다.
			if (rset.next()) {
				showExp = new DataDTO();
				showExp.setNickName(rset.getString(1)); 
				showExp.setExp(rset.getInt(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return showExp;
	}
	
	
}
