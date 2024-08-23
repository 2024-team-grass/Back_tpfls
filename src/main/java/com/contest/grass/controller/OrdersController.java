package com.contest.grass.controller;

import com.contest.grass.entity.Orders;
import com.contest.grass.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    // 이름 업데이트 (POST)
    @PostMapping("/name")
    public ResponseEntity<Orders> updateName(@RequestBody Orders order, @RequestParam String name) {
        order.setName(name);
        Orders updatedOrder = ordersService.saveOrder(order);
        return ResponseEntity.ok(updatedOrder);
    }

    // 전화번호 업데이트 (POST)
    @PostMapping("/phoneNumber")
    public ResponseEntity<Orders> updatePhoneNumber(@RequestBody Orders order, @RequestParam Integer phoneNumber) {
        order.setPhoneNumber(phoneNumber);
        Orders updatedOrder = ordersService.saveOrder(order);
        return ResponseEntity.ok(updatedOrder);
    }

    // 주소 업데이트 (POST)
    @PostMapping("/address")
    public ResponseEntity<Orders> updateAddress(@RequestBody Orders order, @RequestParam String address) {
        order.setAddress(address);
        Orders updatedOrder = ordersService.saveOrder(order);
        return ResponseEntity.ok(updatedOrder);
    }

    // 상세주소 업데이트 (POST)
    @PostMapping("/detailAddress")
    public ResponseEntity<Orders> updateDetailAddress(@RequestBody Orders order, @RequestParam String detailAddress) {
        order.setDetailAddress(detailAddress);
        Orders updatedOrder = ordersService.saveOrder(order);
        return ResponseEntity.ok(updatedOrder);
    }

    // 배송 요청사항 업데이트 (POST)
    @PostMapping("/request")
    public ResponseEntity<Orders> updateRequest(@RequestBody Orders order, @RequestParam String request) {
        order.setRequest(request);
        Orders updatedOrder = ordersService.saveOrder(order);
        return ResponseEntity.ok(updatedOrder);
    }

    // 공동현관 출입번호 업데이트 (POST)
    @PostMapping("/doorpassword")
    public ResponseEntity<Orders> updateDoorPassword(@RequestBody Orders order, @RequestParam String doorpassword) {
        order.setDoorpassword(doorpassword);
        Orders updatedOrder = ordersService.saveOrder(order);
        return ResponseEntity.ok(updatedOrder);
    }

    // 결제 처리 (POST)
    @PostMapping("/payment")
    public ResponseEntity<String> processPayment(@RequestBody Orders order) {
        String result = ordersService.processPayment(order);
        return ResponseEntity.ok(result);
    }

    // 구매하기 버튼 눌렀을 때 총액 확인 (GET)
    @GetMapping("/totalAmount/{orderId}")
    public ResponseEntity<Integer> getTotalAmount(@PathVariable Long orderId) {
        Orders order = ordersService.findOrderById(orderId);
        return ResponseEntity.ok(order.getTotalAmount());
    }
}