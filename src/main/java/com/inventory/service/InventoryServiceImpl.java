package com.inventory.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import com.inventory.DAO.InventoryServiceDAO;
import com.inventory.DAO.InventoryServiceImplDAO;
import com.inventory.bean.Item;

public class InventoryServiceImpl implements InventoryService {
	InventoryServiceDAO dao = new InventoryServiceImplDAO();

	public List<Item> readAllItemsFromDb() throws SQLException {
		List<Item> list = dao.readAllItemsFromDb();

		return list;
	}

	public void calculateExpiryDate(List<Item> items) {
		for(Item item:items ) {
			item.setExpiryDate(DateUtils.addMonths(item.getMfg_date(), item.getUsebeforeinmonths()));
		}
		
		
	}

	public void removeExpiredItems(List<Item> items) {
		List<Item> removeList=new LinkedList<Item>();
		Date currentDate=new Date();
		for(Item item:items) {
			int i=currentDate.compareTo(item.getExpiryDate());
			if(i>0) {
				removeList.add(item);
			}
			
		}
		//System.out.println(removeList);
		items.removeAll(removeList);
	}
	

}
