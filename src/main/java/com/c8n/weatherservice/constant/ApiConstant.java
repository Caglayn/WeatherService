package com.c8n.weatherservice.constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiConstant {
    public static final String DAILY_UNITS = "daily_units";
    public static final String DAILY_VALUE = "daily";
    public static final String HOURLY_UNITS = "hourly_units";
    public static final String HOURLY_VALUE = "hourly";
    public static final String[] ALL_HOURLY_PARAMS = {"temperature_2m", "relative_humidity_2m", "dew_point_2m", "apparent_temperature", "precipitation", "rain", "snowfall", "snow_depth", "weather_code", "pressure_msl", "surface_pressure", "cloud_cover", "cloud_cover_low", "cloud_cover_mid", "cloud_cover_high", "et0_fao_evapotranspiration", "vapour_pressure_deficit", "wind_speed_10m", "wind_speed_100m", "wind_direction_10m", "wind_direction_100m", "wind_gusts_10m", "soil_temperature_0_to_7cm", "soil_temperature_7_to_28cm", "soil_temperature_28_to_100cm", "soil_temperature_100_to_255cm", "soil_moisture_0_to_7cm", "soil_moisture_7_to_28cm", "soil_moisture_28_to_100cm", "soil_moisture_100_to_255cm"};
    public static final String[] ALL_DAILY_PARAMS = {"weather_code", "temperature_2m_max", "temperature_2m_min", "temperature_2m_mean", "apparent_temperature_max", "apparent_temperature_min", "apparent_temperature_mean", "sunrise", "sunset", "daylight_duration", "sunshine_duration", "precipitation_sum", "rain_sum", "snowfall_sum", "precipitation_hours", "wind_speed_10m_max", "wind_gusts_10m_max", "wind_direction_10m_dominant", "shortwave_radiation_sum", "et0_fao_evapotranspiration"};
    public static final String TIME_FORMAT_PARAM = "unixtime";
    public static final String TIME_ZONE_PARAM = "Europe/Moscow";
    public static final String HOURLY = "hourly";
    public static final String DAILY = "daily";
    public static final String TIME_ZONE = "timezone";
    public static final String TIME_FORMAT = "timeformat";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String WEATHER_API_URL = "https://archive-api.open-meteo.com/v1/archive";
    public static final List<String> DAILY_SUMMARY_PARAMS = List.of("rain_sum", "temperature_2m_max", "temperature_2m_min", "wind_speed_10m_max");

    public static final Map<String, String> DAILY_PARAM_EXPLANATIONS = new HashMap<>();
    public static final Map<String, String> HOURLY_PARAM_EXPLANATIONS = new HashMap<>();

    static {
        DAILY_PARAM_EXPLANATIONS.put("weather_code", "The most severe weather condition on a given day");
        DAILY_PARAM_EXPLANATIONS.put("temperature_2m_max", "Maximum daily air temperature at 2 meters above ground");
        DAILY_PARAM_EXPLANATIONS.put("temperature_2m_min", "Minimum daily air temperature at 2 meters above ground");
        DAILY_PARAM_EXPLANATIONS.put("temperature_2m_mean", "Mean daily air temperature at 2 meters above ground");
        DAILY_PARAM_EXPLANATIONS.put("apparent_temperature_max", "Maximum daily apparent temperature");
        DAILY_PARAM_EXPLANATIONS.put("apparent_temperature_min", "Minimum daily apparent temperature");
        DAILY_PARAM_EXPLANATIONS.put("apparent_temperature_mean", "Mean daily apparent temperature");
        DAILY_PARAM_EXPLANATIONS.put("sunrise", "Sunrise time");
        DAILY_PARAM_EXPLANATIONS.put("sunset", "Sunset time");
        DAILY_PARAM_EXPLANATIONS.put("daylight_duration", "Number of seconds of daylight per day");
        DAILY_PARAM_EXPLANATIONS.put("sunshine_duration", "The number of seconds of sunshine per day is determined by calculating direct normalized irradiance exceeding 120 W/m², following the WMO definition. Sunshine duration will consistently be less than daylight duration due to dawn and dusk.");
        DAILY_PARAM_EXPLANATIONS.put("precipitation_sum", "Sum of daily precipitation (including rain, showers and snowfall)");
        DAILY_PARAM_EXPLANATIONS.put("rain_sum", "Sum of daily rain");
        DAILY_PARAM_EXPLANATIONS.put("snowfall_sum", "Sum of daily snowfall");
        DAILY_PARAM_EXPLANATIONS.put("precipitation_hours", "The number of hours with rain");
        DAILY_PARAM_EXPLANATIONS.put("wind_speed_10m_max", "Maximum wind speed on a day");
        DAILY_PARAM_EXPLANATIONS.put("wind_gusts_10m_max", "Maximum gusts on a day");
        DAILY_PARAM_EXPLANATIONS.put("wind_direction_10m_dominant", "Dominant wind direction");
        DAILY_PARAM_EXPLANATIONS.put("shortwave_radiation_sum", "The sum of solar radiaion on a given day in Megajoules");
        DAILY_PARAM_EXPLANATIONS.put("et0_fao_evapotranspiration", "Daily sum of ET0 Reference Evapotranspiration of a well watered grass field");

        HOURLY_PARAM_EXPLANATIONS.put("temperature_2m", "Air temperature at 2 meters above ground");
        HOURLY_PARAM_EXPLANATIONS.put("relative_humidity_2m", "Relative humidity at 2 meters above ground");
        HOURLY_PARAM_EXPLANATIONS.put("dew_point_2m", "Dew point temperature at 2 meters above ground");
        HOURLY_PARAM_EXPLANATIONS.put("apparent_temperature", "Apparent temperature is the perceived feels-like temperature combining wind chill factor, relative humidity and solar radiation");
        HOURLY_PARAM_EXPLANATIONS.put("pressure_msl", "Atmospheric air pressure reduced to mean sea level (msl) or pressure at surface. Typically pressure on mean sea level is used in meteorology. Surface pressure gets lower with increasing elevation.");
        HOURLY_PARAM_EXPLANATIONS.put("surface_pressure", "Atmospheric air pressure reduced to mean sea level (msl) or pressure at surface. Typically pressure on mean sea level is used in meteorology. Surface pressure gets lower with increasing elevation.");
        HOURLY_PARAM_EXPLANATIONS.put("precipitation", "Total precipitation (rain, showers, snow) sum of the preceding hour. Data is stored with a 0.1 mm precision. If precipitation data is summed up to monthly sums, there might be small inconsistencies with the total precipitation amount.");
        HOURLY_PARAM_EXPLANATIONS.put("rain", "Only liquid precipitation of the preceding hour including local showers and rain from large scale systems.");
        HOURLY_PARAM_EXPLANATIONS.put("snowfall", "Snowfall amount of the preceding hour in centimeters. For the water equivalent in millimeter, divide by 7. E.g. 7 cm snow = 10 mm precipitation water equivalent");
        HOURLY_PARAM_EXPLANATIONS.put("cloud_cover", "Total cloud cover as an area fraction");
        HOURLY_PARAM_EXPLANATIONS.put("cloud_cover_low", "Low level clouds and fog up to 2 km altitude");
        HOURLY_PARAM_EXPLANATIONS.put("cloud_cover_mid", "Mid level clouds from 2 to 6 km altitude");
        HOURLY_PARAM_EXPLANATIONS.put("cloud_cover_high", "High level clouds from 6 km altitude");
        HOURLY_PARAM_EXPLANATIONS.put("shortwave_radiation", "Shortwave solar radiation as average of the preceding hour. This is equal to the total global horizontal irradiation");
        HOURLY_PARAM_EXPLANATIONS.put("direct_radiation", "Direct solar radiation as average of the preceding hour on the horizontal plane and the normal plane (perpendicular to the sun)");
        HOURLY_PARAM_EXPLANATIONS.put("direct_normal_irradiance", "Direct solar radiation as average of the preceding hour on the horizontal plane and the normal plane (perpendicular to the sun)");
        HOURLY_PARAM_EXPLANATIONS.put("diffuse_radiation", "Diffuse solar radiation as average of the preceding hour");
        HOURLY_PARAM_EXPLANATIONS.put("global_tilted_irradiance", "Total radiation received on a tilted pane as average of the preceding hour. The calculation is assuming a fixed albedo of 20% and in isotropic sky. Please specify tilt and azimuth parameter. Tilt ranges from 0° to 90° and is typically around 45°. Azimuth should be close to 0° (0° south, -90° east, 90° west). If azimuth is set to \"nan\", the calculation assumes a horizontal tracker. If tilt is set to \"nan\", it is assumed that the panel has a vertical tracker. If both are set to \"nan\", a bi-axial tracker is assumed.");
        HOURLY_PARAM_EXPLANATIONS.put("sunshine_duration", "Number of seconds of sunshine of the preceding hour per hour calculated by direct normalized irradiance exceeding 120 W/m², following the WMO definition.");
        HOURLY_PARAM_EXPLANATIONS.put("wind_speed_10m", "Wind speed at 10 or 100 meters above ground. Wind speed on 10 meters is the standard level.");
        HOURLY_PARAM_EXPLANATIONS.put("wind_speed_100m", "Wind speed at 10 or 100 meters above ground. Wind speed on 10 meters is the standard level.");
        HOURLY_PARAM_EXPLANATIONS.put("wind_direction_10m", "Wind direction at 10 or 100 meters above ground");
        HOURLY_PARAM_EXPLANATIONS.put("wind_direction_100m", "Wind direction at 10 or 100 meters above ground");
        HOURLY_PARAM_EXPLANATIONS.put("wind_gusts_10m", "Gusts at 10 meters above ground of the indicated hour. Wind gusts in CERRA are defined as the maximum wind gusts of the preceding hour. Please consult the ECMWF IFS documentation for more information on how wind gusts are parameterized in weather models.");
        HOURLY_PARAM_EXPLANATIONS.put("et0_fao_evapotranspiration", "ET0 Reference Evapotranspiration of a well watered grass field. Based on FAO-56 Penman-Monteith equations ET0 is calculated from temperature, wind speed, humidity and solar radiation. Unlimited soil water is assumed. ET0 is commonly used to estimate the required irrigation for plants.");
        HOURLY_PARAM_EXPLANATIONS.put("weather_code", "Weather condition as a numeric code. Follow WMO weather interpretation codes. See table below for details. Weather code is calculated from cloud cover analysis, precipitation and snowfall. As barely no information about atmospheric stability is available, estimation about thunderstorms is not possible.");
        HOURLY_PARAM_EXPLANATIONS.put("snow_depth", "Snow depth on the ground. Snow depth in ERA5-Land tends to be overestimated. As the spatial resolution for snow depth is limited, please use it with care.");
        HOURLY_PARAM_EXPLANATIONS.put("vapour_pressure_deficit", "Vapor Pressure Deificit (VPD) in kilopascal (kPa). For high VPD (>1.6), water transpiration of plants increases. For low VPD (<0.4), transpiration decreases");
        HOURLY_PARAM_EXPLANATIONS.put("soil_temperature_0_to_7cm", "Average temperature of different soil levels below ground.");
        HOURLY_PARAM_EXPLANATIONS.put("soil_temperature_7_to_28cm", "Average temperature of different soil levels below ground.");
        HOURLY_PARAM_EXPLANATIONS.put("soil_temperature_28_to_100cm", "Average temperature of different soil levels below ground.");
        HOURLY_PARAM_EXPLANATIONS.put("soil_temperature_100_to_255cm", "Average temperature of different soil levels below ground.");
        HOURLY_PARAM_EXPLANATIONS.put("soil_moisture_0_to_7cm", "Average soil water content as volumetric mixing ratio at 0-7, 7-28, 28-100 and 100-255 cm depths.");
        HOURLY_PARAM_EXPLANATIONS.put("soil_moisture_7_to_28cm", "Average soil water content as volumetric mixing ratio at 0-7, 7-28, 28-100 and 100-255 cm depths.");
        HOURLY_PARAM_EXPLANATIONS.put("soil_moisture_28_to_100cm", "Average soil water content as volumetric mixing ratio at 0-7, 7-28, 28-100 and 100-255 cm depths.");
        HOURLY_PARAM_EXPLANATIONS.put("soil_moisture_100_to_255cm", "Average soil water content as volumetric mixing ratio at 0-7, 7-28, 28-100 and 100-255 cm depths.");
    }

    public static String getArrayAsDelimetedString(String[] array){
        if (array == null || array.length == 0)
            return null;
        else {
            StringBuilder builder = new StringBuilder();
            for (String str : array){
                builder.append(str).append(",");
            }

            return builder.substring(0,builder.length()-1);
        }
    }
}
