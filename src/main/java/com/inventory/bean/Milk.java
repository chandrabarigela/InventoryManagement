package com.inventory.bean;

import java.sql.Date;

public class Milk extends Item {
	private int fatRate;
	private MilkType milktype;

	public Milk(int id, String description, float weight, float price, Date mfg_date, int usebeforeinmonths,
			int fatRate, MilkType milktype) {
		super(id, description, weight, price, mfg_date, usebeforeinmonths);
		this.fatRate = fatRate;
		this.milktype = milktype;
	}

	public int getFatRate() {
		return fatRate;
	}

	public void setFatRate(int fatRate) {
		this.fatRate = fatRate;
	}

	public MilkType getMilktype() {
		return milktype;
	}

	public void setMilktype(MilkType milktype) {
		this.milktype = milktype;
	}

	@Override
	public String toString() {
		return "Milk [fatRate=" + fatRate + ", milktype=" + milktype + "]";
	}

}
