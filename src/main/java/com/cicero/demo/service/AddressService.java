package com.cicero.demo.service;

import com.cicero.demo.domain.CEP;

public interface AddressService {
	boolean validateCep(CEP address);
	Integer save(CEP address);
	CEP findById(Integer address);
	void remove(Integer address);
}
