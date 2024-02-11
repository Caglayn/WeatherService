package com.c8n.weatherservice.model.api;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherApiResponse {
    private Double latitude;
    private Double longitude;
    private String timezone;
    private Double elevation;
    
}
