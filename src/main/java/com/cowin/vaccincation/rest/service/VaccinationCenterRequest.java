package com.cowin.vaccincation.rest.service;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.lang.NonNull;

import java.util.Date;

@JsonComponent
public class VaccinationCenterRequest {
    @JsonProperty(value="pinCode")
    @NonNull
    @NotBlank(message="pinCode cannot be blank")
    private String pinCode;

    @JsonProperty(value="date")
    @NonNull
    @NotBlank(message="date cannot be blank")
    private String date;


    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "VaccinationCenterRequest{" +
                "pinCode='" + pinCode + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
