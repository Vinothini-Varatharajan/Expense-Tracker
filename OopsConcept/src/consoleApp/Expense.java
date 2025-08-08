package consoleApp;

public class Expense {

    int id;
    String date;
    String category;
    String description;
    double amount;

    Expense(int id, String date, String category, String description, double amount) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.description = description;
        this.amount = amount;
    }

	public double getAmount() {
		
		return 0;
	}

	public Object getDate() {
		
		return null;
	}
}
