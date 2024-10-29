package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.Product;

public class CreateProduct {
	
	public CreateProduct(Product p, int section, Database database) {
		String insert = "INSERT INTO `products`(`Name`, `Description`, `Price`, `Qty`,"
				+ " `Section`) VALUES ('"+p.getName()+"','"+p.getDescription()+"','"+
				p.getPrice()+"','"+p.getQty()+"','"+section+"');";
		try {
			database.getStatement().execute(insert);
			System.out.println("Product created successfully");
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

}
