package com.bank1.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bank1.model.Bank;

@RestController
@RequestMapping("/client")
public class BankClientController {
   
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/all")
	public ResponseEntity getAllBank(){
		   HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity <Bank> entity = new HttpEntity<Bank>(headers);
		
		ResponseEntity object=restTemplate.exchange("http://localhost:9090/bank/all", HttpMethod.GET, entity,new ParameterizedTypeReference<List<Bank>>() {
        });
		System.out.println(object.getBody());
		return object;
	}
	
	
	@PostMapping("/save")
	public String saveBank(@RequestBody Bank bank) {
		   HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity <Bank> entity = new HttpEntity<Bank>(bank,headers);
		      //ResponseEntity bankSave=restTemplate.exchange("http://localhost:9090/bank/save", HttpMethod.POST,entity, Bank.class);
	    ResponseEntity bankSave=restTemplate.postForEntity("http://localhost:9090/bank/save", bank, Bank.class);
		return "record saved successfully....";
	}
	

	@PutMapping("/update/{id}")
	public String updateBank(@PathVariable Integer id,@RequestBody Bank bank) {
		   HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity <Bank> entity = new HttpEntity<Bank>(bank,headers);
		      ResponseEntity bankSave=restTemplate.exchange("http://localhost:9090/bank/update/"+id, HttpMethod.PUT,entity, Bank.class);
		return "record updated successfully....";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBank(@PathVariable Integer id) {
		   HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity <Bank> entity = new HttpEntity<Bank>(headers);
		      ResponseEntity bankSave=restTemplate.exchange("http://localhost:9090/bank/delete/"+id, HttpMethod.DELETE,entity, Bank.class);
		return "record deleted successfully....";
	}
	
	
	
}

