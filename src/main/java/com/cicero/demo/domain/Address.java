package com.cicero.demo.domain;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty
	@NotBlank
	private String cep;
	
	@NotEmpty
	@NotBlank
	private String street;
	
	private Integer houseNumber;
	private String neighborhood;
	private String complement;
	
	@NotEmpty
	@NotBlank
	private String city;
	
	@NotEmpty
	@NotBlank
	private String state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
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
