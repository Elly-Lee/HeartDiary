package com.heartDiary.elly.model;

import lombok.Data;

@Data
public class ModelResult {
	
	String msg;
	boolean isSuccess; //int result;
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	
	
	

}
