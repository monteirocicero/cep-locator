package com.cicero.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cicero.demo.db.AddressDB;
import com.cicero.demo.domain.CEP;
import com.cicero.demo.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	private static final String URI_WS_CEP = "localhost:8080/api/cep/%s";
	
	@Autowired
	private AddressDB addressDB;

	@Override
	public boolean validateCep(CEP address) {
		final String uri = String.format(URI_WS_CEP, address.getCep());
		boolean isValid = true;
	     
	    RestTemplate restTemplate = new RestTemplate();
	    CEP result = restTemplate.getForObject(uri, CEP.class);
	    if (result != null) {
	    	isValid = true;
	    }
	    return isValid;
	    
	}

	@Override
	public Integer save(CEP address) {
		return this.addressDB.save(address);
	}

	@Override
	public CEP findById(Integer address) {
		return this.addressDB.searchById(address);
	}


	@Override
	public void remove(Integer identifier) {
		this.addressDB.remove(identifier);
	}

}
