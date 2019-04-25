package com.cg.bankapp.dao;

import com.cg.bankapp.model.CustomerDetails;
import com.cg.bankapp.model.TransactionDetails;

public interface BankDAO {
	public long registration(CustomerDetails customerDetails);
	public boolean validation(String aadharNo);
	public CustomerDetails login(long accountNo,String password);
	public long withdraw(long accountNo,long amount);
	public long deposit(long accountNo,long amount);
	public long amountTransfer(TransactionDetails transactionDetails);
	
}
