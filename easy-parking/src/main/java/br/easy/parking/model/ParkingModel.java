package br.easy.parking.model;

import kong.unirest.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkingModel {
    public String id;

    public String plate;

    public LocalDateTime startTime;

    public LocalDateTime endTime;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    public ParkingModel(JSONObject requestBodyJson) {
        id = requestBodyJson.getString("id");
        plate = requestBodyJson.getString("plate");
        startTime = LocalDateTime.parse(requestBodyJson.getString("startTime"), DATE_TIME_FORMATTER);
        endTime = LocalDateTime.parse(requestBodyJson.getString("endTime"), DATE_TIME_FORMATTER);
    }
}
