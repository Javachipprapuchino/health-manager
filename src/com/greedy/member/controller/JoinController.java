package com.greedy.member.controller;

import java.util.Map;

import com.greedy.member.model.dto.DataDTO;
import com.greedy.member.model.service.MemberService;
import com.greedy.member.view.MemberResultView;

public class JoinController {
	private MemberResultView memberResultView = new MemberResultView();
	private MemberService memberService = new MemberService();
	
	public void registNewMember(Map<String, String> requestMap) {

		/* Map으로 전달 된 데이터를 꺼내 MemberDTO에 담아 Service로 전달 */
		DataDTO dataDTO = new DataDTO();
		dataDTO.setId(requestMap.get("id"));
		dataDTO.setPwd(requestMap.get("pwd"));
		dataDTO.setName(requestMap.get("name"));

		int registResult = memberService.insertMember(dataDTO);

		if (registResult > 0) {
			memberResultView.displayDmlResult("insertSuccess");
		} else {
			memberResultView.displayDmlResult("insertFailed");
		}
	}

	public int checkId(String id) {
		
		DataDTO dataDTO = new DataDTO();
		dataDTO.setId(id);
		
		int Result = memberService.checkId(dataDTO);
		
		if(Result > 0) {
			System.out.println(Result);
		}else {
			System.out.println(Result);
		}
		
		return Result;
	}
	
	
}
