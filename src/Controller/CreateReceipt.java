package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Database;
import Model.Product;
import Model.Receipt;

public class CreateReceipt {
	
	public CreateReceipt(Receipt r, Database database) {
		int ID = -1;
		String insertReceipt = "INSERT INTO `receipts`(`Cashier`, `Total`, `Payment`,"
				+ " `Paid`, `Chan`) VALUES ('"+r.getCashier().getID()+"','"+r.getTotal()
				+"','"+r.getPayment()+"','"+r.getPaid()+"','"+r.getChange()+"');";
		String selectID = "SELECT LAST_INSERT_ID();";
		try {
			database.getStatement().execute(insertReceipt);
			ResultSet rs = database.getStatement().executeQuery(selectID);
			rs.next();
			ID = rs.getInt("LAST_INSERT_ID()");
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		for (Product p : r.getProducts()) {
			String insertProduct = "INSERT INTO `receiptsproducts`(`Product`,"
					+ " `Qty`, `Receipt`) VALUES ('"+p.getID()+"','"+p.getQty()
					+"','"+ID+"');";
			try {
				if (ID!=-1) database.getStatement().execute(insertProduct);
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		
		System.out.println("Receipt created successfully");
	}

}
