package com.cg.bankapp.model;

public class TransactionDetails {
	private long transactionId;
	private long fromAccountNo;
	private long toAccountNo;
	private long amountTransfered;
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public long getFromAccountNo() {
		return fromAccountNo;
	}
	public void setFromAccountNo(long fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}
	public long getToAccountNo() {
		return toAccountNo;
	}
	public void setToAccountNo(long toAccountNo) {
		this.toAccountNo = toAccountNo;
	}
	public long getamountTransfered() {
		return amountTransfered;
	}
	public void setamountTransfered(long amountTransfered) {
		this.amountTransfered = amountTransfered;
	}
}
