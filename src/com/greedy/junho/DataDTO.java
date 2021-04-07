package com.greedy.junho;

public class DataDTO {
	
	private int code;
	private String id;
	private String pwd;
	private String name;
	private int exp;
	
	public DataDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataDTO(int code, String id, String pwd, String name, int exp) {
		super();
		this.code = code;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.exp = exp;
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

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "DataDTO [code=" + code + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", exp=" + exp + "]";
	}


	
	
	
	
	
	

}
