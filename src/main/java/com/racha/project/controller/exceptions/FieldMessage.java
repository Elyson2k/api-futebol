package com.racha.project.controller.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String campo;
	private String msg;
	
	public FieldMessage() {}

	public FieldMessage(String fieldName, String msg) {
		super();
		this.campo = fieldName;
		this.msg = msg;
	}

	public String getCampo() {
		return campo;
	}

	public String getMsg() {
		return msg;
	}

	public void setFieldName(String fieldName) {
		this.campo = fieldName;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	};
	
	

}
