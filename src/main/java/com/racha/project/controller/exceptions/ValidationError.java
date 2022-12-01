package com.racha.project.controller.exceptions;

import java.util.ArrayList;
import java.util.List;


public class ValidationError extends StandardError{
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> erros = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}
	
	public void addError(String field, String name) {
		erros.add(new FieldMessage(field,name));
	}

	public List<FieldMessage> getErros() {
		return erros;
	}

}
