package com.pci.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MT_USER database table.
 * 
 */
@Entity
@Table(name="MT_USER")
@NamedQuery(name="MtUser.findAll", query="SELECT m FROM MtUser m")
public class MtUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_CODE")
	private String userCode;

	private boolean enabled;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name="USER_PW")
	private String userPw;

	//bi-directional many-to-one association to MtRole
	@ManyToOne
	@JoinColumn(name="ROLE_CODE")
	private MtRole mtRole;

	//bi-directional many-to-one association to TrSale
	@OneToMany(mappedBy="mtUser")
	private List<TrSale> trSales;

	public MtUser() {
	}

	public MtUser(String userCode, String userPw, MtRole mtRole, String userName,  boolean enabled) {
		super();
		this.userCode = userCode;
		this.enabled = enabled;
		this.userName = userName;
		this.userPw = userPw;
		this.mtRole = mtRole;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPw() {
		return this.userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public MtRole getMtRole() {
		return this.mtRole;
	}

	public void setMtRole(MtRole mtRole) {
		this.mtRole = mtRole;
	}

	public List<TrSale> getTrSales() {
		return this.trSales;
	}

	public void setTrSales(List<TrSale> trSales) {
		this.trSales = trSales;
	}

	public TrSale addTrSale(TrSale trSale) {
		getTrSales().add(trSale);
		trSale.setMtUser(this);

		return trSale;
	}

	public TrSale removeTrSale(TrSale trSale) {
		getTrSales().remove(trSale);
		trSale.setMtUser(null);

		return trSale;
	}

}