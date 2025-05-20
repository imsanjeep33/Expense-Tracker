# Expense Tracker

## Overview
Expense Tracker is a Java console application designed to help users manage their personal finances by tracking income and expenses. It supports categorizing transactions, recording transaction dates, viewing monthly summaries, and saving/loading data from files for persistent storage.

## Features
- Add income and expense transactions with date, category, and amount.
- Categorize transactions (e.g., Salary, Business, Food, Rent, Travel).
- View monthly summaries showing total income, expenses, and net balance by category.
- Save transactions to a file and load them on program start.
- Simple and user-friendly console interface with input validation.

## How It Works (Step-by-Step)

1. **Start the Program**  
   When the program runs, it asks if you want to load existing transactions from a file.

2. **Main Menu**  
   You see options to:
   - Add Income
   - Add Expense
   - Show Monthly Summary
   - Save to File
   - Exit

3. **Add Income or Expense**  
   When you choose to add a transaction:
   - Enter the **date** in `yyyy-mm-dd` format. The program checks for a valid date.
   - Enter the **category** (e.g., Salary for income, Food for expenses).
   - Enter the **amount** (decimal number).
   The transaction is then saved in the program's memory.

4. **View Monthly Summary**  
   You enter the year and month, and the program shows:
   - Income and expenses broken down by category.
   - Total income and total expenses.
   - Net balance (income minus expenses) for the selected month.

5. **Save Transactions**  
   Saves all entered transactions to a file in CSV format (`Type,Category,Amount,Date`).
   A confirmation message is printed once after saving.

6. **Load Transactions**  
   At startup, if you choose to load, the program reads transactions from the file and restores them.

## File Format
Transactions are saved as:






Example:

Type,Category,Amount,Date

Income,Salary,5000.00,2025-05-01
Expense,Food,150.75,2025-05-02


## How to Run

1. Ensure you have Java installed (JDK 8 or higher).
2. Compile the code:
javac Main.java ExpenseTracker.java Transaction.java

3. Run the program:
java Main
4. Follow the on-screen instructions to use the tracker.
