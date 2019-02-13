package com.lambdaschool.javacities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReceiveMessages {

    @RabbitListener(queues = JavaCitiesApplication.QUEUE_NAME_SECRET)
    public void receivedSecretMessage(CityMessage message) {
        log.info("Received Secret Message: {} ",message.toString());
    }
    @RabbitListener(queues = JavaCitiesApplication.QUEUE_NAME_CITIES1)
    public void receivedCities1Message(CityMessage message) {
        log.info("Received Cities1 Message: {} ",message.toString());
    }

    @RabbitListener(queues = JavaCitiesApplication.QUEUE_NAME_CITIES2)
    public void receivedCities2Message(CityMessage message) {
        log.info("Received Cities2 Message: {} ",message.toString());
    }
}
