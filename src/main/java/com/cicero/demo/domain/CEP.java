package com.cicero.demo.domain;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

public final class CEP {

	private Long cep;
	private String street;
	private String neighborhood;
	private String city;
	private String state;
	
	public CEP() {
	}

	public CEP(Long cep, String street, String neighborhood, String city, String state) {
		super();
		this.cep = cep;
		this.street = street;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@JsonIgnore
	public boolean isValidAdress() {
		if (StringUtils.isEmpty(getStreet()) || StringUtils.isEmpty(getCity()) || StringUtils.isEmpty(getState())
				|| StringUtils.isEmpty(getNeighborhood())) {
			return false;
		}
		return true;
	}
}
