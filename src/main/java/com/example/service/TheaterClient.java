package com.example.service;

import com.example.model.TheaterDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "theater-service") // registered name in Eureka
public interface TheaterClient {

    @GetMapping("/api/theaters/{id}")
    TheaterDTO getTheaterById(@PathVariable("id") Long id);
}
