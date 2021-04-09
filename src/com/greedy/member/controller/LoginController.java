package com.greedy.member.controller;

import javax.swing.JOptionPane;

import com.greedy.member.model.dto.DataDTO;
import com.greedy.member.model.service.MemberService;

public class LoginController {

	MemberService memberService = new MemberService();
	private DataDTO dataDTO = null;

	public String loginCheck(String id, String pwd) {

		dataDTO = new DataDTO();

		dataDTO.setId(id);

		// DataDTO dataDTO = new DataDTO();

		dataDTO = memberService.loginConfirm(dataDTO);

		String firstLoginCheck = "";
		if (dataDTO != null) {
			if (dataDTO.getPwd().equals(pwd)) {
				firstLoginCheck = dataDTO.getConfirm();
			}
		} else if(dataDTO == null) {
			firstLoginCheck ="fail";
		}

		return firstLoginCheck;
	}

}
