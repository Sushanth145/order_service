package com.filetransfer.file_transfer.controller;
import com.filetransfer.file_transfer.service.OrderService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public String placeOder(){
        orderService.processOder();
        return "Order placed successfully";
    }
    
}
