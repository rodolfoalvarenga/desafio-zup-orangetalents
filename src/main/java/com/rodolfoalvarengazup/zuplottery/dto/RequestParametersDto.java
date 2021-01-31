package com.rodolfoalvarengazup.zuplottery.dto;

import java.util.Objects;

public class RequestParametersDto {
    private String email;

    public RequestParametersDto() {
    }

    public RequestParametersDto(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestParametersDto)) return false;
        RequestParametersDto that = (RequestParametersDto) o;
        return getEmail().equals(that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }
}
