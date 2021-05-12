package com.casestudy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.casestudy.model.enums.TipeBusiness;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Column(unique = true)
	private String email;
	private String ssnOrItin;
	private Integer tipe;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	List<Address> addresses = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "PHONENUMBER")
	Set<String> phonenumbers = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Ordeer> orders = new ArrayList<>();
	
	public Client() {}

	public Client(Integer id, String name, String email, String ssnOrItin, TipeBusiness tipe) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.ssnOrItin = ssnOrItin;
		this.tipe = (tipe == null ) ? null : tipe.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsnOrItin() {
		return ssnOrItin;
	}

	public void setSsnOrItin(String ssnOrItin) {
		this.ssnOrItin = ssnOrItin;
	}

	public Integer getTipe() {
		return tipe;
	}

	public void setTipe(Integer tipe) {
		this.tipe = tipe;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<String> getPhonenumbers() {
		return phonenumbers;
	}

	public void setPhonenumbers(Set<String> phonenumbers) {
		this.phonenumbers = phonenumbers;
	}

	public List<Ordeer> getOrders() {
		return orders;
	}

	public void setOrders(List<Ordeer> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
