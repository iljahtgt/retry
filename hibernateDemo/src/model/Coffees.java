package model;
// Generated 2020�~11��4�� �U��2:21:27 by Hibernate Tools 5.4.21.Final

import java.math.BigDecimal;

/**
 * Coffees generated by hbm2java
 */
public class Coffees implements java.io.Serializable {

	private String cofName;
	private int supId;
	private double price;
	private int sales;
	private int total;

	public Coffees() {
	}

	public Coffees(String cofName, int supId, double price, int sales, int total) {
		this.cofName = cofName;
		this.supId = supId;
		this.price = price;
		this.sales = sales;
		this.total = total;
	}

	public String getCofName() {
		return this.cofName;
	}

	public void setCofName(String cofName) {
		this.cofName = cofName;
	}

	public int getSupId() {
		return this.supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSales() {
		return this.sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
