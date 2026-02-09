package com.Atm_Project;

import java.util.Scanner;

public class AtmProject {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int correctPin = 1234;
		int enteredPin;
		int attempts = 0;
		int balance = 10000;
		int choice, amount;

		// -------- PIN Validation (WHILE LOOP) --------
		System.out.print("Enter your PIN: ");
		enteredPin = sc.nextInt();

		while (enteredPin != correctPin && attempts < 2) {
			System.out.println("Wrong PIN. Try again.");
			System.out.print("Enter your PIN: ");
			enteredPin = sc.nextInt();
			attempts++;
		}

		if (enteredPin == correctPin) {
			System.out.println("PIN verified successfully.\n");

			// -------- ATM MENU (DO-WHILE LOOP) --------
			do {
				System.out.println("----- ATM MENU -----");
				System.out.println("1. Check Balance");
				System.out.println("2. Deposit Money");
				System.out.println("3. Withdraw Money");
				System.out.println("4. Exit");
				System.out.print("Choose an option: ");
				choice = sc.nextInt();

				switch (choice) {

				case 1:
					System.out.println("Current Balance: " + balance);
					break;

				case 2:
					System.out.print("Enter deposit amount: ");
					amount = sc.nextInt();
					balance += amount;
					System.out.println("Amount deposited successfully.");
					break;

				case 3:
					System.out.print("Enter withdrawal amount: ");
					amount = sc.nextInt();

					if (amount <= balance) {
						balance -= amount;
						System.out.println("Please collect your cash.");
					} else {
						System.out.println("Insufficient balance.");
					}
					break;

				case 4:
					System.out.println("Thank you for using ATM.");
					break;

				default:
					System.out.println("Invalid option. Try again.");
				}

				System.out.println();

			} while (choice != 4);

		} else {
			System.out.println("Card blocked due to 3 wrong PIN attempts.");
		}

		sc.close();
	}
}
