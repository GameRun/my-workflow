package com.example.workflow.Components;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import spinjar.com.minidev.json.JSONObject;

import java.net.URI;

@Component
public class CallRestService {

    public String execution(String url, int metot, String value, String value1) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject personJsonObject = new JSONObject();
        if (metot == 1) {
            personJsonObject.put("destinationAddress", value);
            personJsonObject.put("sourceAddress", value1);

        } else if (metot == 2) {
            personJsonObject.put("user", value);
            personJsonObject.put("product", value1);
        } else {
            personJsonObject.put("amount", Integer.parseInt(value));
            personJsonObject.put("product", value1);
        }

        HttpEntity<String> request = new HttpEntity<>(personJsonObject.toString(),headers);
        URI response = restTemplate.postForLocation(url, request);

        return response.toString();
    }

}
