package com.c8n.weatherservice.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SingleValue {
    private String name;
    private String unit;
    private String val;
    private String explanation;
}
