package com.cicero.demo.service;

import com.cicero.demo.domain.Address;
import com.cicero.demo.exception.AddressNotFoundException;
import com.cicero.demo.exception.CEPNotFoundException;

public interface AddressService {
	boolean validateCep(Address address)throws CEPNotFoundException;
	Address save(Address address) throws CEPNotFoundException;
	Address findById(Long address) throws AddressNotFoundException;
	void remove(Long address);
	Address update(Address address) throws AddressNotFoundException, CEPNotFoundException; 
}
