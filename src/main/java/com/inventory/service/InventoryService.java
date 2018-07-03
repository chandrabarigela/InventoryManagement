package com.inventory.service;

import java.sql.SQLException;
import java.util.List;

import com.inventory.bean.Item;

public interface InventoryService {
	public List<Item> readAllItemsFromDb() throws SQLException;
	public void calculateExpiryDate(List<Item> items);
	public void removeExpiredItems(List<Item>items);

}
