package View;

import java.util.Scanner;

import Controller.ReadAllReceipts;
import Model.Database;
import Model.Employee;
import Model.Option;
import Model.Product;
import Model.Receipt;

public class ReadReceipt implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {

		System.out.println("Enter Receipt ID (-1 to show all receipts):");
		int ID = s.nextInt();
		while (ID<0) {
			new ReadAllReceipts(database).print();
			System.out.println("Enter Receipt ID (-1 to show all receipts):");
			ID = s.nextInt();
		}
		
		Receipt receipt = new Controller.ReadReceipt(ID, database).getReceipt();
		System.out.println("--------------------------------");
		System.out.println("ID:\t\t"+receipt.getID());
		System.out.println("Cashier:\t"+receipt.getCashier().getName());
		System.out.println(" --------------------------");
		for (Product p : receipt.getProducts()) {
			System.out.print("  ");
			System.out.print(p.getName()+"\t");
//			if (p.getName().length()<8) System.out.print("\t");
			System.out.print(p.getPrice()+"$\t"+p.getQty());
			System.out.println();
		}
		System.out.println(" --------------------------");
		System.out.println("Total:\t\t"+receipt.getTotal()+"$");
		System.out.println("Payment:\t"+receipt.getPaymentToString());
		System.out.println("Paid:\t\t"+receipt.getPaid()+"$");
		System.out.println("Change:\t\t"+receipt.getChange()+"$");
		System.out.println("--------------------------------");
		
	}

	@Override
	public String getOption() {
		return "View Receipt";
	}

}
