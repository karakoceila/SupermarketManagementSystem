package View;

import java.util.Scanner;

import Model.Database;
import Model.Employee;
import Model.Option;

public class ReadAllReceipts implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		new Controller.ReadAllReceipts(database).print();
	}

	@Override
	public String getOption() {
		return "View All Receipts";
	}

}
