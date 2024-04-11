package com.example;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoTaggingTvsResponse {

    @JsonProperty("statusCode")
    private String statusCode;

    @JsonProperty("oLocation")
    private Location location;

    @JsonProperty("sApproximateAddress")
    private String approximateAddress;

    @JsonProperty("sError")
    private String error;

    @JsonProperty("data")
    private GeoResponse data;

    @JsonProperty("statusMessage")
    private String statusMessage;
}
