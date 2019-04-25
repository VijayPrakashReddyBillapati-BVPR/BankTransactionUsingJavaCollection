package com.cg.bankapp.exception;

public class CannotWithdrawException extends Exception{
	public CannotWithdrawException() {
		System.out.println("Cannot withdraw. Low on balance");
	}
}
