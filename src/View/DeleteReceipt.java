package View;

import java.util.Scanner;

import Controller.ReadAllReceipts;
import Model.Database;
import Model.Employee;
import Model.Option;

public class DeleteReceipt implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		System.out.println("Enter receipt ID (-1 to show all receipts):");
		int ID = s.nextInt();
		while (ID<0) {
			new ReadAllReceipts(database).print();
			System.out.println("Enter receipt ID (-1 to show all receipts):");
			ID = s.nextInt();
		}
		
		new Controller.DeleteReceipt(ID, database);
	}

	@Override
	public String getOption() {
		return "Remove Receipt";
	}

}
