package com.rodolfoalvarengazup.zuplottery.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_betting")
public class Betting implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String numbers;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    public Betting() {
    }

    public Betting(Long id, String email, String numbers, Instant createdAt) {
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

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Betting)) return false;
        Betting betting = (Betting) o;
        return getId().equals(betting.getId()) && getEmail().equals(betting.getEmail()) && getNumbers().equals(betting.getNumbers()) && getCreatedAt().equals(betting.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getNumbers(), getCreatedAt());
    }
}
