package com.c8n.weatherservice.model.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

import java.util.Map;

import static com.c8n.weatherservice.constant.ApiConstant.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherResponse extends Location{
    @JsonAlias(value = DAILY_UNITS)
    private Map<String, String> dailyUnit;
    @JsonAlias(value = DAILY_VALUE)
    private Map<String, Long[]>  dailyValue;
    @JsonAlias(value = HOURLY_UNITS)
    private Map<String, String>  hourlyUnit;
    @JsonAlias(value = HOURLY_VALUE)
    private Map<String, Long[]> hourlyValue;
}
