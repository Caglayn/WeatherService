package com.c8n.weatherservice.constant;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class WeatherServiceConstant {

    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    // Rest Api URL s
    public static final String API = "/api/v1";
    public static final String WEATHER = "/weather";
    public static final String GETDAILYBYLOCATION = "/getdailybylocation";
    public static final String GETALLDAILYVARS = "/getalldailyvars";
    public static final String GETALLHOURLYVARS = "/getallhourlyvars";
    public static final String GETDAILYSUMMARY = "/getdailysummary";
    public static final String GETHOURLYDATABYPARAM = "/gethourlydatabyparam";


    public static final String AUTH_HEADER = "Authorization";
    public static final String AUTH_USER = "authUser";
}
