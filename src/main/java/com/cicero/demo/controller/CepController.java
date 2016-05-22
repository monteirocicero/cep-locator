package com.cicero.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cicero.demo.entity.Address;
import com.cicero.demo.exception.AddressNotFoundException;
import com.cicero.demo.service.CepService;

@RestController
public class CepController {
	
	@Autowired
	private CepService cepService;
	
	@RequestMapping(value="/cep/{cepNumber}", method = RequestMethod.GET)
	@ResponseBody
	public Address findCep(@PathVariable("cepNumber") Long cepNumber) throws AddressNotFoundException {
		return cepService.findAddressByCep(cepNumber);
	}

}
