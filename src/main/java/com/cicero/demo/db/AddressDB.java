package com.cicero.demo.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cicero.demo.domain.CEP;

@Component
public final class AddressDB {
	
	private final List<CEP> adresses;
	private Integer identifier;
	
	private AddressDB() {
		this.adresses = new ArrayList<>();
		this.identifier = 0;
	}
	
	public Integer save(CEP address) {
		this.getAdresses().add(identifier, address);
		return identifier++;
	}
	
	public void remove(Integer identifier) {
		this.getAdresses().remove(identifier);
	}
	
	public CEP searchById(Integer identifier) {
		return this.getAdresses().get(identifier);
	}
	
	public List<CEP> getAdresses() {
		return adresses;
	}

}
