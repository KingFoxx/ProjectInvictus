package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Crypto;
import com.example.demo.service.CryptoService;

@RestController
@CrossOrigin
public class CryptoController {

	private CryptoService service;
	@Autowired
	public CryptoController(CryptoService service) {
		super();
		this.service = service;
	}

	// 201 - Created
	@PostMapping("/create")
	public ResponseEntity<Crypto> createCrypto(@RequestBody Crypto c) {
		Crypto created = this.service.create(c);
		ResponseEntity<Crypto> response = new ResponseEntity<Crypto>(created, HttpStatus.CREATED);
		return response;
	}

	// 200 - OK
	@GetMapping("/getAll")
	public ResponseEntity<List<Crypto>> getAllCrypto() {
		return ResponseEntity.ok(this.service.getAll());
	}

	@GetMapping("/get/{id}")
	public Crypto getCrypto(@PathVariable Integer id) {
		return this.service.getOne(id);

	}

	// 202 - accepted
	@PutMapping("/replace/{id}")
	public ResponseEntity<Crypto> replaceCrypto(@PathVariable Integer id, @RequestBody Crypto newCrypto) {
		Crypto body = this.service.replace(id, newCrypto);
		ResponseEntity<Crypto> response = new ResponseEntity<Crypto>(body, HttpStatus.ACCEPTED);
		return response;
	}

	// 204 - no content
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeCrypto(@PathVariable Integer id) {
		this.service.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/getByName/{name}")
	public ResponseEntity<List<Crypto>> getCryptoByName(@PathVariable String name) {
		List<Crypto> found = this.service.getCryptoByName(name);
		return ResponseEntity.ok(found);
	}

	@GetMapping("/getByAbbreviation/{abbreviation}")
	public ResponseEntity<List<Crypto>> getCryptoByAbbreviation(@PathVariable String abbreviation) {
		List<Crypto> found = this.service.getCryptoByAbbreviation(abbreviation);
		return ResponseEntity.ok(found);
	}

	@GetMapping("/getByAMT/{amountCryp}")
	public ResponseEntity<List<Crypto>> getCryptoByAmountCryp(@PathVariable Double amountCryp) {
		List<Crypto> found = this.service.getCryptoByAmountCryp(amountCryp);
		return ResponseEntity.ok(found);
	}
	
	@GetMapping("/getByCost/{cost}")
	public ResponseEntity<List<Crypto>> getCryptoByCost(@PathVariable Double cost) {
		List<Crypto> found = this.service.getCryptoByCost(cost);
		return ResponseEntity.ok(found);
	}

}
