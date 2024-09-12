package com.example.service.abstracts;

import com.example.model.request.CreateOrUpdateOrderRequest;
import com.example.model.response.OrderResponse;

import java.util.List;

public interface OrderService {
    void createOrder(CreateOrUpdateOrderRequest order);
    OrderResponse findOrderById(Long id);
    List<OrderResponse> findAllOrders();
    void deleteOrder(Long id);
    void updateOrder(Long id, CreateOrUpdateOrderRequest order);
    void deleteAllDraftOrders();
}
