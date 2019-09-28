package com.reactive.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Employee {

	int id;
	String name;
	long salary;
	
}
