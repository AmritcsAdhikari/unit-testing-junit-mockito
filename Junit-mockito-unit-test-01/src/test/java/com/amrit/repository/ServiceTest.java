package com.amrit.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.amrit.service.Service;


@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class ServiceTest {
	
	@Mock
	Repository repository;
	
	@InjectMocks
	Service service;
	
	@Test
	@Order(1)
	@DisplayName("SUCESS TESST")
	void testGetDataLength() {
		
		try {
			Mockito.when(repository.getData())
					 .thenReturn(
							 Arrays.asList("A", "B", "TESTONE",
										"MODEL", "12345", "33", "MN"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		List<String> list = service.getDataLength();
		
		assertNotNull(list);
		assertEquals(4, list.size());
		
	}
	
	
	@Test
	@Order(2)
	@DisplayName("FAIL TESST")
	void testException() {
		
		try {
			Mockito.when(repository.getData())
					 .thenThrow(
							 new SQLException("Connection Exception"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		List<String> list = service.getDataLength();
		
		assertNotNull(list);
		assertEquals(0, list.size());
		
	}
	
	
	
	

}
