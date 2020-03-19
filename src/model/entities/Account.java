package model.entities;

import model.exceptions.DomainExceptions;

public class Account {
	private short number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account(short number, String holder, Double balance, Double withdrawLimit) throws DomainExceptions{
		if (number > 9999) {
			throw new DomainExceptions("Invalid Account Number");
		}
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public short getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(Double ammount) throws DomainExceptions{
		if (ammount <= 0.0) {
			throw new DomainExceptions("The ammount to deposit has to be greater than ZERO");
		}
		this.balance += ammount;
	}
	
	public void withdraw(Double ammount) throws DomainExceptions{
		if (ammount <= 0.0) {
			throw new DomainExceptions("The ammount to withdraw has to be greater than ZERO");
		}
		if (ammount > this.balance) {
			throw new DomainExceptions("The ammount to withdraw has to be less than " + this.balance);
		}
		if (ammount > this.withdrawLimit) {
			throw new DomainExceptions("Your limit to this operation is " + this.withdrawLimit);
		}
		this.balance -= ammount;
	}
	
	
}
