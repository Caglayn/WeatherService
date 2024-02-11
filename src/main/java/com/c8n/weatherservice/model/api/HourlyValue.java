package com.c8n.weatherservice.model.api;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HourlyValue {
    private Long[] time;
    private Long[] temperature_2m;
    private Long[] relative_humidity_2m;
    private Long[] dew_point_2m;
    private Long[] apparent_temperature;
    private Long[] precipitation;
    private Long[] rain;
    private Long[] snowfall;
    private Long[] snow_depth;
    private Long[] weather_code;
    private Long[] pressure_msl;
    private Long[] surface_pressure;
    private Long[] cloud_cover;
    private Long[] cloud_cover_low;
    private Long[] cloud_cover_mid;
    private Long[] cloud_cover_high;
    private Long[] et0_fao_evapotranspiration;
    private Long[] vapour_pressure_deficit;
    private Long[] wind_speed_10m;
    private Long[] wind_speed_100m;
    private Long[] wind_direction_10m;
    private Long[] wind_direction_100m;
    private Long[] wind_gusts_10m;
    private Long[] soil_temperature_0_to_7cm;
    private Long[] soil_temperature_7_to_28cm;
    private Long[] soil_temperature_28_to_100cm;
    private Long[] soil_temperature_100_to_255cm;
    private Long[] soil_moisture_0_to_7cm;
    private Long[] soil_moisture_7_to_28cm;
    private Long[] soil_moisture_28_to_100cm;
    private Long[] soil_moisture_100_to_255cm;
}
