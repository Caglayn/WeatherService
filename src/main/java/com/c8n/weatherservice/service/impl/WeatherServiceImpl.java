package com.c8n.weatherservice.service.impl;

import com.c8n.weatherservice.model.api.WeatherResponse;
import com.c8n.weatherservice.model.response.SingleValue;
import com.c8n.weatherservice.service.WeatherService;
import com.c8n.weatherservice.util.ControlUtil;
import com.c8n.weatherservice.util.HttpUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.*;

import static com.c8n.weatherservice.constant.ApiConstant.*;

@Service
public class WeatherServiceImpl implements WeatherService {
    private final HttpUtil httpUtil;
    private final RedisTemplate<String, WeatherResponse> redisTemplate;

    public WeatherServiceImpl(HttpUtil httpUtil, RedisTemplate<String, WeatherResponse> redisTemplate) {
        this.httpUtil = httpUtil;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Optional<WeatherResponse> getDailyWeatherInfo(String date, String latitude, String longitude) {
        ControlUtil.checkRequiredParams(date, latitude, longitude);

        String cacheKey = latitude + "-" + longitude + "-" + date;

        WeatherResponse weatherFromCache = redisTemplate.opsForValue().get(cacheKey);
        if (weatherFromCache != null)
            return Optional.of(weatherFromCache);

        Map<String, String> params = getParamMap(date, latitude, longitude);
        Optional<WeatherResponse> response = httpUtil.getRequest(WeatherResponse.class, WEATHER_API_URL, params);

        response.ifPresent(weatherResponse -> redisTemplate.opsForValue().set(cacheKey, weatherResponse, Duration.ofDays(30)));

        return response;
    }

    @Override
    public ResponseEntity<String[]> getAllDailyVariables() {
        return ResponseEntity.ok(ALL_DAILY_PARAMS);
    }

    @Override
    public ResponseEntity<String[]> getAllHourlyVariables() {
        return ResponseEntity.ok(ALL_HOURLY_PARAMS);
    }

    @Override
    public Optional<List<SingleValue>> getDailySummary(String date, String latitude, String longitude) {
        Optional<WeatherResponse> weatherResponseOptional = getDailyWeatherInfo(date, latitude, longitude);

        if (weatherResponseOptional.isEmpty())
            return Optional.empty();

        WeatherResponse weatherResponse = weatherResponseOptional.get();
        List<SingleValue> summaryList = new ArrayList<>();

        for (String param : DAILY_SUMMARY_PARAMS){
            summaryList.add(SingleValue.builder()
                    .name(param)
                    .unit(weatherResponse.getDailyUnit().get(param))
                    .explanation(DAILY_PARAM_EXPLANATIONS.get(param))
                    .val(weatherResponse.getDailyValue().get(param)[0].toString())
                    .build());
        }

        return summaryList.isEmpty() ? Optional.empty() : Optional.of(summaryList);
    }

    private Map<String, String> getParamMap(String date, String latitude, String longitude){
        Map<String, String> params = new HashMap<>();
        params.put(LATITUDE, latitude);
        params.put(LONGITUDE, longitude);
//        params.put(START_DATE, "2024-01-06");
//        params.put(END_DATE, "2024-01-20");
        params.put(START_DATE, date);
        params.put(END_DATE, date);
        params.put(HOURLY, getArrayAsDelimetedString(ALL_HOURLY_PARAMS));
        params.put(DAILY, getArrayAsDelimetedString(ALL_DAILY_PARAMS));
        params.put(TIME_ZONE, TIME_ZONE_PARAM);
        params.put(TIME_FORMAT, TIME_FORMAT_PARAM);

        return params;
    }
}
