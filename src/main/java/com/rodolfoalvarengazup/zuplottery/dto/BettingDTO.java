package com.rodolfoalvarengazup.zuplottery.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class BettingDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private List<Integer> numbers;
    private Instant createdAt;

    public BettingDTO() {
    }

    public BettingDTO(Long id, String email, List<Integer> numbers, Instant createdAt) {
        this.id = id;
        this.email = email;
        this.numbers = numbers;
        this.createdAt = createdAt;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BettingDTO)) return false;
        BettingDTO that = (BettingDTO) o;
        return getId().equals(that.getId()) && getEmail().equals(that.getEmail()) && getNumbers().equals(that.getNumbers()) && getCreatedAt().equals(that.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getNumbers(), getCreatedAt());
    }
}
