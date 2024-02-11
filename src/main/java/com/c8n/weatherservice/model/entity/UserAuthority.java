package com.c8n.weatherservice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuthority implements Serializable {
    private static final long serialVersionUID = 7665521604528322278L;
    @Id
    @JsonIgnore
    private UUID id;

    @JsonIgnore
    private UUID userId;

    private int roleId;

    private String authorityList;

    @JsonIgnore
    private boolean deleted;

    @JsonIgnore
    private Timestamp createDate;

    @JsonIgnore
    private Timestamp updateDate;
}
