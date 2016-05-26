package com.cicero.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cicero.demo.db.AddressDB;
import com.cicero.demo.domain.Address;
import com.cicero.demo.domain.CEP;
import com.cicero.demo.exception.AddressNotFoundException;
import com.cicero.demo.exception.CEPNotFoundException;
import com.cicero.demo.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	private static final String URI_WS_CEP = "http://127.0.0.1:8080/api/cep/{cepNumber}";
	
	@Autowired
	private AddressDB addressDB;

	@Override
	public boolean validateCep(Address address) throws CEPNotFoundException {
		final String uri = String.format(URI_WS_CEP, address.getCep());
		Map<String, String> map = new HashMap<String, String>();
		map.put("cepNumber", address.getCep());
		boolean isValid = true;
	     
	    RestTemplate restTemplate = new RestTemplate();
	    
	    try {
	    	ResponseEntity<CEP> result = restTemplate.getForEntity(uri, CEP.class, map);
	    	if (result != null) {
	    		isValid = true;
	    	}
			
		} catch (Exception e) {
			throw new CEPNotFoundException();
		}
	    return isValid;
	}

	@Override
	public Address save(Address address) throws CEPNotFoundException {
		
		if (this.validateCep(address)) {
			return this.addressDB.save(address);
		}
		throw new CEPNotFoundException();
	}

	@Override
	public Address findById(Long address) throws AddressNotFoundException {
		return this.addressDB.searchById(address);
	}

	@Override
	public void remove(Long identifier) {
		this.addressDB.remove(identifier);
	}

	@Override
	public Address update(Address address) throws AddressNotFoundException, CEPNotFoundException {
		if (this.validateCep(address)) {
			return this.addressDB.update(address);
		}
		throw new AddressNotFoundException();
	}

}
