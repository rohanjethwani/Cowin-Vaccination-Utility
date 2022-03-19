package com.cowin.vaccincation.rest.controller;


import com.cowin.vaccincation.rest.service.VaccinationCenterRequest;
import com.cowin.vaccincation.rest.service.VaccinationRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class VaccinationRestController {


    @Autowired
    private VaccinationRestService vaccinationRestService;

    @PostMapping(path = "/vaccinationCenters",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getVaccinationCenters
            (@RequestBody VaccinationCenterRequest request){
        Object vaccinationCenterDetails = vaccinationRestService.getVaccinationCenters(request);
        return ResponseEntity.ok(vaccinationCenterDetails);

    }

}
