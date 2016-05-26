package com.cicero.demo.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import com.cicero.demo.domain.Address;
import com.cicero.demo.exception.AddressNotFoundException;

@Component
public final class AddressDB {
	
	private final Map<Long, Address> adresses;
	private final AtomicLong counter = new AtomicLong();
	
	private AddressDB() {
		this.adresses = Collections.synchronizedMap(new HashMap<>());
	}
	
	public Address save(Address address) {
		Long id = counter.incrementAndGet();
		address.setId(id);
		this.getAdresses().put(id, address);
		return address;
	}
	
	public void remove(Long identifier) {
		this.getAdresses().remove(identifier);
	}
	
	public Address searchById(Long identifier) throws AddressNotFoundException {
		Address found = this.getAdresses().get(identifier);
		if (found != null) {
			return found;
		}
		throw new AddressNotFoundException();
	}
	
	public Address update(Address address)throws AddressNotFoundException {
		this.getAdresses().put(address.getId(), address);
		return this.searchById(address.getId());
	}
	
	public Map<Long, Address> getAdresses() {
		return adresses;
	}

}
