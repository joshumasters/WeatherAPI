package com.tts.weatherapp.controllers;

import com.tts.weatherapp.models.Request;
import com.tts.weatherapp.models.Response;
import com.tts.weatherapp.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {
    
    @Autowired
    private WeatherService weatherService;

    

    @GetMapping("/")
    public String getIndex(Model model){

        Iterable<Request> searches = weatherService.getRecentSearch();
        model.addAttribute("request", new Request());
        model.addAttribute("searches", searches);
       
        return "index";
    }

    @PostMapping("/")
    public String postIndex(Request request, Model model){
        Iterable<Request> searches = weatherService.getRecentSearch();
        Response data = weatherService.getForecast(request.getZipCode());

        model.addAttribute("data", data);
        model.addAttribute("searches", searches);
        return "index";
    }
}
