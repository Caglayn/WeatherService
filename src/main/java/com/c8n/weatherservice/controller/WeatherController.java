package com.c8n.weatherservice.controller;

import com.c8n.weatherservice.annotation.CheckSecurityToken;
import com.c8n.weatherservice.model.api.WeatherResponse;
import com.c8n.weatherservice.model.entity.AuthUser;
import com.c8n.weatherservice.model.response.SingleValue;
import com.c8n.weatherservice.service.WeatherService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.c8n.weatherservice.constant.WeatherServiceConstant.*;

@RestController
@RequestMapping(API + WEATHER)
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

//    @CheckSecurityToken
    @GetMapping(GETDAILYBYLOCATION)
    public ResponseEntity<WeatherResponse> getWeatherInfoByLocationAndDate(
            @RequestParam(value = "latitude") String latitude,
            @RequestParam(value = "longitude") String longitude,
            @RequestParam(value = "date") String date,
            HttpServletRequest request){
//        AuthUser authUser = (AuthUser) request.getAttribute(AUTH_USER);
        return weatherService
                .getDailyWeatherInfo(date, latitude, longitude)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.internalServerError().build());
    }

    @GetMapping(GETALLDAILYVARS)
    public ResponseEntity<String[]> getAllDailyVariables(HttpServletRequest request){
        return weatherService.getAllDailyVariables();
    }

    @GetMapping(GETALLHOURLYVARS)
    public ResponseEntity<String[]> getAllHourlyVariables(HttpServletRequest request) {
        return weatherService.getAllHourlyVariables();
    }

    @GetMapping(GETDAILYSUMMARY)
    public ResponseEntity<List<SingleValue>> getDailySummary(
            @RequestParam(value = "latitude") String latitude,
            @RequestParam(value = "longitude") String longitude,
            @RequestParam(value = "date") String date,
            HttpServletRequest request) {
        return weatherService.getDailySummary(date, latitude, longitude)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.internalServerError().build());
    }

    @GetMapping(GETHOURLYDATABYPARAM)
    public ResponseEntity<List<SingleValue>> getHourlyAllDayInfoByParam(
            @RequestParam(value = "latitude") String latitude,
            @RequestParam(value = "longitude") String longitude,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "param") String hourlyParam,
            HttpServletRequest request){
        return weatherService.getHourlyAllDayInfoByParam(date, latitude, longitude, hourlyParam)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.internalServerError().build());
    }
}
