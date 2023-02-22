package com.example.test.Repositories;

import com.example.test.Models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    

}
