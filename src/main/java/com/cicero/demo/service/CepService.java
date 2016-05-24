package com.cicero.demo.service;

import com.cicero.demo.domain.CEP;
import com.cicero.demo.exception.CEPNotFoundException;

public interface CepService {
	CEP findCepByNumber(Long cep) throws CEPNotFoundException;
}
