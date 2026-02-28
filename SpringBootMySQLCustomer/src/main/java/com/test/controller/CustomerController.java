package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Customer;
import com.test.repository.CustomerRepository;
import com.test.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Customer/v1/api")
@Tag(name="Customer Operatons")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@Autowired
	private CustomerRepository repo;
	
	@PostMapping("/create")
	@Operation(summary="CREATE CUSOTMER OPERATION")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer cst){
		Customer cobj=service.saveCustomer(cst);
		
		if(cobj!=null) {
			return new ResponseEntity<>(cobj,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(cobj,HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/list")
	@Operation(summary = "LISTING ALL CUSTOMER")
	public ResponseEntity<List<Customer>> listAllCustomer(@RequestBody Customer cst){
		List<Customer> list=service.getAllCustomer();
		
		if(list.size()>0) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(list,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/{id}",produces="application/json")
	public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable int id){
		Optional<Customer> cobj= service.getCustomerById(id);
		
		if(cobj!=null) {
			return new ResponseEntity<>(cobj,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(cobj,HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}",consumes = "application/json")
	public ResponseEntity<Customer> updateCustomerById(@PathVariable int id,@RequestBody Customer cst){
		cst.setId(id);
		Customer cobj=service.updateCustomer(cst);
		if(cobj!=null) {
			return new ResponseEntity<>(cobj,HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<>(cobj,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value="/{id}",produces = "application/json")
	public ResponseEntity<List<Customer>> deleteCustomerById(@PathVariable int id){
		List<Customer> list=service.deleteCustomerByID(id);
		if(list.size()>0) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/byname/{name}")
	@Operation(summary="get Customer by name")
	public ResponseEntity<Customer> getCustomerByName(@PathVariable String name){
		Customer cobj=repo.getCustomerByName(name);
		
		if(cobj!=null) {
			return new ResponseEntity<>(cobj,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(cobj,HttpStatus.NOT_FOUND);
		}
	}
	
}
