package com.communication.sender.controller;

import com.communication.sender.model.Payment;
import com.communication.sender.sender.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {
    Logger logger = LoggerFactory.getLogger(SendController.class);

    @Autowired
    Sender sender;

    @GetMapping("/home")
    public String home() {
        return "Hello from the other side";
    }

    @PostMapping("/send")
    public String send(@RequestBody Payment payment) {
        logger.info("---------------------------------- \n"
                + "Message sending to the queue \n"
                + "---------------------------------- \n");

        return sender.sendToBroker(payment);
    }
}
