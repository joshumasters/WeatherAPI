package com.tts.weatherapp.service;

import java.util.ArrayList;
import java.util.List;

import com.tts.weatherapp.Respository.ZipRepository;
import com.tts.weatherapp.models.Request;
import com.tts.weatherapp.models.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    
    @Autowired
    private ZipRepository zipRepository;

    @Value("${api_key}")
    private String apiKey;

    RestTemplate restTemplate = new RestTemplate();

    public Response getForecast(String zipCode){
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&appid=" + apiKey;
        
        Request request = new Request();
        request.setZipCode(zipCode);
        zipRepository.save(request);


        try {
            return restTemplate.getForObject(url, Response.class);
        }
        catch (HttpClientErrorException ex) {
            Response response = new Response();
            response.setName("error");
            return response;
        }

        
        
    }

    public Iterable<Request> getRecentSearch(){
        
        // return zipRepository.findAll();
        
        Iterable<Request> zips;

        if (zipRepository.count() > 10){
            zips = zipRepository.findAllById(ids)
        }

    }
}
