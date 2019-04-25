package com.cg.bankapp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.cg.bankapp.dao.BankDAO;
import com.cg.bankapp.dao.BankDAOImpl;
import com.cg.bankapp.driver.Main;
import com.cg.bankapp.exception.CannotWithdrawException;
import com.cg.bankapp.exception.CustomerAleadyExistException;
import com.cg.bankapp.model.CustomerDetails;
import com.cg.bankapp.model.TransactionDetails;

public class BankServiceImpl implements BankService {
	BankDAO dao= new BankDAOImpl();
	public long registration(CustomerDetails customerDetails) {
		return dao.registration(customerDetails);
	}

	public CustomerDetails login(long accountNo, String password) {
		return dao.login(accountNo, password);
	}
	public boolean validation(String aadharNo) {
		boolean check = false;
		if(aadharNo.length()==12) {
			if(dao.validation(aadharNo)) {
				check=true;
			}else {
				try {
					throw new CustomerAleadyExistException();
				} catch (CustomerAleadyExistException e) {
				}
			}
		}else {
			check=false;
		}
		return check;

	}
	
	public boolean validateNumber(String mobile) {
		if(mobile.length()==10) {
			return true;
		}
		else {
			return false;
		}
	}
	public long withdraw(long accountNo, long amount) {
		long balance=dao.withdraw(accountNo, amount);
		if(balance<0){
			try {
				throw new CannotWithdrawException();
			} catch (CannotWithdrawException e) {
			}
		}
		return balance;
	}

	public long deposit(long accountNo, long amount) {
		// TODO Auto-generated method stub
		return dao.deposit(accountNo, amount);
	}

	public long amountTransfer(TransactionDetails transactionDetails) {
		// TODO Auto-generated method stub
		return dao.amountTransfer(transactionDetails);
	}

}
