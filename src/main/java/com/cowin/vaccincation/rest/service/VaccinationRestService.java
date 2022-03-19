package com.cowin.vaccincation.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class VaccinationRestService {

    @Autowired
    private RestTemplate restTemplate;


    public Object getVaccinationCenters(VaccinationCenterRequest request){

        final String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<Object> response = restTemplate.exchange(url
                        + "?pincode=" + request.getPinCode()
                        + "&date=" + request.getDate(),
                HttpMethod.GET, entity, Object.class);

        return response.getBody();

    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
