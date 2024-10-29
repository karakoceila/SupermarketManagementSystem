package View;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Database;
import Model.Employee;
import Model.Option;
import Model.Product;
import Model.Receipt;
import Controller.ReadAllSections;
import Controller.ReadProduct;

public class CreateReceipt implements Option {

	@Override
	public void oper(Employee user, Scanner s, Database database) {
		System.out.println("Select products then enter -1 to proceed to checkout");
		ArrayList<Integer> IDs = new ArrayList<>();
		ArrayList<Integer> Qtys = new ArrayList<>();
		ReadAllSections readSections = new ReadAllSections(database);
		int i;
		do {
			readSections.printWithProducts();
			i = s.nextInt();
			if (i>0) {
				IDs.add(i);
				System.out.println("Enter qty:");
				Qtys.add(s.nextInt());
				System.out.println("----------------------------");
			}
		} while (i>0);
		
		ArrayList<Product> products = new ArrayList<>();
		for (int j=0;j<IDs.size();j++) {
			products.add(new ReadProduct(IDs.get(j), database).getProduct());
			products.get(j).setQty(Qtys.get(j));
		}
		
		double total = 0;
		System.out.println("-------------------");
		System.out.println("Review order:");
		System.out.println("-------------------");
		for (Product p : products) {
			System.out.println(p.getName()+"\t"+p.getPrice()+"$\t"+p.getQty());
			total = total + p.getPrice()*p.getQty();
		}
		System.out.println("-------------------");
		System.out.println("Total = "+total+"$");
		System.out.println("-------------------");
		
		System.out.println("1. Continue\n2. Cancel");
		int cont = s.nextInt();
		if (cont!=1) {
			return;
		}
		System.out.println("Select payment:\n1. Cash\n2. Visa");
		int payment = s.nextInt();
		while (payment <1 || payment >2) {
			System.out.println("Invalid payment method");
			System.out.println("Select payment:\n1. Cash\n2. Visa");
			payment = s.nextInt();
		}
		
		double paid, change;
		
		if (payment == 1) {
			System.out.println("Enter paid:");
			paid = s.nextDouble();
			while (paid<total) {
				System.out.println("Invalid data");
				System.out.println("Enter paid:");
				paid = s.nextDouble();
			}
			change = paid - total;
			System.out.println("Change = "+change+"$");
		} else {
			paid = 0;
			change = 0;
		}
		
		Receipt receipt = new Receipt();
		receipt.setCashier(user);
		receipt.setProducts(products);
		receipt.setTotal(total);
		receipt.setPayment(payment);
		receipt.setPaid(paid);
		receipt.setChange(change);
		
		new Controller.CreateReceipt(receipt, database);
	}

	@Override
	public String getOption() {
		return "Create Receipt";
	}

}
