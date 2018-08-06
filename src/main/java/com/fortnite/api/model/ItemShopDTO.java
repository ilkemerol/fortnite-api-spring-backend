package com.fortnite.api.model;

import com.fortnite.api.itemshop.Items;

public class ItemShopDTO {
	
	private Items[] items;

    private String date_layout;

    private String vbucks;

    private String date;

    private String rows;

	public Items[] getItems() {
		return items;
	}

	public void setItems(Items[] items) {
		this.items = items;
	}

	public String getDate_layout() {
		return date_layout;
	}

	public void setDate_layout(String date_layout) {
		this.date_layout = date_layout;
	}

	public String getVbucks() {
		return vbucks;
	}

	public void setVbucks(String vbucks) {
		this.vbucks = vbucks;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}
    
}
