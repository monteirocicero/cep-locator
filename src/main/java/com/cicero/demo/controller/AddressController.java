package com.cicero.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cicero.demo.domain.CEP;
import com.cicero.demo.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@RequestMapping(method = RequestMethod.POST, path="/address", consumes = "application/json")
	public Integer saveAddress(CEP address) {
		return addressService.save(address);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/address", produces = "application/json")
	public CEP searchById(Integer identifier) {
		return addressService.findById(identifier);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="/address", produces = "application/json")
	public void remove(Integer identifier) {
		addressService.remove(identifier);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path="/address", consumes = "application/json")
	public void updateAddress(CEP address) {
	}

}
