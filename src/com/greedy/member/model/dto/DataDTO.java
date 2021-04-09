package com.greedy.member.model.dto;

public class DataDTO {
	
	private int code;
	private String id;
	private String pwd;
	private String name;
	private String confirm;
	
	public DataDTO() {
		super();
	}

	public DataDTO(int code, String id, String pwd, String name, String confirm) {
		super();
		this.code = code;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.confirm = confirm;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	@Override
	public String toString() {
		return "DataDTO [code=" + code + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", confirm=" + confirm
				+ "]";
	}

	
	
	
	

}
