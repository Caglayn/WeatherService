package com.c8n.weatherservice.model.api;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DailyValue {
    private Long[] time;
    private Long[] weather_code;
    private Long[] temperature_2m_max;
    private Long[] temperature_2m_min;
    private Long[] temperature_2m_mean;
    private Long[] apparent_temperature_max;
    private Long[] apparent_temperature_min;
    private Long[] apparent_temperature_mean;
    private Long[] sunrise;
    private Long[] sunset;
    private Long[] daylight_duration;
    private Long[] sunshine_duration;
    private Long[] precipitation_sum;
    private Long[] rain_sum;
    private Long[] snowfall_sum;
    private Long[] precipitation_hours;
    private Long[] wind_speed_10m_max;
    private Long[] wind_gusts_10m_max;
    private Long[] wind_direction_10m_dominant;
    private Long[] shortwave_radiation_sum;
    private Long[] et0_fao_evapotranspiration;
}
