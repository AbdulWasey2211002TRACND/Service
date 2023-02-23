package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.test.Controllers.Routes;
import com.example.test.Models.Orders;
import com.example.test.Repositories.OrdersRepository;

@SpringBootTest
class TestApplicationTests {

	@Mock
	private OrdersRepository orderrepo;

	@InjectMocks
	private Routes routesController;

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
    public void testNoArgsConstructor() {
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

	@Test
	public void testAddOrder() {
		Orders order = new Orders();
		order.setName("Test Order");
		order.setQuantity((long) 5);
		order.setPrice((long) 10.0);
		ResponseEntity response = routesController.Orders(order);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().toString().contains("Order Added Successfully"));
	}

	@Test
	public void testGetOrders() {
		ResponseEntity response = routesController.GetOrders();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
	}

	@Test
	public void testDeleteOrder() {
		Orders order = new Orders();
		order.setName("Test Order");
		order.setQuantity((long) 5);
		order.setPrice((long) 10.0);
		orderrepo.save(order);

		ResponseEntity response = routesController.DeleteOrder(order.getId());

		assertEquals(HttpStatus.OK, response.getStatusCode());

		assertTrue(response.getBody().toString().contains("Order Deleted Successfully"));
		assertFalse(orderrepo.findById(order.getId()).isPresent());

		
	}

	@Test
    public void testDeleteAllOrder() {
        // Arrange
        doNothing().when(orderrepo).deleteAll();

        // Act
        ResponseEntity response = routesController.DeleteOrder();

        // Assert
        verify(orderrepo).deleteAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("All Orders Deleted Successfully", response.getBody());
    }

}
