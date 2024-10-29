package View;

import java.util.Scanner;

import Model.Database;
import Model.Employee;
import Model.Option;
import Model.Section;

public class CreateSection implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		System.out.println("Enter section name:");
		String name = s.next();
		System.out.println("Enter description:");
		String description = s.next();
		Section section = new Section();
		section.setName(name);
		section.setDescription(description);
		new Controller.CreateSection(section, database);
	}

	@Override
	public String getOption() {
		return "Add New Section";
	}

}
