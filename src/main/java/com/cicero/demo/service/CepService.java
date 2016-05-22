package com.cicero.demo.service;

import com.cicero.demo.entity.Address;
import com.cicero.demo.exception.AddressNotFoundException;

public interface CepService {
	Address findAddressByCep(Long cep) throws AddressNotFoundException;
}
