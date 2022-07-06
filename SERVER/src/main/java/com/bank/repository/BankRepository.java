package com.bank.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Bank;



@Repository
public interface BankRepository extends CrudRepository<Bank, Integer> {

}
