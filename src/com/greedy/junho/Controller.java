package com.greedy.junho;

import java.util.Map;

public class Controller {

	private static MemberResultView memberResultView = new MemberResultView();
//	private MemberService memberService = new MemberService();
	
public static void registNewMember(Map<String, String> requestMap) {
		
		/* Map으로 전달 된 데이터를 꺼내 MemberDTO에 담아 Service로 전달 */
		DataDTO dataDTO = new DataDTO();
		dataDTO.setId(requestMap.get("id"));
		dataDTO.setPwd(requestMap.get("pwd"));
		dataDTO.setName(requestMap.get("name"));
		
		
		int registResult = memberService.insertMember(dataDTO);
		
		if(registResult > 0) {
			memberResultView.displayDmlResult("insertSuccess");
		} else {
			memberResultView.displayDmlResult("insertFailed");
		}
	}
	
}
