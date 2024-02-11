package com.c8n.weatherservice.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.UUID;

import static com.c8n.weatherservice.constant.WeatherServiceConstant.AUTH_USER;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash(AUTH_USER)
public class AuthUser implements Serializable {
    private static final long serialVersionUID = 7665533609728323378L;
    @Id
    private UUID id;
    private String username;
    private String name;
    private String surname;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserAuthority userAuthority;
}
