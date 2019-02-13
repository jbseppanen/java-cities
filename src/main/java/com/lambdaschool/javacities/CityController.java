package com.lambdaschool.javacities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityRepository cityRepo;
    private final RabbitTemplate template;

    public CityController(CityRepository cityRepo, RabbitTemplate template) {
        this.cityRepo = cityRepo;
        this.template = template;
    }

    @GetMapping("/afford")
    public void getAffordableMessages() {
        ArrayList<City> cities = (ArrayList<City>) cityRepo.findAll();
        ArrayList<CityMessage> messages = getMessages(cities);

        for (int i=0;i<messages.size();++i) {
            if (messages.get(i).isSecret()) {
                log.info("Sending Secret Message...");
                template.convertAndSend(JavaCitiesApplication.QUEUE_NAME_SECRET, messages.get(i));
            } else {
                if (cities.get(i).getAffordabilityIndex() < 6) {
                    log.info("Sending Cities1 Message...");
                    template.convertAndSend(JavaCitiesApplication.QUEUE_NAME_CITIES1, messages.get(i));
                } else {
                    log.info("Sending Cities2 Message...");
                    template.convertAndSend(JavaCitiesApplication.QUEUE_NAME_CITIES2, messages.get(i));
                }
            }
        }
    }

    @GetMapping("/homes")
    public void getHomesMessages() {
        ArrayList<City> cities = (ArrayList<City>) cityRepo.findAll();
        ArrayList<CityMessage> messages = getMessages(cities);

        for (int i=0;i<messages.size();++i) {
            if (messages.get(i).isSecret()) {
                log.info("Sending Secret Message...");
                template.convertAndSend(JavaCitiesApplication.QUEUE_NAME_SECRET, messages.get(i));
            } else {
                if (cities.get(i).getMedianHomePrice() > 200000) {
                    log.info("Sending Cities1 Message...");
                    template.convertAndSend(JavaCitiesApplication.QUEUE_NAME_CITIES1, messages.get(i));
                } else {
                    log.info("Sending Cities2 Message...");
                    template.convertAndSend(JavaCitiesApplication.QUEUE_NAME_CITIES2, messages.get(i));
                }
            }
        }
    }

    @GetMapping("/names")
    public void getCityNameMessages() {
        ArrayList<City> cities = (ArrayList<City>) cityRepo.findAll();
        ArrayList<CityMessage> messages = getMessages(cities);

        for (int i=0;i<messages.size();++i) {
            if (messages.get(i).isSecret()) {
                log.info("Sending Secret Message...");
                template.convertAndSend(JavaCitiesApplication.QUEUE_NAME_SECRET, messages.get(i));
            } else {
                    log.info("Sending Cities1 Message...");
                    template.convertAndSend(JavaCitiesApplication.QUEUE_NAME_CITIES1, messages.get(i));
            }
        }
    }

    public ArrayList<CityMessage> getMessages(ArrayList<City> cities) {
        ArrayList<CityMessage> messages = new ArrayList<>();
        for (City city : cities) {
            int randPriority = new Random().nextInt(10);
            boolean randSecretBool = new Random().nextBoolean();
            messages.add(new CityMessage(city.toString(), randPriority, randSecretBool));
        }
        return messages;
    }


}
