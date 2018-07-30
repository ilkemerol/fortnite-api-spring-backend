package com.fortnite.api.itemshop;

public class Items {

	private String refundable;

    private Item item;

    private String name;

    private String featured;

    private String itemid;

    private String cost;

	public String getRefundable() {
		return refundable;
	}

	public void setRefundable(String refundable) {
		this.refundable = refundable;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFeatured() {
		return featured;
	}

	public void setFeatured(String featured) {
		this.featured = featured;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
    
}
