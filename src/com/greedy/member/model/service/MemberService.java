package com.greedy.member.model.service;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.commit;
import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.rollback;

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


	public int updateCount(DataDTO dataDTO) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = datadao.updateCount(con, dataDTO);
		
		// 성공, 실패에 따른 트랜잭션 처리
		
		if(result > 0) {
			commit(con);
			System.out.println("업데이트 후, 커밋 성공!!");
		} else {
			rollback(con);
			System.out.println("업데이트 실패, 롤백!!");
		}
		
		// Connection 객체 소멸
		
		close(con);
		
		return result;
	}

	public int deleteCount(DataDTO dataDTO) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		result = datadao.deleteCount(con, dataDTO);
		
		if(result > 0) {
			commit(con);
			System.out.println("삭제 후, 커밋 성공!!");
		} else {
			rollback(con);
			System.out.println("삭제 실패, 롤백!!");
		}
		return 0;
	}





	




	


	

}
