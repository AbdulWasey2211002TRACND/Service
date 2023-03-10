package com.example.test.Controllers;

import com.example.test.Models.Orders;
import com.example.test.Repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("orders")
@RestController
public class Routes {

    @Autowired
    private OrdersRepository order;

    @PostMapping("/add_orders")
    public ResponseEntity Orders(@RequestBody Orders model) {

        order.save(model);
        return new ResponseEntity<Object>("Order Added Successfully", HttpStatus.OK);

    }

    @GetMapping("/get_orders")
    public ResponseEntity GetOrders() {

        return new ResponseEntity<Object>(order.findAll(), HttpStatus.OK);

    }

    @DeleteMapping("/delete_order")
    public ResponseEntity DeleteOrder(@RequestParam Long id) {
        order.deleteById(id);
        return new ResponseEntity<Object>("Order Deleted Successfully", HttpStatus.OK);

    }

    @DeleteMapping("/delete_all_orders")
    public ResponseEntity DeleteOrder() {
        order.deleteAll();
        return new ResponseEntity<Object>("All Orders Deleted Successfully", HttpStatus.OK);

    }

}