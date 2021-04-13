package com.greedy.member.model.dto;

public class DataDTO {
	
	private int code;
	private String id;
	private String pwd;
	private String name;
	private String confirm;
	private String exCode;
	private String exName;
	private int count;
	private int counting;
	private String exerciseName;
	private String exerciseCount;
	private String nickName;
	private int exp;
	
	public DataDTO() {
		super();
	}

	public DataDTO(int code, String id, String pwd, String name, String confirm, String exCode, String exName,
			int count, int counting, String exerciseName, String exerciseCount, String nickName, int exp) {
		super();
		this.code = code;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.confirm = confirm;
		this.exCode = exCode;
		this.exName = exName;
		this.count = count;
		this.counting = counting;
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

	public String getExName() {
		return exName;
	}

	public void setExName(String exName) {
		this.exName = exName;
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
				+ ", exCode=" + exCode + ", exName=" + exName + ", count=" + count + ", counting=" + counting
				+ ", exerciseName=" + exerciseName + ", exerciseCount=" + exerciseCount + ", nickName=" + nickName
				+ ", exp=" + exp + "]";
	}

	
	
	
	

}
