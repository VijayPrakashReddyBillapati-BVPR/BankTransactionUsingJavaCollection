package com.cg.bankapp.service;

import com.cg.bankapp.model.CustomerDetails;
import com.cg.bankapp.model.TransactionDetails;

public interface BankService {
		long registration(CustomerDetails customerDetails);
		boolean validation(String string);
		public CustomerDetails login(long accountNo,String password);
		public long withdraw(long accountNo,long amount);
		public long deposit(long accountNo,long amount);
		public long amountTransfer(TransactionDetails transactionDetails);
		
}
