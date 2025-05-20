import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class ExpenseTracker {
    private List<Transaction> transactions;

    public ExpenseTracker() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public void showMonthlySummary(int year, Month month) {
        double totalIncome = 0;
        double totalExpense = 0;
        Map<String, Double> incomeMap = new HashMap<>();
        Map<String, Double> expenseMap = new HashMap<>();

        for (Transaction t : transactions) {
            if (t.getDate().getYear() == year && t.getDate().getMonth() == month) {
                if (t.getType().equalsIgnoreCase("Income")) {
                    incomeMap.put(t.getCategory(),
                        incomeMap.getOrDefault(t.getCategory(), 0.0) + t.getAmount());
                    totalIncome += t.getAmount();
                } else if (t.getType().equalsIgnoreCase("Expense")) {
                    expenseMap.put(t.getCategory(),
                        expenseMap.getOrDefault(t.getCategory(), 0.0) + t.getAmount());
                    totalExpense += t.getAmount();
                }
            }
        }

        System.out.println("Summary for " + month + " " + year + ":");

        System.out.println("Income:");
        for (Map.Entry<String, Double> entry : incomeMap.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nExpense:");
        for (Map.Entry<String, Double> entry : expenseMap.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nTotal Income: " + totalIncome);
        System.out.println("Total Expense: " + totalExpense);
        System.out.println("Net Balance: " + (totalIncome - totalExpense));
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Transaction t : transactions) {
                writer.println(t.toFileFormat());
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        transactions.clear();
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(",");
                if (data.length == 4) {
                    String type = data[0];
                    String category = data[1];
                    double amount = Double.parseDouble(data[2]);
                    LocalDate date = LocalDate.parse(data[3]);
                    transactions.add(new Transaction(type, category, amount, date));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}
