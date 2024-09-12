package com.example.service;

import com.example.dao.entity.Product;
import com.example.dao.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final OrderService orderService;

    //todo: the product is inserted into the database even though an exception has been raised.
    public void createProductWithoutTransactionalAnnotation() {
        Product prod = new Product();
        prod.setDescription("This is an example with runtime exception but no rollback.");
        prod.setPrice(BigDecimal.valueOf(10));
        prod.setTitle("First Product");
        productRepository.save(prod);
        throw new RuntimeException();
    }


    //todo: In this example, we added @Transactional annotation to roll back the transaction if the exception occurred.
    @Transactional
    public void createProductWithTransactionalAnnotation() {
        Product prod = new Product();
        prod.setDescription("This is an example with runtime exception and transactional annotation.");
        prod.setPrice(BigDecimal.valueOf(10));
        prod.setTitle("Second Product");
        productRepository.save(prod);
        throw new RuntimeException();
    }


    //todo: This example shows that the checked exception will not be rolled back even though we have specified the **@Transactional **annotation.
    @Transactional
    public void createProductWithTransactionalAnnotationAndThrowCheckedException() throws Exception {
        Product prod = new Product();
        prod.setDescription("This is an example with checked exception and transactional annotation.");
        prod.setPrice(BigDecimal.valueOf(10));
        prod.setTitle("Second Product");
        productRepository.save(prod);
        throw new SQLException();
    }

    //todo: To roll back checked exceptions, we need to specify the rollbackFor
    @Transactional(rollbackFor = SQLException.class)
    public void createProductWithTransactionalAnnotationAndThrowCheckedExceptionAndRollbackItAsWell() throws Exception {
        Product prod = new Product();
        prod.setDescription("This is an example with checked exception and transactional annotation with rollbackFor.");
        prod.setPrice(BigDecimal.valueOf(10));
        prod.setTitle("Example 2b Product");
        productRepository.save(prod);
        throw new SQLException();
    }

    //todo: It won’t work. This happened because we manually caught the exception and handle it. Therefore the current transaction is being executed normally and committed.
    @Transactional
    public void createProductWithTransactionalAnnotationAndWrapItIntoTryCatchBlock() {
        try {
            Product prod = new Product();
            prod.setDescription("This is an example with runtime exception, transactional annotation and try catch.");
            prod.setPrice(BigDecimal.valueOf(10));
            prod.setTitle("Example 3 Product");
            productRepository.save(prod);
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("Here we catch the exception.");
        }
    }

    /* todo: createProduct() and createOrder() transactions were rolled back. Even though the runtime exception has happened in the createOrder() method.
       However, because it doesn’t handle the exception, this led to the createProduct() transaction also rollback.
    */
    @Transactional
    public void createProductWithNestedTransaction() {
        Product prod = new Product();
        prod.setDescription("This is createProduct method.");
        prod.setPrice(BigDecimal.valueOf(10));
        prod.setTitle("Create Product");
        productRepository.save(prod);
        orderService.createOrderAndThrowRuntimeException();
    }

    //todo: The product record was written into the database, and the order record was rolled back.
    @Transactional
    public void createProductWithNestedTransactionAndWrapItPropagationLevel() {
        Product prod = new Product();
        prod.setDescription("This is createProduct method.");
        prod.setPrice(BigDecimal.valueOf(10));
        prod.setTitle("Create Product");
        productRepository.save(prod);
        try {
            orderService.createOrderWithPropagationRequiresNew();
        } catch (RuntimeException e) {
            log.error(e.getMessage());
        }
    }

    /*todo: both transactions have been rolled back. Because the inner transaction threw an exception, the outer transaction detected the exception and it hasn’t been handled.
       Therefore, the outer transaction has been rolled back.
    */
    @Transactional
    public void createProductWithCreateOrderMethodWithoutTryCatchBlock() {
        Product prod = new Product();
        prod.setDescription("This is createProduct method.");
        prod.setPrice(BigDecimal.valueOf(10));
        prod.setTitle("Create Product");
        productRepository.save(prod);
        orderService.createOrderWithPropagationRequiresNew();
    }

    /*todo: the inner transaction has been committed successfully due to the Propagation.REQUIRES_NEW. This forces the Spring to handle the query in subtransaction.
       Once it is completed the outer transaction resumed, and an exception happened at this moment, so it rolled back.
    */
    @Transactional
    public void createProductWithCreateOrderMethodAndThrowRuntimeException() {
        Product prod = new Product();
        prod.setDescription("This is createProduct method.");
        prod.setPrice(BigDecimal.valueOf(10));
        prod.setTitle("Create Product with runtime");
        productRepository.save(prod);
        orderService.createOrderWithPropagationRequiresNew();
        throw new RuntimeException("Create Product RuntimeException");
    }


}
