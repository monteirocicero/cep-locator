package com.cicero.demo.entity;

import org.springframework.util.StringUtils;

public final class Address {

	private final Long cep;
	private final String street;
	private final String neighborhood;
	private final String city;
	private final String state;

	public Address(Long cep, String street, String neighborhood, String city, String state) {
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

	public String getStreet() {
		return street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public boolean isValidAdress() {
		if (StringUtils.isEmpty(getStreet()) || StringUtils.isEmpty(getCity()) || StringUtils.isEmpty(getState())
				|| StringUtils.isEmpty(getNeighborhood())) {
			return false;
		}
		return true;
	}
}
