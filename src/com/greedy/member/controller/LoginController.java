package com.greedy.member.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.greedy.member.model.dto.DataDTO;
import com.greedy.member.model.service.MemberService;

public class LoginController {

	MemberService memberService = new MemberService();
	private DataDTO dataDTO = null;

	public String loginCheck(String id, String pwd) {

		dataDTO = new DataDTO();

		dataDTO.setId(id); //작성한 id값을 계속 가져가기 위해 작성한 코드

		// DataDTO dataDTO = new DataDTO();

		dataDTO = memberService.loginConfirm(dataDTO);

		String firstLoginCheck = "";
		if (dataDTO != null) { // dataDTO가 널이 아닐경우 view안에 작성한 비밀번호와 db안에 있는 비밀번호가 같으면 y/n을 가지고 뷰의 조건문으로 가는 코드
			if (dataDTO.getPwd().equals(pwd)) {
				firstLoginCheck = dataDTO.getConfirm();
			}
		} else if(dataDTO == null) {
			firstLoginCheck ="fail";
		}

		return firstLoginCheck;
	}

	public int changeLoginInformation(String id) {

		dataDTO = new DataDTO();

		dataDTO.setId(id);

		int result = memberService.changeLoginInformation(dataDTO); // dao에 있는 값을 여기 result안에 담아준다.

		return result;

	}

	public List<DataDTO> updateInformation(String id) {

		dataDTO = new DataDTO();

		dataDTO.setId(id);

		List<DataDTO> list = memberService.updateInformation(dataDTO);

		return list;

	}

	public DataDTO showExp(String id) {

		dataDTO = new DataDTO();

		dataDTO.setId(id);

		// DataDTO dataDTO = new DataDTO();

		dataDTO = memberService.showExp(dataDTO);

		return dataDTO;
	}

}
