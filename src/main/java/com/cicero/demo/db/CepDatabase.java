package com.cicero.demo.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cicero.demo.domain.CEP;
import com.cicero.demo.exception.CEPNotFoundException;

@Component
public final class CepDatabase {

	private final Map<Long, CEP> ceps = Collections.synchronizedMap(new HashMap<>());

	private CepDatabase() {
		CEP address = new CEP(new Long("01452002"), "Av. Brigadeiro Faria Lima", "Jardim Paulistano",
				"São Paulo", "São Paulo");
		ceps.put(address.getCep(), address);
		address = new CEP(new Long("01311923"), "Av. Paulista", "Bela Vista", "São Paulo", "São Paulo");
		ceps.put(address.getCep(), address);
		address = new CEP(new Long("01046925"), "Av. Ipiranga", "República", "São Paulo", "São Paulo");
		ceps.put(address.getCep(), address);
		address = new CEP(new Long("01014010"), "Rua João Brícola", "Centro", "São Paulo", "São Paulo");
		ceps.put(address.getCep(), address);
		address = new CEP(new Long("01046010"), "Av. Ipiranga", "República", "São Paulo", "São Paulo");
		ceps.put(address.getCep(), address);
		address = new CEP(new Long("01005000"), "Rua Benjamim Constant", "Sé", "São Paulo", "São Paulo");
		ceps.put(address.getCep(), address);
		address = new CEP(new Long("01005001"), "", "Sé", "São Paulo", "São Paulo");
		ceps.put(address.getCep(), address);
		address = new CEP(new Long("01005002"), "Rua x", "", "São Paulo", "São Paulo");
		ceps.put(address.getCep(), address);
		address = new CEP(new Long("01005003"), "Rua x", "", "São Paulo", "São Paulo");
		ceps.put(address.getCep(), null);
		
		address = new CEP(new Long("01005999"), "Rua x", "", "São Paulo", "São Paulo");
		ceps.put(address.getCep(), address);
		address = new CEP(new Long("01005990"), "Rua x", "", "São Paulo", "São Paulo");
		ceps.put(address.getCep(), address);
		address = new CEP(new Long("01005900"), "Rua x", "Jardim Z", "São Paulo", "São Paulo");
		ceps.put(address.getCep(), address);

	}

	public CEP findCep(final Long cep) throws CEPNotFoundException{
		if (ceps.containsKey(cep)) {
			return ceps.get(cep);
		}
		throw new CEPNotFoundException();
	}

	public Map<Long, CEP> getCeps() {
		return this.ceps;
	}

}
