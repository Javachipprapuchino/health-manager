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

	public int insertData(Connection con, DataDTO dto) { // 회원가입에서 기입한 정보 insert 해주는 기능 (원석)


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

	public int checkId(Connection con,DataDTO dto) { // 회원가입시 중복된 아이디 체크해주는 기능 (원석)

		PreparedStatement pstmt = null;
		ResultSet rset = null; 

		int result = 0;
		String query = prop.getProperty("checkId");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getId());
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

	public DataDTO loginConfirm(Connection con,DataDTO dto) { // 아이디와 비밀번호도 같아야 로그인 가능하게하는 기능 (원석)

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("loginConfirm");
		DataDTO loginInformation = null;
		try {
			pstmt = con.prepareStatement(query); 
			pstmt.setString(1, dto.getId()); 
			rset = pstmt.executeQuery(); 
			if(rset.next()) {
				loginInformation = new DataDTO();
				loginInformation.setConfirm(rset.getString(1)); 
				loginInformation.setPwd(rset.getString(2)); 
			} 

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return loginInformation;
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

	public int changeLoginInformation(Connection con,DataDTO dto) { // y/n바꿔주는 기능 업데이트문 (원석)

		PreparedStatement pstmt = null;
		int changeLoginInformation = 0;

		String query = prop.getProperty("changeLoginInformation");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getId()); 

			changeLoginInformation = pstmt.executeUpdate(); 

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}

		return changeLoginInformation;
	}

	public List<DataDTO> updateInformation(Connection con,DataDTO dto) { // 운동 이름과 횟수를 마이페이에 올려주는 기능 (원석)

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

	public DataDTO showExp(Connection con, DataDTO dto) {// 경험치 올려주는 기능 (원석)

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("showExp");
		DataDTO showExp = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getId()); 
			rset = pstmt.executeQuery(); 
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

	public int insertSpinner1(Connection con, DataDTO dto) {


		PreparedStatement pstmt = null;

		int result = 0;

		try {

			String query = prop.getProperty("insertSpinner1");

			pstmt = con.prepareStatement(query);

			pstmt.setString(1, dto.getId());
			pstmt.setInt(2, dto.getNo1());
			pstmt.setString(3, dto.getExcode1());

			result = pstmt.executeUpdate();


		} catch (Exception e) {

			System.out.println(e.toString());

		} finally {
			close(pstmt);
			close(con);
		}
		return result;
	}


	public int insertSpinner2(Connection con, DataDTO dto) {


		PreparedStatement pstmt = null;

		int result = 0;

		try {

			String query = prop.getProperty("insertSpinner1");

			pstmt = con.prepareStatement(query);

			pstmt.setString(1, dto.getId());
			pstmt.setInt(2, dto.getNo2());
			pstmt.setString(3, dto.getExcode2());

			result = pstmt.executeUpdate();


		} catch (Exception e) {

			System.out.println(e.toString());

		} finally {
			close(pstmt);
			close(con);
		}
		return result;
	}

	public int insertSpinner3(Connection con, DataDTO dto) {


		PreparedStatement pstmt = null;

		int result = 0;

		try {

			String query = prop.getProperty("insertSpinner1");

			pstmt = con.prepareStatement(query);

			pstmt.setString(1, dto.getId());
			pstmt.setInt(2, dto.getNo3());
			pstmt.setString(3, dto.getExcode3());

			result = pstmt.executeUpdate();


		} catch (Exception e) {

			System.out.println(e.toString());

		} finally {
			close(pstmt);
			close(con);
		}
		return result;
	}




	public int insertSpinner21(Connection con, DataDTO dto) {


		PreparedStatement pstmt = null;

		int result = 0;

		try {

			String query = prop.getProperty("insertSpinner2");

			pstmt = con.prepareStatement(query);


			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getExcode1());
			pstmt.setString(3, dto.getExcode1());
			pstmt.setString(4, dto.getId());
			pstmt.setString(5, dto.getExcode1());

			result = pstmt.executeUpdate();


		} catch (Exception e) {

			System.out.println(e.toString());

		} finally {
			close(pstmt);
			close(con);
		}
		return result;
	}


	public int insertSpinner22(Connection con, DataDTO dto) {


		PreparedStatement pstmt = null;

		int result = 0;

		try {

			String query = prop.getProperty("insertSpinner2");

			pstmt = con.prepareStatement(query);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getExcode2());
			pstmt.setString(3, dto.getExcode2());
			pstmt.setString(4, dto.getId());
			pstmt.setString(5, dto.getExcode2());

			result = pstmt.executeUpdate();


		} catch (Exception e) {

			System.out.println(e.toString());

		} finally {
			close(pstmt);
			close(con);
		}
		return result;
	}

	public int insertSpinner23(Connection con, DataDTO dto) {


		PreparedStatement pstmt = null;

		int result = 0;

		try {

			String query = prop.getProperty("insertSpinner2");

			pstmt = con.prepareStatement(query);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getExcode3());
			pstmt.setString(3, dto.getExcode3());
			pstmt.setString(4, dto.getId());
			pstmt.setString(5, dto.getExcode3());

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
