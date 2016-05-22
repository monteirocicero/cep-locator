package com.cicero.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cicero.demo.db.CepDatabase;
import com.cicero.demo.entity.Address;
import com.cicero.demo.exception.AddressNotFoundException;
import com.cicero.demo.service.CepService;

@Component
public class CepServiceImpl implements CepService {
	
	@Autowired
	private CepDatabase cepDatabase;

	@Override
	public Address findAddressByCep(Long cep) throws AddressNotFoundException {
		Address address = cepDatabase.findCep(cep);
		if (address != null && address.isValidAdress()) {
			return address;
		} else {
			// TODO - Implementar metodo de retry
			return null;
		}
	}

}
