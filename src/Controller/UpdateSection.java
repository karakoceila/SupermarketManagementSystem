package Controller;

import java.sql.SQLException;

import Model.Database;
import Model.Section;

public class UpdateSection {
	
	public UpdateSection(Section s, Database database) {
		String update = "UPDATE `sections` SET `Name`='"+s.getName()+
				"',`Description`='"+s.getDescription()+"' WHERE `ID` = "+
				s.getID()+" ;";
		try {
			database.getStatement().execute(update);
			System.out.println("Section updated successfully");
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

}
