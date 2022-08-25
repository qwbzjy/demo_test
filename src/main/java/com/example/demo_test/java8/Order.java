package com.example.demo_test.java8;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 *  Java8 根据字段进行去重方案总结：https://www.cnblogs.com/cdfive2018/p/15064524.html
 */
@Data
public class Order {
    private Long id;
    private Long customerId;
    private String customerName;
    private List<OrderItem> orderItemList;
    private Double totalPrice;
    private LocalDateTime placedAt;

    public static List<Order> getData() {
        List<Product> products = Product.getData();
        List<Customer> customers = Customer.getData();

        Random random = new Random();
        return LongStream.rangeClosed(1, 10).mapToObj(i ->
        {
            Order order = new Order();
            order.setId(i);
            order.setPlacedAt(LocalDateTime.now().minusHours(random.nextInt(24 * 365)));

            order.setOrderItemList(IntStream.rangeClosed(1, random.ints(1, 1, 8).findFirst().getAsInt()).mapToObj(j ->
            {
                OrderItem orderItem = new OrderItem();
                Product product = products.get(random.nextInt(products.size()));
                orderItem.setProductId(product.getId());
                orderItem.setProductName(product.getName());
                orderItem.setProductPrice(product.getPrice());
                orderItem.setProductQuantity(random.ints(1, 1, 5).findFirst().getAsInt());
                return orderItem;
            }).collect(toList()));
            order.setTotalPrice(order.getOrderItemList().stream().mapToDouble(item -> item.getProductPrice() * item.getProductQuantity()).sum());
            double sum = order.getOrderItemList().stream().mapToDouble(item -> item.getProductPrice() * item.getProductQuantity()).sum();
            List<OrderItem> collect = order.getOrderItemList().stream().sorted(Comparator.comparingInt(OrderItem::getProductQuantity).reversed().thenComparingLong(OrderItem::getProductId).reversed()).collect(toList());
            //根据字段去重  Function.identity()  意思是： t->t  https://blog.csdn.net/qq_41378597/article/details/103942253
            Map<Long, OrderItem> collect1 = order.getOrderItemList().stream().collect(Collectors.toMap(OrderItem::getProductId, Function.identity(), (oldValue, newValue) -> oldValue));
            TreeSet<OrderItem> collect3 = order.getOrderItemList().stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(OrderItem::getProductName))));


            List<String> collect2 = order.getOrderItemList().stream().map(OrderItem::getProductName).collect(toList());
            OrderItem orderItem = order.getOrderItemList().stream().max(Comparator.comparingInt(OrderItem::getProductQuantity)).orElse(null);



//            order.getOrderItemList().stream().filter(distinctByKey(OrderItem::getProductName))


            Customer customer = customers.get(random.nextInt(customers.size()));
            order.setCustomerId(customer.getId());
            order.setCustomerName(customer.getName());

            return order;
        }).collect(toList());
    }
}
