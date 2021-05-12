package com.casestudy.resouces.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.casestudy.services.validation.ClientInsert;

@ClientInsert
public class NewClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Length(max = 50, min = 10)
	private String name;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String ssnOrItin;
	private Integer tipe;
	@NotEmpty
	private String street;
	@NotNull
	private Integer number;
	private String complement;
	@NotNull
	private Integer zip;
	private Integer cityId;
	@NotEmpty
	private String phone1;
	private String phone2;
	private String phone3;
	
	public NewClientDTO() {
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	
	

}
