package com.reactive.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService implements IEmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public void create(Employee e) {
		employeeRepository.save(e).subscribe();
		
	}

	@Override
	public Mono<Employee> findById(Integer id) {
		return employeeRepository.findById(id);
		
	}

	@Override
	public Flux<Employee> findByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public Flux<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Mono<Employee> update(Employee e) {
		if(employeeRepository.existsById(e.getId()) != null)
			return employeeRepository.save(e);
		else
			return null;
		
		
	}

	@Override
	public Mono<Void> delete(Integer id) {
		return employeeRepository.deleteById(id);
	}

}
