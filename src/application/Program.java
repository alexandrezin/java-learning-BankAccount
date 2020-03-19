package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter Account Data:");
			//Account Number
			System.out.print("Number: ");
			short acoountNumber = sc.nextShort();
			sc.nextLine();
			
			//Holder Name
			System.out.print("Holder: ");
			String acoountHolderName = sc.nextLine();
			
			//Initial Balance
			System.out.print("Initial Balance: ");
			Double acoountInitialBalance = sc.nextDouble();
			
			//Withdraw Limit
			System.out.print("Withdraw Limit: ");
			Double acoountWithdrawLimit = sc.nextDouble();
			sc.nextLine();
			
			Account account = new Account(acoountNumber, acoountHolderName, acoountInitialBalance, acoountWithdrawLimit);
			
			//Menu
			char optionMenu = 'D';
			while (optionMenu == 'D' || optionMenu == 'W') {
				System.out.print("Tap [D]eposit [W]ithdraw [E]xit: ");
				optionMenu = sc.nextLine().charAt(0);
				
				if(optionMenu == 'D') {
					System.out.print("Ammount to deposit: ");
					account.deposit(sc.nextDouble());
					sc.nextLine();
					System.out.printf("New balance: %.2f\n", account.getBalance());
				}
				
				if(optionMenu == 'W') {
					System.out.print("Ammount to withdraw: ");
					account.withdraw(sc.nextDouble());
					sc.nextLine();
					System.out.printf("New balance: %.2f\n", account.getBalance());
				}
			}
			
			
			sc.close();
		}
		catch(DomainExceptions exception) {
			System.out.println("Error: " + exception.getMessage());
		}
		catch(InputMismatchException exception) {
			System.out.println("The written parameter is not corret!");
		}
	}

}
