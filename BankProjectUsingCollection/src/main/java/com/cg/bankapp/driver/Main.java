package com.cg.bankapp.driver;

import java.util.Scanner;

import javax.imageio.spi.RegisterableService;

import com.cg.bankapp.exception.WrongAadharLengthException;
import com.cg.bankapp.exception.WrongLoginCredentialsException;
import com.cg.bankapp.exception.WrongMobileNumberException;
import com.cg.bankapp.model.CustomerDetails;
import com.cg.bankapp.model.TransactionDetails;
import com.cg.bankapp.service.BankService;
import com.cg.bankapp.service.BankServiceImpl;

public class Main{
	public static void main(String[] args) {

		
		long balance;
		Scanner sc = new Scanner(System.in);
		BankServiceImpl bankServiceImpl=new BankServiceImpl();
		BankService service=new BankServiceImpl();
		TransactionDetails transactionDetails=new TransactionDetails();
		int i;
		do {
		// Showing the menu here
		System.out.println("Enter your choice");
		System.out.println("1. Registration");
		System.out.println("2. Login");
		int ch = sc.nextInt();
            switch(ch)
            {
            case 1 :
            	CustomerDetails customerDetails=new CustomerDetails();
            	// Scanning the customer details for registartion
            	System.out.println("Enter firstname");
            	customerDetails.setFirstname(sc.next());
    			System.out.println("Enter lastname");
    			customerDetails.setLastname(sc.next());
    			System.out.println("Enter Email");
    			customerDetails.setEmail(sc.next());
    			System.out.println("Enter password");
    			customerDetails.setPassword(sc.next());
    			System.out.println("Enter pan no");
    			customerDetails.setPanNo(sc.next());
    			System.out.println("Enter aadhar");
    			customerDetails.setAadharCardNo(sc.next());
    			if(service.validation(customerDetails.getAadharCardNo())) {
    				System.out.println("Enter address");
    				customerDetails.setAddress(sc.next());
	    			System.out.println("Enter mobile number");
	    			String mobileNo=sc.next();
	    			if(bankServiceImpl.validateNumber(mobileNo)) {
	    				customerDetails.setMobileNo(mobileNo);
		    			customerDetails.setBalance(0);
		    			System.out.println("Account number is "+service.registration(customerDetails));
	    			}else {
	    				try {
							throw new WrongMobileNumberException();
						} catch (WrongMobileNumberException e) {
						}
	    			}    			
	    		}else {
    				try {
						throw new WrongAadharLengthException();
					} catch (WrongAadharLengthException e) {
					}
    			}
            	break;
            case 2:
            	CustomerDetails customerDetails2=new CustomerDetails();
            	System.out.println("Enter account number");
            	customerDetails2.setAccountNo(sc.nextLong());
            	System.out.println("Enter password");
            	customerDetails2.setPassword(sc.next());
            	customerDetails2=service.login(customerDetails2.getAccountNo(), customerDetails2.getPassword());
            	menu: while(true) {
            	if(customerDetails2.getAccountNo()>0) {
            		System.out.println("Welcome "+customerDetails2.getFirstname());
            		System.out.println("Enter your choice");
            		System.out.println("1. Deposit");
            		System.out.println("2. Withdraw");
            		System.out.println("3. Show balance");
            		System.out.println("4. Fund transfer");
            		System.out.println("5. Exit");
            		ch = sc.nextInt();
                        switch(ch)
                        {
                        case 1 :
                        	System.out.println("Enter amount for deposit");
                        	balance=service.deposit(customerDetails2.getAccountNo(), sc.nextLong());
                        	System.out.println("Available balance: "+balance);
                        	break;
                        case 2:
                        	System.out.println("Enter amount for withdrawal");
                        	balance=service.withdraw(customerDetails2.getAccountNo(), sc.nextLong());
                        	System.out.println("Available balance: "+balance);
                        	break;
                        case 3:
                        	System.out.println("Balance is "+customerDetails2.getBalance());
                        	break;
                        case 4:
                        	System.out.println("Enter account number to transfer");
                        	transactionDetails.setToAccountNo(sc.nextLong());
                        	System.out.println("Enter amount to tranfer");
                        	transactionDetails.setamountTransfered(sc.nextLong());
                        	transactionDetails.setFromAccountNo(customerDetails2.getAccountNo());
                        	long trans_id=service.amountTransfer(transactionDetails);
                        	if(trans_id>0) {
                        	System.out.println("Amount of Rs."+transactionDetails.getamountTransfered()+" tranfered from account number "+transactionDetails.getFromAccountNo()+" to account number "+transactionDetails.getToAccountNo());
                        	System.out.println("Transaction id:"+trans_id);
                        	}
                        	break;
                        case 5:
                        	System.out.println("Thank you!");
                        	break menu;
                        default:
                        	System.out.println("Enter valid input");
                        	break;
                        		
                        	
                        }
            	}
            	else {
            		try {
						throw new WrongLoginCredentialsException();
					} catch (WrongLoginCredentialsException e) {
					}
            	}
            	
            	
            	}
            	break;
            default:
            	System.out.println("Enter valid input.");
            	break;
            }
            System.out.println("Enter 1 to continue or press any other number to exit.");
             i = sc.nextInt();
		} while(i==1);
		System.out.println("Thank you");
	}
}