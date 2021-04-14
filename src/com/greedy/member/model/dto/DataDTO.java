package com.greedy.member.model.dto;

public class DataDTO {
	
	private int code;
	private String id;
	private String pwd;
	private String name;
	private String confirm;
	private String exCode;
	private int count;
	private int counting;
	private int no1;
	private int no2;
	private int no3;
	private String exName;
	private String excode1;
	private String excode2;
	private String excode3;
	
	
	private String exerciseName;
	private String exerciseCount;
	private String nickName;
	private int exp;
	
	public DataDTO() {
		super();
	}

	public DataDTO(int code, String id, String pwd, String name, String confirm, String exCode, int count, int counting,
			int no1, int no2, int no3, String exName, String excode1, String excode2, String excode3,
			String exerciseName, String exerciseCount, String nickName, int exp) {
		super();
		this.code = code;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.confirm = confirm;
		this.exCode = exCode;
		this.count = count;
		this.counting = counting;
		this.no1 = no1;
		this.no2 = no2;
		this.no3 = no3;
		this.exName = exName;
		this.excode1 = excode1;
		this.excode2 = excode2;
		this.excode3 = excode3;
		this.exerciseName = exerciseName;
		this.exerciseCount = exerciseCount;
		this.nickName = nickName;
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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getExCode() {
		return exCode;
	}

	public void setExCode(String exCode) {
		this.exCode = exCode;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCounting() {
		return counting;
	}

	public void setCounting(int counting) {
		this.counting = counting;
	}

	public int getNo1() {
		return no1;
	}

	public void setNo1(int no1) {
		this.no1 = no1;
	}

	public int getNo2() {
		return no2;
	}

	public void setNo2(int no2) {
		this.no2 = no2;
	}

	public int getNo3() {
		return no3;
	}

	public void setNo3(int no3) {
		this.no3 = no3;
	}

	public String getExName() {
		return exName;
	}

	public void setExName(String exName) {
		this.exName = exName;
	}

	public String getExcode1() {
		return excode1;
	}

	public void setExcode1(String excode1) {
		this.excode1 = excode1;
	}

	public String getExcode2() {
		return excode2;
	}

	public void setExcode2(String excode2) {
		this.excode2 = excode2;
	}

	public String getExcode3() {
		return excode3;
	}

	public void setExcode3(String excode3) {
		this.excode3 = excode3;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getExerciseCount() {
		return exerciseCount;
	}

	public void setExerciseCount(String exerciseCount) {
		this.exerciseCount = exerciseCount;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "DataDTO [code=" + code + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", confirm=" + confirm
				+ ", exCode=" + exCode + ", count=" + count + ", counting=" + counting + ", no1=" + no1 + ", no2=" + no2
				+ ", no3=" + no3 + ", exName=" + exName + ", excode1=" + excode1 + ", excode2=" + excode2 + ", excode3="
				+ excode3 + ", exerciseName=" + exerciseName + ", exerciseCount=" + exerciseCount + ", nickName="
				+ nickName + ", exp=" + exp + "]";
	}


	
	
	

}
