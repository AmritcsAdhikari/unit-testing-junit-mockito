package com.amrit.service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.amrit.repository.Repository;

public class Service {
	
	private Repository repository;
	
	public Service(Repository repository) {
		this.repository = repository;
	}
	
	public List<String> getDataLength(){
		
		try {
			return repository.getData()
					.stream()
					.filter(data -> data.length() < 5)
					.collect(Collectors.toList());
		}catch(SQLException e) {
			return Arrays.asList();
		}
	}

}
