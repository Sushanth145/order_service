package com.filetransfer.file_transfer.service;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Async("fileTaskExecutor")
    public void processOder(){
        System.out.println("Processing order :" + Thread.currentThread().getName());

        try{
            Thread.sleep(5000);
            System.out.println("Order processed :" + Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
    }
}
}
