package com.inventory.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inventory.bean.Cheese;
import com.inventory.bean.CheeseType;
import com.inventory.bean.Item;
import com.inventory.bean.Milk;
import com.inventory.bean.MilkType;
import com.inventory.bean.Wheat;
import com.inventory.bean.WheatType;

public class InventoryServiceImplDAO implements InventoryServiceDAO {
	DatabaseConnection db = new DatabaseConnectionImpl();

	public List<Item> readAllItemsFromDb() throws SQLException {
		List<Item> list = new ArrayList<Item>();
		Connection con = db.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs1 = stmt.executeQuery("select * from cheese_tbl");
		while (rs1.next()) {

			Item i = new Cheese(rs1.getInt(1), rs1.getString(2), rs1.getFloat(3), rs1.getFloat(4), rs1.getDate(5),
					rs1.getInt(6), CheeseType.valueOf(rs1.getString(7)), rs1.getDouble(8), rs1.getDouble(9),
					rs1.getDouble(10));
			list.add(i);

		}
		ResultSet rs2 = stmt.executeQuery("select * from milk_tbl");
		while (rs2.next()) {

			Item i = new Milk(rs2.getInt(1), rs2.getString(2), rs2.getFloat(3), rs2.getFloat(4), rs2.getDate(5),
					rs2.getInt(6), rs2.getInt(7), MilkType.valueOf(rs2.getString(8)));
			list.add(i);
		}
		ResultSet rs3 = stmt.executeQuery("select * from wheat_tbl");
		while (rs3.next()) {

			Item i = new Wheat(rs3.getInt(1), rs3.getString(2), rs3.getFloat(3), rs3.getFloat(4), rs3.getDate(5),
					rs3.getInt(6), WheatType.valueOf(rs3.getString(7)));
			list.add(i);
		}
		return list;

	}

}
