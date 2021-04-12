package com.greedy.member.controller;

import com.greedy.member.model.dto.DataDTO;
import com.greedy.member.model.service.MemberService;
import com.greedy.member.view.mainmenu;

public class UpdateDeleteController {
	
	private MemberService memberservice = new MemberService();

	public int updateCount(String id, String exCode) {
		
		
		DataDTO dataDTO = new DataDTO();
		
		dataDTO.setId("USER01");
		dataDTO.setExCode("E01");
		
		int registResult = memberservice.updateCount(dataDTO);
		
		return registResult;
	}
	

	public int deleteCount(String id, String exCode) {
		
		DataDTO dataDTO = new DataDTO();
		
		dataDTO.setId("USER01");
		dataDTO.setExCode("E01");
		
		int registResult = memberservice.deleteCount(dataDTO);
		
		return registResult;
		
	}
	
	
	

}
