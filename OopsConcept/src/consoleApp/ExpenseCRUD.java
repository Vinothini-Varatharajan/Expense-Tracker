package consoleApp;

import java.util.*;

public class ExpenseCRUD {

    List<Expense> expenseList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addExpense() {
        System.out.print("Enter Expense ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Description: ");
        String description = sc.nextLine();

        System.out.print("Enter Amount: ₹");
        double amount = sc.nextDouble();

        expenseList.add(new Expense(id, date, category, description, amount));
        System.out.println("✅ Expense Added!\n");
    }

    public void viewExpenses() {
        if (expenseList.isEmpty()) {
            System.out.println("No Expenses Available!\n");
            return;
        }

        for (int i = 0; i < expenseList.size(); i++) {
            Expense e = expenseList.get(i);
            System.out.println("ID: " + e.id + ", Date: " + e.date + ", Category: " + e.category +
                    ", Description: " + e.description + ", Amount: ₹" + e.amount);
        }
        System.out.println();
    }

    public void updateAmount() {
        System.out.print("Enter Expense ID to Update Amount: ");
        int id = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < expenseList.size(); i++) {
            Expense e = expenseList.get(i);
            if (e.id == id) {
                System.out.print("Enter New Amount: ₹");
                e.amount = sc.nextDouble();
                found = true;
                System.out.println("Amount Updated!\n");
                break;
            }
        }

        if (!found) {
            System.out.println("Expense Not Found!\n");
        }
    }

    public void deleteExpense() {
        System.out.print("Enter Expense ID to Delete: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < expenseList.size(); i++) {
            Expense e = expenseList.get(i);
            if (e.id == id) {
                expenseList.remove(i);
                found = true;
                System.out.println("Expense Deleted!\n");
                break;
            }
        }

        if (!found) {
            System.out.println("Expense Not Found!\n");
        }
    }

    public void searchExpense() {
        System.out.println("Search by:");
        System.out.println("1. Date");
        System.out.println("2. Category");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        if (choice == 1) {
            System.out.print("Enter Date (YYYY-MM-DD): ");
            String searchDate = sc.nextLine();

            for (int i = 0; i < expenseList.size(); i++) {
                Expense e = expenseList.get(i);
                if (e.date.equals(searchDate)) {
                    printExpense(e);
                    found = true;
                }
            }
        } else if (choice == 2) {
            System.out.print("Enter Category: ");
            String searchCat = sc.nextLine().toLowerCase();

            for (int i = 0; i < expenseList.size(); i++) {
                Expense e = expenseList.get(i);
                if (e.category.toLowerCase().contains(searchCat)) {
                    printExpense(e);
                    found = true;
                }
            }
        } else {
            System.out.println("Invalid choice!");
        }

        if (!found) {
            System.out.println("No matching expenses found.\n");
        } else {
            System.out.println();
        }
    }

    private void printExpense(Expense e) {
        System.out.println("ID: " + e.id + ", Date: " + e.date + ", Category: " + e.category +
                ", Description: " + e.description + ", Amount: ₹" + e.amount);
    }

    public void viewTodayTotal() {
        String today = java.time.LocalDate.now().toString();
        double total = 0;

        for (int i = 0; i < expenseList.size(); i++) {
            Expense e = expenseList.get(i);
            if (e.date.equals(today)) {
                total += e.amount;
            }
        }

        System.out.printf("Total spent today (%s): ₹%.2f\n\n", today, total);
    }

    public void viewMonthlyTotal() {
        System.out.print("Enter Year (YYYY): ");
        String year = sc.nextLine();
        System.out.print("Enter Month (MM): ");
        String month = sc.nextLine();

        if (month.length() == 1) {
            month = "0" + month;
        }
        String prefix = year + "-" + month;

        double total = 0;
        boolean found = false;

        for (int i = 0; i < expenseList.size(); i++) {
            Expense e = expenseList.get(i);
            if (e.date.startsWith(prefix)) {
                total += e.amount;
                found = true;
            }
        }

        if (found) {
            System.out.printf("Total Expense for %s: ₹%.2f\n\n", prefix, total);
        } else {
            System.out.println("No Expenses Found for this Month.\n");
        }
    }
}
