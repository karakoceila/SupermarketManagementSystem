package View;

import java.util.Scanner;

import Model.Database;
import Model.Employee;
import Model.Option;

public class ChangePassword implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		System.out.println("Enter old password:");
		String oldPass = s.next();
		
		if (!oldPass.equals(user.getPassword())) {
			System.out.println("Incorrect password\nTry again later");
			return;
		}
		
		System.out.println("Enter new password:");
		String newPass = s.next();
		System.out.println("Confirm password:");
		String confirmPass = s.next();
		
		if (!newPass.equals(confirmPass)) {
			System.out.println("Password doesn't match\nTry again later");
			return;
		}
		
		new Controller.ChangePassword(confirmPass, user, database);
	}

	@Override
	public String getOption() {
		return "Change Password";
	}

}
