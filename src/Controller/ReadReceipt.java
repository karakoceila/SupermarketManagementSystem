package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Database;
import Model.Receipt;

public class ReadReceipt {
	
	private Receipt receipt;
	private int cashierID;
	
	public ReadReceipt(int ID, Database database) {
		String select = "SELECT * FROM `receipts` WHERE `ID` = "+ID+" ;";
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			rs.next();
			receipt = new Receipt();
			receipt.setID(rs.getInt("ID"));
			cashierID = rs.getInt("Cashier");
			receipt.setTotal(rs.getDouble("Total"));
			receipt.setPayment(rs.getInt("Payment"));
			receipt.setPaid(rs.getDouble("Paid"));
			receipt.setChange(rs.getDouble("Chan"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		receipt.setCashier(new ReadEmployee(cashierID, database).getEmployee());
		receipt.setProducts(new ReadReceiptProducts(
				receipt.getID(), database).getProducts());
	}
	
	public Receipt getReceipt() {
		return receipt;
	}

}
