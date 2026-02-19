package com.c_code.bate_ponto.dto.request;

import java.time.LocalDateTime;

public class RegisterManualRequest {
    private LocalDateTime dataTime;
    private String type;
    private String observation;

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public void setDataTime(LocalDateTime dataTime) {
        this.dataTime = dataTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
