package com.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.test.Models.Orders;

@SpringBootTest
class TestApplicationTests {

	@Test
	public void testConstructor() {
		Orders order = new Orders(1L, "Shirt", 100L, 500L, 5L, 2L, "imagelink");
		assertEquals(1L, order.getId());
		assertEquals("Shirt", order.getName());
		assertEquals(100L, order.getPrice());
		assertEquals(500L, order.getTotalprice());
		assertEquals(5L, order.getQuantity());
		assertEquals(2L, order.getProductid());
		assertEquals("imagelink", order.getImage_link());
	}

	@Test
	public void testGettersAndSetters() {
		Orders order = new Orders();
		order.setId(1L);
		order.setName("Shirt");
		order.setPrice(100L);
		order.setTotalprice(500L);
		order.setQuantity(5L);
		order.setProductid(2L);
		order.setImage_link("imagelink");
		assertEquals(1L, order.getId());
		assertEquals("Shirt", order.getName());
		assertEquals(100L, order.getPrice());
		assertEquals(500L, order.getTotalprice());
		assertEquals(5L, order.getQuantity());
		assertEquals(2L, order.getProductid());
		assertEquals("imagelink", order.getImage_link());
	}

}
