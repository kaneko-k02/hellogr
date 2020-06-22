package com.pci.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TR_SALES database table.
 * 
 */
@Entity
@Table(name="TR_SALES")
@NamedQuery(name="TrSale.findAll", query="SELECT t FROM TrSale t")
public class TrSale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SALES_ID")
	private int salesId;

	private int quantity;

	@Temporal(TemporalType.DATE)
	@Column(name="SALES_DATE")
	private Date salesDate;

	@Temporal(TemporalType.DATE)
	@Column(name="UPD_DATE")
	private Date updDate;

	//bi-directional many-to-one association to MtItem
	@ManyToOne
	@JoinColumn(name="ITEM_CODE")
	private MtItem mtItem;

	//bi-directional many-to-one association to MtUser
	@ManyToOne
	@JoinColumn(name="USER_CODE")
	private MtUser mtUser;

	public TrSale() {
	}

	public int getSalesId() {
		return this.salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getSalesDate() {
		return this.salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public MtItem getMtItem() {
		return this.mtItem;
	}

	public void setMtItem(MtItem mtItem) {
		this.mtItem = mtItem;
	}

	public MtUser getMtUser() {
		return this.mtUser;
	}

	public void setMtUser(MtUser mtUser) {
		this.mtUser = mtUser;
	}

}