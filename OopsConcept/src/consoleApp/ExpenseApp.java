package consoleApp;

import java.util.Scanner;

public class ExpenseApp {
    public static void main(String[] args) {
        ExpenseCRUD CRUD = new ExpenseCRUD();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("====== DAILY EXPENSE TRACKER ======");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Update Expense Amount");
            System.out.println("4. Delete Expense");
            System.out.println("5. Search Expense");
            System.out.println("6. View Total Spent Today");
            System.out.println("7. View Monthly Total");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    CRUD.addExpense();
                    break;
                case 2:
                    CRUD.viewExpenses();
                    break;
                case 3:
                    CRUD.updateAmount();
                    break;
                case 4:
                    CRUD.deleteExpense();
                    break;
                case 5:
                    CRUD.searchExpense();
                    break;
                case 6:
                    CRUD.viewTodayTotal();
                    break;
                case 7:
                    CRUD.viewMonthlyTotal();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice!\n");
            }
        }
    }
}
