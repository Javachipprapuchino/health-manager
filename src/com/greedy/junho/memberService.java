package com.greedy.junho;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.sql.Connection;

public class MemberService {

	private DataDAO datadao = new DataDAO();
	
	public int insertMember(DataDTO dataDTO) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		result = datadao.insertData(con, dataDTO);
		
		close(con);
		
		return result;
	}

}
