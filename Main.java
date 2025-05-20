import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Load transactions from file? (y/n): ");
            String loadOption = sc.nextLine();
            if (loadOption.equalsIgnoreCase("y")) {
                System.out.print("Enter filename: ");
                String filename = sc.nextLine();
                tracker.loadFromFile(filename);
            }

            boolean exit = false;
            while (!exit) {
                System.out.println("\n1. Add Income");
                System.out.println("2. Add Expense");
                System.out.println("3. Show Monthly Summary");
                System.out.println("4. Save to File");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int option = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (option) {
                    case 1:
                        // Add Income
                        try {
                            System.out.print("Enter date (yyyy-mm-dd): ");
                            String dateInput = sc.nextLine();
                            LocalDate incomeDate = LocalDate.parse(dateInput);

                            System.out.print("Enter income category (e.g. Salary, Business): ");
                            String incomeCategory = sc.nextLine();

                            System.out.print("Enter amount: ");
                            double incomeAmount = sc.nextDouble();
                            sc.nextLine(); // clear buffer

                            tracker.addTransaction(new Transaction("Income", incomeCategory, incomeAmount, incomeDate));
                            System.out.println("------Income added-----------");
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format.");
                        }
                        break;

                    case 2:
                        // Add Expense
                        try {
                            System.out.print("Enter date (yyyy-mm-dd): ");
                            String dateInput = sc.nextLine();
                            LocalDate expenseDate = LocalDate.parse(dateInput);

                            System.out.print("Enter expense category (e.g. Food, Rent, Travel): ");
                            String expenseCategory = sc.nextLine();

                            System.out.print("Enter amount: ");
                            double expenseAmount = sc.nextDouble();
                            sc.nextLine(); // clear buffer

                            tracker.addTransaction(new Transaction("Expense", expenseCategory, expenseAmount, expenseDate));
                            System.out.println("------------Expense added---------------");
                        } catch (DateTimeParseException e) {
                            System.out.println("---Invalid date format--Go Away");
                        }
                        break;

                    case 3:
                        // Show Monthly Summary
                        try {
                            System.out.print("Enter year (e.g., 2025): ");
                            int year = sc.nextInt();

                            System.out.print("Enter month number (e.g., 5 for May): ");
                            int month = sc.nextInt();
                            sc.nextLine(); // clear buffer

                            tracker.showMonthlySummary(year, Month.of(month));
                        } catch (Exception e) {
                            System.out.println("Invalid input for year or month.");
                        }
                        break;

                    case 4:
                        // Save to file
                        System.out.print("Enter filename to save to: ");
                        String saveFile = sc.nextLine();
                        tracker.saveToFile(saveFile);
                        System.out.println("-----------Transactions saved---------");
                        break;

                    case 5:
                        exit = true;
                        System.out.println("--------My Work done .. So BYe bye program-------");
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
