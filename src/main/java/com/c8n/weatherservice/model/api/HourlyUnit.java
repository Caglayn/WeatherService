package com.c8n.weatherservice.model.api;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HourlyUnit {
    private String time;
    private String temperature_2m;
    private String relative_humidity_2m;
    private String dew_point_2m;
    private String apparent_temperature;
    private String precipitation;
    private String rain;
    private String snowfall;
    private String snow_depth;
    private String weather_code;
    private String pressure_msl;
    private String surface_pressure;
    private String cloud_cover;
    private String cloud_cover_low;
    private String cloud_cover_mid;
    private String cloud_cover_high;
    private String et0_fao_evapotranspiration;
    private String vapour_pressure_deficit;
    private String wind_speed_10m;
    private String wind_speed_100m;
    private String wind_direction_10m;
    private String wind_direction_100m;
    private String wind_gusts_10m;
    private String soil_temperature_0_to_7cm;
    private String soil_temperature_7_to_28cm;
    private String soil_temperature_28_to_100cm;
    private String soil_temperature_100_to_255cm;
    private String soil_moisture_0_to_7cm;
    private String soil_moisture_7_to_28cm;
    private String soil_moisture_28_to_100cm;
    private String soil_moisture_100_to_255cm;
}
