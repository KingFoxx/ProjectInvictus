package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Crypto;

@Repository
public interface CryptoRepo extends JpaRepository<Crypto, Integer> {
	
	List<Crypto> findByNameIgnoreCase(String name);
	
	List<Crypto> findByABV(String abbreviation);
	
	List<Crypto> findByAMTCryp(String amountCryp);
	
	List<Crypto> findByCost(Integer cost);

}
