package com.inventory.bean;

import java.sql.Date;

public class Wheat extends Item{

	private WheatType wheattype;

	public Wheat(int id, String description, float weight, float price, Date mfg_date, int usebeforeinmonths,
			WheatType wheattype) {
		super(id, description, weight, price, mfg_date, usebeforeinmonths);
		this.wheattype = wheattype;
	}

	public WheatType getWheattype() {
		return wheattype;
	}

	public void setWheattype(WheatType wheattype) {
		this.wheattype = wheattype;
	}

	@Override
	public String toString() {
		return "Wheat [wheattype=" + wheattype + "]";
	}
	
	
}
