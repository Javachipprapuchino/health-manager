package com.greedy.member.model.service;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.greedy.member.model.dao.DataDAO;
import com.greedy.member.model.dto.DataDTO;

public class MemberService {
	
	private DataDAO datadao = new DataDAO();
	
	
	public int insertMember(DataDTO dataDTO) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		result = datadao.insertData(con, dataDTO);
		
		close(con);
		
		return result;
	}
	
	public int checkId(DataDTO dataDTO) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		result = datadao.checkId(con, dataDTO);

		close(con);
		
		return result;
	}

	public DataDTO loginConfirm(DataDTO dataDTO) {

		Connection con = getConnection();

		DataDTO loginInformation = new DataDTO();

		loginInformation = datadao.loginConfirm(con, dataDTO);

		return loginInformation;
	}
	

}
