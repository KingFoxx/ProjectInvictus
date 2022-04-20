package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Crypto;
import com.example.demo.repo.CryptoRepo;

@Service
public class CryptoService implements ServiceIF<Crypto> {

	private CryptoRepo repo;

	public CryptoService(CryptoRepo repo) {
		super();
		this.repo = repo;
	}

	public Crypto create(Crypto c) {
		Crypto created = this.repo.save(c);
		return created;
	}

	public List<Crypto> getAll() {
		return this.repo.findAll();
	}

	public Crypto getOne(Integer id) {
		Optional<Crypto> found = this.repo.findById(id);
		return found.get();

	}
	public Crypto replace(Integer id, Crypto newCrypto) {
		Crypto existing = this.repo.findById(id).get();
		existing.setName(newCrypto.getName());
		existing.setAbbreviation(newCrypto.getAbbreviation());
		existing.setAmountCryp(newCrypto.getAmountCryp());
		existing.setCost(newCrypto.getCost());
		Crypto updated = this.repo.save(existing);
		return updated;
	}
	public void remove(@PathVariable Integer id) {
		this.repo.deleteById(id);
	}
	public List<Crypto> getCryptoByName(String name) {
		List<Crypto> found = this.repo.findByNameIgnoreCase(name);
		return found;
	}
	public List<Crypto> getCryptoByABV(String abbreviation) {
		List<Crypto> found = this.repo.findByABV(abbreviation);
		return found;
	}
	public List<Crypto> getCryptoByAMTCryp(Integer amountCryp) {
		List<Crypto> found = this.repo.findByAMTCryp(amountCryp);
		return found;
	}
	public List<Crypto> getCryptoByCost(Integer cost) {
		List<Crypto> found = this.repo.findByCost(cost);
		return found;
	}
	

}
