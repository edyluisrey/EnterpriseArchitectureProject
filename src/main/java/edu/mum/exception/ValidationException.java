package edu.mum.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.validation.Errors;
import java.lang.RuntimeException;

public class ValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Errors errors;
	
    //Parameterless Constructor
    public ValidationException() {}

    //Constructor that accepts a message
    public ValidationException(Errors errors)
    {
       this.errors = errors;      
    }

	public Errors getErrors() {
		return errors;
	}

}
