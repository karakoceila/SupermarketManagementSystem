package Model;

import View.ChangePassword;
import View.CreateEmployee;
import View.CreateProduct;
import View.CreateReceipt;
import View.CreateSection;
import View.DeleteEmployee;
import View.DeleteProduct;
import View.DeleteReceipt;
import View.DeleteSection;
import View.ReadAllEmployees;
import View.ReadAllProducts;
import View.ReadAllReceipts;
import View.ReadAllSections;
import View.ReadCashierReceipts;
import View.ReadMyReceipts;
import View.ReadReceipt;
import View.ReadSectionProducts;
import View.UpdateEmployee;
import View.UpdateProduct;
import View.UpdateSection;

public class Admin extends Employee {
	
	public Admin() {
		generateList();
	}
	
	public Admin(int ID, String firstName, String lastName, String email,
			String phoneNumber, String address, double salary, String password) {
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.salary = salary;
		this.password = password;
		generateList();
	}
	
	private void generateList() {
		this.options = new Option[] {
				new CreateEmployee(),
				new ReadAllEmployees(),
				new UpdateEmployee(),
				new DeleteEmployee(),
				new CreateSection(),
				new ReadAllSections(),
				new UpdateSection(),
				new DeleteSection(),
				new CreateProduct(),
				new ReadAllProducts(),
				new ReadSectionProducts(),
				new UpdateProduct(),
				new DeleteProduct(),
				new CreateReceipt(),
				new ReadAllReceipts(),
				new ReadMyReceipts(),
				new ReadCashierReceipts(),
				new ReadReceipt(),
				new DeleteReceipt(),
				new ChangePassword()
		};
	}

	@Override
	public int getDepartment() {
		return 0;
	}

}
