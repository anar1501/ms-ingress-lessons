package com.example.service.concrete;

import com.example.dao.repository.OrderRepository;
import com.example.exception.NotFoundException;
import com.example.model.request.CreateOrUpdateOrderRequest;
import com.example.model.response.OrderResponse;
import com.example.service.abstracts.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.model.enums.ExceptionConstants.ORDER_NOT_FOUND;
import static com.example.model.enums.OrderStatus.DELETED;
import static com.example.model.enums.OrderStatus.DRAFT;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceHandler implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public void createOrder(CreateOrUpdateOrderRequest order) {

    }

    @Override
    public OrderResponse findOrderById(Long id) {
        return null;
    }

    @Override
    public List<OrderResponse> findAllOrders() {
        return List.of();
    }

    @Override
    public void deleteOrder(Long id) {

    }

    @Override
    public void updateOrder(Long id, CreateOrUpdateOrderRequest request) {
        var order = orderRepository.findById(id).orElseThrow(() -> new NotFoundException(ORDER_NOT_FOUND.getCode(), ORDER_NOT_FOUND.getMessage()));
        order.setAmount(request.getAmount());
        orderRepository.save(order);
    }

    @Override
    public void deleteAllDraftOrders() {
        log.info("ActionLog.deleteAllDraftOrders.started");
        var orders = orderRepository.findByStatus(DRAFT);
        orders.forEach(order -> order.setStatus(DELETED));
        orderRepository.saveAll(orders);
        log.info("ActionLog.deleteAllDraftOrders.ended");
    }
}
