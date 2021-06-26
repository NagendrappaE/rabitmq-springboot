/**
 * 
 */
package com.ece.rabitmq.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author user
 *
 */
public class AccountRequest {

	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("BranchName")
	private String branchName;
	
	@JsonProperty("AccountNumber")
	private int accountNumber;
	
	@JsonProperty("Amount")
	private String amount;
	
	@JsonProperty("IFSC")
	private String ifsc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	
	
}
