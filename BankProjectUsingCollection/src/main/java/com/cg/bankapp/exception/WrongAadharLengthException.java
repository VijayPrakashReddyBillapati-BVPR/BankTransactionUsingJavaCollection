package com.cg.bankapp.exception;

public class WrongAadharLengthException extends Exception{
	public WrongAadharLengthException(){
		System.out.println("Aadhar card number should be only 12 digits.");
	}
}
