package com.greedy.member.model.service;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.commit;
import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.greedy.member.model.dao.DataDAO;
import com.greedy.member.model.dao.UpdateAndDeleteDAO;
import com.greedy.member.model.dto.DataDTO;

public class MemberService {
	
	private DataDAO datadao = new DataDAO();
	private UpdateAndDeleteDAO upAndDeleteDAO = new UpdateAndDeleteDAO();
	
	
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


	public String selectAllCategory(DataDTO dataDTO) {
		
		/* 1. Connection 생성 */
		Connection con = getConnection();
		
		/* 2. DAO의 모든 카테고리 조회용 메소드를 호출하여 결과 리턴 받기 */
		String exCode = upAndDeleteDAO.selectExName(con, dataDTO);
		
		/* 3. 커넥션 닫기 */
		close(con);
		
		/* 4. 반환 받은 값 리턴 */
		return exCode;
	}


	public int updateCount(DataDTO dataDTO) {
		Connection con = getConnection();
		
		String result1 = "";
		int result2 = 0;
		
		//셀렉트 후, 얻은 운동코드를 사용하여 카운트 업데이트
		result1 = upAndDeleteDAO.selectExName(con, dataDTO); //result1에 selectExName에서 얻은 값을 담는다
		
		if(result1 != null) { //result1에 결과값이 담겼을시(NULL이 아닐시)에만 실행을 한다
			
			dataDTO.setExCode(result1); //dataDTO의 ExCode에 result1의 값을 담는다
			
			result2 = upAndDeleteDAO.updateCount(con, dataDTO); //result2에 updateCount에서 얻은 값을 담는다
			
			// 성공, 실패에 따른 트랜잭션 처리
			if(result2 > 0) { //result2가 0보다 크다면 성공이다
				commit(con);
				System.out.println("업데이트 후, 커밋 성공!!");
			} else {
				rollback(con);
				System.out.println("업데이트 실패, 롤백!!");
			}
		}

		// Connection 객체 소멸
		
		close(con);
		
		return result2; //결과값은 result2의 값을 반환한다
	}


	public int deleteCount(DataDTO dataDTO) {
		
		Connection con = getConnection();
		
		String result1 = "";
		int result2 = 0;
		
		//셀렉트 후, 얻은 운동코드를 사용하여 카운트 업데이트
		result1 = upAndDeleteDAO.selectExName(con, dataDTO); //result1에 selectExName에서 얻은 값을 담는다
		
		if(result1 != null) { //result1에 결과값이 담겼을시(NULL이 아닐시)에만 실행을 한다
			
			dataDTO.setExCode(result1); //dataDTO의 ExCode에 result1의 값을 담는다
			
			result2 = upAndDeleteDAO.deleteCount(con, dataDTO); //result2에 updateCount에서 얻은 값을 담는다
			
			// 성공, 실패에 따른 트랜잭션 처리
			if(result2 > 0) { //result2가 0보다 크다면 성공이다
				commit(con);
				System.out.println("업데이트 후, 커밋 성공!!");
			} else {
				rollback(con);
				System.out.println("업데이트 실패, 롤백!!");
			}
		}

		// Connection 객체 소멸
		
		close(con);
		
		return result2; //결과값은 result2의 값을 반환한다
		
		
	}


	
	public List<Map<String,Integer>> CheckEx(String str){
		Connection con = getConnection();
		
		List<Map<String,Integer>> exList = datadao.checkEx(con, str);
		return exList;
	}

	public int changeLoginInformation(DataDTO dataDTO) {
		
		Connection con = getConnection(); //컨넥션을 사용해서 연결을 시켜준다.
		
		int result = 0;
		
		result = datadao.changeLoginInformation(con, dataDTO); //dao에 있는 값을 가져와 result안에 담아준다.
		
		return result;
	}
	
	public List<DataDTO> updateInformation(DataDTO dataDTO){
		
		Connection con = getConnection();
		
		List<DataDTO>  List = datadao.updateInformation(con, dataDTO);
		
		close(con);
		
		return List;
	}
	
	public DataDTO showExp(DataDTO dataDTO) {

		Connection con = getConnection();

		DataDTO showExp = new DataDTO();

		showExp = datadao.showExp(con, dataDTO);

		return showExp;
	}


	public int updateExp(DataDTO dto) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		DataDTO updateExp = new DataDTO();
		
		result = upAndDeleteDAO.updateExp(con, dto);
		
		if(result > 0) {
			commit(con);
			System.out.println("경험치 업데이트 후, 커밋!");
		} else {
			rollback(con);
			System.out.println("경험치 업데이트 실패, 롤백!");
		}
		
		close(con);
		
		return result;
	}
	
public void insertSpinnerMem1(DataDTO dataDTO) {
		
		Connection con = getConnection();
		
//		int result = 0;
		
		/* result = */datadao.insertSpinner1(con, dataDTO);
		
		close(con);
		
//		return result;
	}
	public void insertSpinnerMem2(DataDTO dataDTO) {
		
		Connection con = getConnection();
		
//		int result = 0;
		
		/* result = */datadao.insertSpinner2(con, dataDTO);
		
		close(con);
		
//		return result;
	}
	public void insertSpinnerMem3(DataDTO dataDTO) {
		
		Connection con = getConnection();
		
//		int result = 0;
		
		/* result = */ datadao.insertSpinner3(con, dataDTO);
		
		close(con);
		
//		return result;
	}
public void insertSpinnerMem21(DataDTO dataDTO) {
		
		Connection con = getConnection();
		
//		int result = 0;
		
		/* result = */datadao.insertSpinner21(con, dataDTO);
		
		close(con);
		
//		return result;
	}
	public void insertSpinnerMem22(DataDTO dataDTO) {
		
		Connection con = getConnection();
		
//		int result = 0;
		
		/* result = */datadao.insertSpinner22(con, dataDTO);
		
		close(con);
		
//		return result;
	}
	public void insertSpinnerMem23(DataDTO dataDTO) {
		
		Connection con = getConnection();
		
//		int result = 0;
		
		/* result = */ datadao.insertSpinner23(con, dataDTO);
		
		close(con);
		
//		return result;
	}

	


	

}
