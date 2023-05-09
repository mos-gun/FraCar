//package com.fracar.mocks;
//
//import com.fracar.entity.Order;
//import com.fracar.repository.OrderRepository;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
//@Component
//public class OrderMockGenerator {
//
//    private OrderRepository orderRepository;
//
//    public OrderMockGenerator(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }
//
//    @PostConstruct
//    private void init() {
//        //Order: firstorder
//        Order firstorder = new Order();
//        firstorder.setVar1("firstorder");
//        firstorder.setVar2("secondvar");
//        firstorder.setVar3("thirdvar");
//        orderRepository.saveEntity(firstorder);
//
//        //Order: secondorder
//        Order secondorder = new Order();
//        secondorder.setVar1("secondorder");
//        secondorder.setVar2("secondvar2");
//        secondorder.setVar3("thirdvar3");
//        orderRepository.saveEntity(secondorder);
//    }
//
//}
