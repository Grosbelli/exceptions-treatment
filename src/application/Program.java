package application;

import models.entities.Account;
import models.exceptions.DomainException;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            Account ac;

            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Holder: ");
            String holder = sc.nextLine();
            System.out.print("Initial Balance: ");
            double balance = sc.nextDouble();
            sc.nextLine();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();
            sc.nextLine();

            ac = new Account(number, holder, balance, withdrawLimit);

            System.out.print("\nEnter amount for withdraw: ");
            double amount = sc.nextDouble();
            ac.withdraw(amount);

            System.out.println(ac);

            sc.close();
        } catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("You typed an invalid character");
        } catch (RuntimeException e) {
            System.out.println("Unexpected Error");
        }
    }
}
