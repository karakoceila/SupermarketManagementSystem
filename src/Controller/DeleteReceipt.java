package Controller;

import java.sql.SQLException;

import Model.Database;

public class DeleteReceipt {
	
	public DeleteReceipt(int ID, Database database) {
		String deleteReceipt = "DELETE FROM `receipts` WHERE `ID` = "+ID+" ;";
		String deleteProducts = "DELETE FROM `receiptsproducts` WHERE `Receipt` = "
								+ID+" ;";
		try {
			database.getStatement().execute(deleteReceipt);
			database.getStatement().execute(deleteProducts);
			System.out.println("Receipt deleted successfully");
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

}
