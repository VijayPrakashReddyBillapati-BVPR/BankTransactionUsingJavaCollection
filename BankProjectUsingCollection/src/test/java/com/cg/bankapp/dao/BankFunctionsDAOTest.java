package com.cg.bankapp.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.bankapp.model.CustomerDetails;
import com.cg.bankapp.model.TransactionDetails;

class BankDAOTest {

	static BankDAO dao;

	@BeforeAll
	public static void init() {
		dao = new BankDAOImpl();
	}

	@Test
	public void testLogin() {
		CustomerDetails customerDetails = dao.login(71234788, "po");
		assertEquals(-1, customerDetails.getAccountNo());
	}

	@Test
	void testRegistration() {
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setFirstname("vijay");
		customerDetails.setLastname("reddy");
		customerDetails.setAadharCardNo("123412391235");
		customerDetails.setAddress("hyd");
		customerDetails.setBalance(0);
		customerDetails.setEmail("reddybvpr@gmil.com");
		customerDetails.setMobileNo("7512345678");
		customerDetails.setPanNo("1234567890");
		customerDetails.setPassword("vijay438");
		assertEquals(-1, dao.registration(customerDetails));
	}

	@Test
	void testValidation() {
		assertEquals(true, dao.validation("12356788"));
	}

	@Test
	void testWithdraw() {
		assertEquals(-1, dao.withdraw(123456788, 5));
	}

	@Test
	void testDeposit() {
		assertEquals(-1, dao.deposit(123456788, 1000));
	}

	@Test
	void testFundTransfer() {
		TransactionDetails details = new TransactionDetails();
		details.setFromAccountNo(123456789);
		details.setToAccountNo(123456787);
		details.setamountTransfered(-1000);
		assertEquals(1, dao.amountTransfer(details));
	}

}
