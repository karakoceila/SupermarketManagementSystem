package View;

import java.util.Scanner;

import Controller.ReadAllEmployees;
import Controller.ReadEmployeeReceipts;
import Model.Database;
import Model.Employee;
import Model.Option;

public class ReadCashierReceipts implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		System.out.println("Enter Employee's ID (-1 to show all employees):");
		int ID = s.nextInt();
		while (ID<0) {
			new ReadAllEmployees(database).print();
			System.out.println("Enter Employee's ID (-1 to show all employees):");
			ID = s.nextInt();
		}
		new ReadEmployeeReceipts(ID, database).print();
	}

	@Override
	public String getOption() {
		return "View All Cashier's Receipt";
	}

}
