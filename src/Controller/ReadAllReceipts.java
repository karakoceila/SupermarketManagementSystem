package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Database;
import Model.Receipt;

public class ReadAllReceipts {
	
	private ArrayList<Receipt> receipts;
	
	public ReadAllReceipts(Database database) {
		String select = "SELECT * FROM `receipts`;";
		ArrayList<Integer> cashierIDs = new ArrayList<>();
		receipts = new ArrayList<>();
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while (rs.next()) {
				Receipt r = new Receipt();
				r.setID(rs.getInt("ID"));
				cashierIDs.add(rs.getInt("Cashier"));
				r.setTotal(rs.getDouble("Total"));
				r.setPayment(rs.getInt("Payment"));
				r.setPaid(rs.getDouble("Paid"));
				r.setChange(rs.getDouble("Chan"));
				receipts.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i=0;i<receipts.size();i++) {
			receipts.get(i).setCashier(new ReadEmployee(cashierIDs.get(i), database)
									.getEmployee());
			receipts.get(i).setProducts(new ReadReceiptProducts(
					receipts.get(i).getID(), database).getProducts());
		}
	}
	
	public ArrayList<Receipt> getReceipts() {
		return receipts;
	}
	
	public void print() {
		System.out.println("-----------------------------------------------------");
		System.out.println("ID\tCashier\t\tTotal\tPayment\tPaid\tChange");
		for (Receipt r : receipts) {
			System.out.print(r.getID()+"\t"+r.getCashier().getName()+"\t");
			if (r.getCashier().getName().length()<8) System.out.print("\t");
			System.out.print(r.getTotal()+"$\t"+r.getPaymentToString()
					+"\t"+r.getPaid()+"$\t"+r.getChange()+"$");
			System.out.println();
		}
		System.out.println("-----------------------------------------------------");
	}

}
