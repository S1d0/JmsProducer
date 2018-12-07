package com.communication.sender.sender;

import com.communication.sender.model.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    Logger logger = LoggerFactory.getLogger(Sender.class);

    @Value("${queue.name}")
    private String dest;

    @Autowired
    private JmsTemplate jmsTemplate;

    public String sendToBroker(Payment payment) {
        logger.info("Send to dest: " + dest);
        String paymentJson = getJson(payment);
        jmsTemplate.convertAndSend(dest, paymentJson);
        return "Msg send succesful to: " + dest;
    }

    private String getJson(Object payment) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(payment);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}