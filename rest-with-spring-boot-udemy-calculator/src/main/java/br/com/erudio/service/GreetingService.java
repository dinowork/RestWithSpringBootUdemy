package br.com.erudio.service;

import org.springframework.stereotype.Component;

import br.com.erudio.converter.NumberConverter;
import br.com.erudio.exception.UnsuportedMathOperationException;

@Component
public class GreetingService {

	private final static String ERRO_NUMERIC_INVALID = "Please set a numeric value";	
	private final static String ERRO_DIVISION_ZERO = "Please set a numeric value";	
	
	public Double sum(String numberOne, String numberTwo) throws UnsuportedMathOperationException {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException(ERRO_NUMERIC_INVALID);
		}			 
		return NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
	}

	public Double subtraction(String numberOne, String numberTwo) throws UnsuportedMathOperationException {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException(ERRO_NUMERIC_INVALID);
		}		
		return NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo);
	}

	public Double multiplication(String numberOne, String numberTwo) throws UnsuportedMathOperationException {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException(ERRO_NUMERIC_INVALID);
		}				
		return NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo);
	}

	public Double division(String numberOne, String numberTwo) throws UnsuportedMathOperationException, Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException(ERRO_NUMERIC_INVALID);
		}else if(NumberConverter.convertToDouble(numberTwo) == 0) {
			throw new Exception(ERRO_DIVISION_ZERO);
		}				
		return NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo);
	}

	public Double power(String numberOne, String numberTwo) throws UnsuportedMathOperationException {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException(ERRO_NUMERIC_INVALID);
		}				
		return Math.pow(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));	
	}

	public Double media(String numberOne, String numberTwo) throws UnsuportedMathOperationException {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException(ERRO_NUMERIC_INVALID);
		}				
		return (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo)) / 2;	
	}

	public Double rootSquare(String number) throws UnsuportedMathOperationException {
		if(!NumberConverter.isNumeric(number)) {
			throw new UnsuportedMathOperationException(ERRO_NUMERIC_INVALID);
		}				
		return Math.sqrt(NumberConverter.convertToDouble(number));	
	}

	
	
	
	
}
