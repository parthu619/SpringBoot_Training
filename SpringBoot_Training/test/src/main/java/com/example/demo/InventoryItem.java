package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PARTHU_TABLE",schema="PARTHU")
public class InventoryItem {
	@Id
	@Column(name="ITEM_ID")
	private long itemId;
	@Column(name="ITEM_NAME")
	private String itemName;
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	

}
