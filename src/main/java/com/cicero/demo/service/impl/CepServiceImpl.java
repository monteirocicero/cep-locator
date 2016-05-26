package com.cicero.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cicero.demo.db.CepDatabase;
import com.cicero.demo.domain.CEP;
import com.cicero.demo.exception.CEPNotFoundException;
import com.cicero.demo.service.CepService;

@Component
public class CepServiceImpl implements CepService {

	@Autowired
	private CepDatabase cepDatabase;

	@Override
	public CEP findCepByNumber(Long cep) throws CEPNotFoundException {
		CEP cepFound = cepDatabase.findCep(cep);

		if (cepFound == null || !cepFound.isValidAdress()) {
			String cepStr = String.valueOf(cep);
			int attempts = cepStr.length() - 1;
			return retry(cep, attempts);
		}
		return cepFound;
	}

	private CEP retry(Long cep, int attempts) throws CEPNotFoundException {
		CEP cepFound = cepDatabase.findCep(cep);
		
		if (attempts >= 0 && cepFound == null || !cepFound.isValidAdress()) {
			
			String cepStr = String.valueOf(cep);
			char cepChar[] = cepStr.toCharArray();
			cepChar[attempts] = '0';
			cepStr = String.copyValueOf(cepChar);
			Long cepRequest = Long.valueOf(cepStr);
			
			
			cepFound = retry(cepRequest, attempts - 1);
		}
		return cepFound;
	}
}
