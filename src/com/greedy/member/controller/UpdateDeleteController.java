package com.greedy.member.controller;

import com.greedy.member.model.dto.DataDTO;
import com.greedy.member.model.service.MemberService;
import com.greedy.member.view.mainmenu;

public class UpdateDeleteController {

	private MemberService memberservice = new MemberService();

	public int updateCount(String id, String exName) {

		DataDTO dataDTO = new DataDTO();
		dataDTO.setId(id); //dataDTO의 Id에 현재 로그인중인 아이디를 담는다
		dataDTO.setExName(exName); //dataDTO의 ExName에 현재 진행중인 운동의 이름을 담는다

		int registResult = memberservice.updateCount(dataDTO); //memberservice에서 updateCount 메소드를 호출한다

		return registResult; // memberservice.updateCount에서 받은 결과값을 registResult에 담아 리턴시킨다
	}


	public int deleteCount(String id, String exName) {

		DataDTO dataDTO = new DataDTO();
		dataDTO.setId(id);
		dataDTO.setExName(exName);

		int registResult = memberservice.deleteCount(dataDTO);

		return registResult;

	}


	public int updateExp(String id) {

		DataDTO dataDTO = new DataDTO();
		dataDTO.setId(id);

		int registResult = memberservice.updateExp(dataDTO);

		return registResult;


	}





}
