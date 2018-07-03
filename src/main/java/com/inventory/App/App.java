package com.inventory.App;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.inventory.bean.Cheese;
import com.inventory.bean.Item;
import com.inventory.bean.Milk;
import com.inventory.bean.Wheat;
import com.inventory.service.InventoryService;
import com.inventory.service.InventoryServiceImpl;

public class App {

	public static void main(String[] args) throws SQLException {

		InventoryServiceImpl service = new InventoryServiceImpl();
		List<Item> list = new LinkedList<Item>();
		list = service.readAllItemsFromDb();
		service.calculateExpiryDate(list);
		service.removeExpiredItems(list);
		for (Item item : list) {
			if (item instanceof Cheese) {
				Cheese cheese = (Cheese) item;
				System.out.println(item.getId() + "	" + item.getDescription() + "	" + item.getWeight() + "	"
						+ item.getPrice() + "	" + item.getMfg_date() + "	" + item.getUsebeforeinmonths() + "	"
						+ cheese.getType() + "	" + cheese.getProtein() + "	" + cheese.getVitaminB1() + "	"
						+ cheese.getFat());
			} else if (item instanceof Milk) {
				Milk milk = (Milk) item;
				System.out.println(item.getId() + "	" + item.getDescription() + "	" + item.getWeight() + "	"
						+ item.getPrice() + "	" + item.getMfg_date() + "	" + item.getUsebeforeinmonths() + "	"
						+ milk.getFatRate() + "	" + milk.getMilktype());
			} else if (item instanceof Wheat)

			{
				Wheat wheat = (Wheat) item;
				System.out.println(item.getId() + "	" + item.getDescription() + "	" + item.getWeight() + "	"
						+ item.getPrice() + "	" + item.getMfg_date() + "	" + item.getUsebeforeinmonths() + "	"
						+ wheat.getWheattype());
			}
		}
	}

}
