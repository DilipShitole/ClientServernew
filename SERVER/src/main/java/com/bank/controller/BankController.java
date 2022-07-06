package com.bank.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Bank;
import com.bank.repository.BankRepository;



@RestController
@RequestMapping("/bank")
public class BankController {

	@Autowired
	BankRepository bankRepository;

	@PostMapping("/save")
	public void saveBank(@RequestBody Bank bank) {
		bankRepository.save(bank);
	}

	@GetMapping("/all")
	public List<Bank> getAllBanks() {
		List<Bank> bankList = (List<Bank>) bankRepository.findAll();
		return bankList;
	}

	@DeleteMapping("/delete/{id}")
	public void deleteBank(@PathVariable Integer id) {
		bankRepository.deleteById(id);

	}

	@PutMapping("/update/{id}")
	public void updateBank(@PathVariable Integer id, @RequestBody Bank bank2) {
		Optional<Bank> bank = bankRepository.findById(id);
		Bank bank1 = bank.get();
		bank1.setName(bank2.getName());
		bank1.setLoc(bank2.getLoc());
		bankRepository.save(bank1);
		
	}
}
