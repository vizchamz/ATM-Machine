import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMMachine {
    public static void main(String[] args) {
        int actualCardNo = 123456789;
        int cardNo;
        int option1;
        int value;
        int balance = 100000;
        int balanceCanWithdraw;
        String confirm;

        System.out.println("*** Welcome to ABC Bank ATM ***\n");

        while (true) {
            Scanner input = new Scanner(System.in);
            try {
                System.out.print("Enter your Card Number: ");
                cardNo = input.nextInt();

                if (cardNo == actualCardNo) {
                    while (true) {
                        System.out.println("================================================\n");
                        System.out.println("*** Main Menu ***");
                        System.out.println("Enter 1 to view the Balance:");
                        System.out.println("Enter 2 to Withdraw Money:");
                        System.out.println("Enter 3 to Deposit Money:");
                        System.out.println("Enter 0 to Exit:\n");
                        System.out.println("================================================");
                        option1 = input.nextInt();

                        if (option1 == 1) {
                            System.out.println("Balance: " + balance + " lkr ");
                            if (balance > 200000) {
                                balanceCanWithdraw = 200000;
                            }
                            else {
                                balanceCanWithdraw = balance - 2000;
                            }
                            System.out.println("Withdrawal Balance: " + balanceCanWithdraw + " lkr ");
                        } else if (option1 == 2) {
                            if (balance > 200000) {
                                balanceCanWithdraw = 200000;

                                System.out.print("Enter value: ");
                                value = input.nextInt();

                                if (value <= balanceCanWithdraw) {
                                    System.out.print("Confirm (Y/N)? ");
                                    confirm = input.next();

                                    if (confirm.equalsIgnoreCase("Y")) {
                                        System.out.println("Withdrawal Successful");
                                        balance -= value;
                                        System.out.println("Balance: " + balance + " lkr ");
                                        System.exit(0);
                                    } else {
                                        break;
                                    }
                                    break;
                                } else {
                                    System.out.println("You can Withdraw upto " + balanceCanWithdraw + " lkr ");
                                }
                            }
                            else {
                                balanceCanWithdraw = balance - 2000;

                                System.out.print("Enter value: ");
                                value = input.nextInt();

                                if (value <= balanceCanWithdraw) {
                                    System.out.print("Confirm (Y/N)? ");
                                    confirm = input.next();

                                    if (confirm.equalsIgnoreCase("Y")) {
                                        System.out.println("Withdrawal Successful");
                                        balance -= value;
                                        System.out.println("Balance: " + balance + " lkr ");
                                        System.exit(0);
                                    } else {
                                        break;
                                    }
                                    break;
                                } else {
                                    System.out.println("Insufficient Balance");
                                    System.out.println("You can Withdraw upto " + balanceCanWithdraw + " lkr ");
                                }
                            }

                        } else if (option1 == 3) {
                            System.out.print("Enter value: ");
                            value = input.nextInt();

                            System.out.print("Confirm (Y/N)? ");
                            confirm = input.next();

                            if (confirm.equalsIgnoreCase("Y")) {
                                System.out.println("Deposit Successful");
                                balance += value;
                                System.out.println("Balance: " + balance + " lkr ");
                                System.exit(0);
                            } else {
                                break;
                            }
                        } else if (option1 == 0) {
                            System.exit(0);
                        }
                    }
                } else {
                    System.out.println("Card Number Invalid!");
                    System.out.println("Try Again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please Enter Valid Characters!");
                System.out.println("Try Again");
            }
        }
    }
}
