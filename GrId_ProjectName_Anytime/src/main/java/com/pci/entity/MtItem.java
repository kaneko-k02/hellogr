package com.pci.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MT_ITEM database table.
 * 
 */
@Entity
@Table(name="MT_ITEM")
@NamedQuery(name="MtItem.findAll", query="SELECT m FROM MtItem m")
public class MtItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ITEM_CODE")
	private String itemCode;

	@Column(name="CATEGORY_NAME")
	private String categoryName;

	@Column(name="ITEM_NAME")
	private String itemName;

	private int price;

	private String spec;

	@Temporal(TemporalType.DATE)
	@Column(name="UPD_DATE")
	private Date updDate;

	//bi-directional many-to-one association to TrSale
	@OneToMany(mappedBy="mtItem")
	private List<TrSale> trSales;

	public MtItem() {
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSpec() {
		return this.spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public List<TrSale> getTrSales() {
		return this.trSales;
	}

	public void setTrSales(List<TrSale> trSales) {
		this.trSales = trSales;
	}

	public TrSale addTrSale(TrSale trSale) {
		getTrSales().add(trSale);
		trSale.setMtItem(this);

		return trSale;
	}

	public TrSale removeTrSale(TrSale trSale) {
		getTrSales().remove(trSale);
		trSale.setMtItem(null);

		return trSale;
	}

}