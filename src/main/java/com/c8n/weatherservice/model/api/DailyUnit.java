package com.c8n.weatherservice.model.api;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DailyUnit {
    private String time;
    private String weather_code;
    private String temperature_2m_max;
    private String temperature_2m_min;
    private String temperature_2m_mean;
    private String apparent_temperature_max;
    private String apparent_temperature_min;
    private String apparent_temperature_mean;
    private String sunrise;
    private String sunset;
    private String daylight_duration;
    private String sunshine_duration;
    private String precipitation_sum;
    private String rain_sum;
    private String snowfall_sum;
    private String precipitation_hours;
    private String wind_speed_10m_max;
    private String wind_gusts_10m_max;
    private String wind_direction_10m_dominant;
    private String shortwave_radiation_sum;
    private String et0_fao_evapotranspiration;
}
