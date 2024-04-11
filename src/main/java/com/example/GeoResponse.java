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
public class GeoResponse {

    @JsonProperty("location_type")
    private String location_type;

    @JsonProperty("types")
    private String types;

    @JsonProperty("gaddress")
    private String gaddress;

    @JsonProperty("lang")
    private String lang;

    @JsonProperty("lat")
    private String lat;
}
