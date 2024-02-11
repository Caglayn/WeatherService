package com.c8n.weatherservice.model.api;

import lombok.*;

@Getter
@Setter
public abstract class Location {
    private Double latitude;
    private Double longitude;
    private String timezone;
    private Double elevation;
}
