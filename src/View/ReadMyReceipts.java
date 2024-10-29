package View;

import java.util.Scanner;

import Controller.ReadEmployeeReceipts;
import Model.Database;
import Model.Employee;
import Model.Option;

public class ReadMyReceipts implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		new ReadEmployeeReceipts(user.getID(), database).print();
	}

	@Override
	public String getOption() {
		return "View My Receipts";
	}

}
