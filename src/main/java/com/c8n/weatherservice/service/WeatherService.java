package com.c8n.weatherservice.service;

import com.c8n.weatherservice.model.api.WeatherResponse;
import com.c8n.weatherservice.model.response.SingleValue;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface WeatherService {
    Optional<WeatherResponse> getDailyWeatherInfo(String date, String latitude, String longitude);
    ResponseEntity<String[]> getAllDailyVariables();
    ResponseEntity<String[]> getAllHourlyVariables();
    Optional<List<SingleValue>> getDailySummary(String date, String latitude, String longitude);
    Optional<List<SingleValue>> getHourlyAllDayInfoByParam(String date, String latitude, String longitude, String hourlyParam);
}
