package com.example.service;

import com.example.dao.entity.Order;
import com.example.dao.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public void createOrderAndThrowRuntimeException() {
        Order order = new Order();
        order.setTitle("Create Order");
        order.setDescription("This is createOrder method with runtime exception");
        orderRepository.save(order);
        throw new RuntimeException("Create Order RuntimeException");
    }

    //todo:Use Propagation **REQUIRES_NEW, **this will force spring to create a sub transaction.
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createOrderWithPropagationRequiresNewAndThrowRuntimeException() {
        Order order = new Order();
        order.setTitle("Create Order");
        order.setDescription("This is createOrder method with runtime exception");
        orderRepository.save(order);
        throw new RuntimeException("Create Order RuntimeException");
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createOrderWithPropagationRequiresNew() {
        Order order = new Order();
        order.setTitle("Create Order");
        order.setDescription("This is createOrder method with runtime exception");
        orderRepository.save(order);
    }

}
