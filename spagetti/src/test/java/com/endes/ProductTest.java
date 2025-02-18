package com.endes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {
	
	Product p1;
	Product p2;

	@BeforeEach
	void setUp() throws Exception {
		p1 = new Product();
		p1.setName("Monitor");
		p1.setPrice(250);
	
		p2 = new Product();
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
