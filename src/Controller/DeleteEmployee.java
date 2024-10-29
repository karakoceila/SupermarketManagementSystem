package Controller;

import java.sql.SQLException;

import Model.Database;

public class DeleteEmployee {
	
	public DeleteEmployee(int ID, Database database) {
		String delete = "DELETE FROM `employees` WHERE `ID` = "+ID+" ;";
		try {
			database.getStatement().execute(delete);
			System.out.println("Employee deleted successfully");
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

}
