package com.communication.sender.sender;

import com.communication.sender.model.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class SenderTest {

    @Test
    public void toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(new Payment("queen", "ek", "12"));
        System.out.println(json);
    }
}