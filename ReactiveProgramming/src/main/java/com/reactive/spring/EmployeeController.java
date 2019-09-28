package com.reactive.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestBody Employee e) {
		employeeService.create(e);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Mono<Employee>> findById(@PathVariable("id") Integer id){
		
		Mono<Employee> e=employeeService.findById(id);
		HttpStatus status=e!=null?HttpStatus.OK:HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<Employee>>(e,status);
		
	}
	
	@GetMapping("/{name}")
	public Flux<Employee> findByName(@PathVariable("name") String name){
		return employeeService.findByName(name);
	}
	
	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@ResponseBody
	public Flux<Employee> findAll(){
		Flux<Employee> e= employeeService.findAll();
		return e;
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Employee> update(@RequestBody Employee e){
		return employeeService.update(e);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id")Integer id) {
		employeeService.delete(id).subscribe();
	}
}
