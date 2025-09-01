package com.yourcompany.eventmgmt.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Instant;

@Entity
@Table(name = "events")
public class Event {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable=false)
    private String type; // SHADI, BIRTHDAY, ANNIVERSARY, PARTY, OTHER

    private String primaryName;
    private String secondaryName;
    private BigDecimal budget;
    private Integer totalPerson;
    private LocalDate eventDate;
    private String location;

    private Instant createdAt = Instant.now();

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getPrimaryName() { return primaryName; }
    public void setPrimaryName(String primaryName) { this.primaryName = primaryName; }

    public String getSecondaryName() { return secondaryName; }
    public void setSecondaryName(String secondaryName) { this.secondaryName = secondaryName; }

    public BigDecimal getBudget() { return budget; }
    public void setBudget(BigDecimal budget) { this.budget = budget; }

    public Integer getTotalPerson() { return totalPerson; }
    public void setTotalPerson(Integer totalPerson) { this.totalPerson = totalPerson; }

    public LocalDate getEventDate() { return eventDate; }
    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
