package com.c8n.weatherservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class HttpUtil {
    private final ObjectMapper mapper;

    public HttpUtil(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public <T> Optional<T> getRequest(Class<? extends T> responseType, String url, Map<String, String> params){

        if (params != null && !params.isEmpty()){
            StringBuilder queryParams = new StringBuilder("?");

            for (Map.Entry<String, String> param : params.entrySet()){
                queryParams.append(param.getKey()).append("=").append(param.getValue()).append("&");
            }

            url = url + queryParams.substring(0,queryParams.length()-1);
        }

        try(HttpClient client = HttpClient.newBuilder().build()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header("accept", "application/json")
                    .timeout(Duration.of(10, ChronoUnit.SECONDS))
                    .GET()
                    .build();

            HttpResponse<String> response =client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200){
                return Optional.of(mapper.readValue(response.body(), responseType));
            } else
                return Optional.empty();

        } catch (URISyntaxException | IOException | InterruptedException e) {
            log.error(e.getMessage());
        }

        return Optional.empty();
    }
}
