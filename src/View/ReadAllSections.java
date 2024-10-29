package View;

import java.util.Scanner;

import Model.Database;
import Model.Employee;
import Model.Option;

public class ReadAllSections implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		new Controller.ReadAllSections(database).print();
	}

	@Override
	public String getOption() {
		return "View All Sections";
	}

}
