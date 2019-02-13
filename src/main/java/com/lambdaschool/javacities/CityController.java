package com.lambdaschool.javacities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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
    public void getAffordableMessages(){
        ArrayList<City> cities = cityRepo.findByAffordabilityIndexLessThan(6);

    }

    @GetMapping("/homes")
    public void getHomesMessages(){

    }

    @GetMapping("/names")
    public void getCityNameMessages() {

    }


}
