package br.com.erudio.exception;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionResponse implements Serializable {
	
	private static final long serialVersionUID = -5911502042881961862L;
	
	private Date timestamp;
	private String message;
	private String  details;
	
}
