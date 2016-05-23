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

		if (address == null || !address.isValidAdress()) {
			String cepStr = String.valueOf(cep);
			int attempts = cepStr.length() - 1;
			return retry(cep, attempts);
		}
		return address;
	}

	private Address retry(Long cep, int attempts) throws AddressNotFoundException {
		Address address = cepDatabase.findCep(cep);
		
		if (attempts >= 0 && address == null || !address.isValidAdress()) {
			
			String cepStr = String.valueOf(cep);
			char cepChar[] = cepStr.toCharArray();
			cepChar[attempts] = '0';
			cepStr = String.copyValueOf(cepChar);
			Long cepRequest = Long.valueOf(cepStr);
			
			
			address = retry(cepRequest, attempts - 1);
		}
		return address;
	}
}
