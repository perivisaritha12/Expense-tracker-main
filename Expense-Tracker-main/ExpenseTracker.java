import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {

  private static Scanner scanner = new Scanner(System.in);
  private static ArrayList<Transaction> transactions = new ArrayList<>();

  public static void main(String[] args) {
    while (true) {
      System.out.println("\nExpense Tracker");
      System.out.println("1. Add Expense");
      System.out.println("2. View Transactions");
      System.out.println("3. Total Expenses");
      System.out.println("4. Exit");

      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          addExpense();
          break;
        case 2:
          viewTransactions();
          break;
        case 3:
          totalExpenses();
          break;
        case 4:
          System.out.println("Exiting program...");
          scanner.close();
          return;
        default:
          System.out.println("Invalid choice!");
      }
    }
  }

  private static void addExpense() {
    System.out.println("Enter expense amount: ");
    double amount = scanner.nextDouble();
    scanner.nextLine(); // Consume newline character

    System.out.println("Enter expense description: ");
    String description = scanner.nextLine();

    transactions.add(new Transaction(amount, description));
    System.out.println("Expense added successfully!");
  }

  private static void viewTransactions() {
    if (transactions.isEmpty()) {
      System.out.println("No transactions found!");
      return;
    }

    System.out.println("\nTransactions:");
    for (Transaction transaction : transactions) {
      System.out.println(transaction);
    }
  }

  private static void totalExpenses() {
    double total = 0;
    for (Transaction transaction : transactions) {
      total += transaction.getAmount();
    }

    System.out.println("Total expenses: " + total);
  }
}

class Transaction {
  private double amount;
  private String description;

  public Transaction(double amount, String description) {
    this.amount = amount;
    this.description = description;
  }

  public double getAmount() {
    return amount;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return "Amount: " + amount + ", Description: " + description;
  }
}