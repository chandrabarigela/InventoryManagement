package com.inventory.DAO;

import java.sql.SQLException;
import java.util.List;

import com.inventory.bean.Item;

public interface InventoryServiceDAO {
	public List<Item> readAllItemsFromDb() throws SQLException;

}
