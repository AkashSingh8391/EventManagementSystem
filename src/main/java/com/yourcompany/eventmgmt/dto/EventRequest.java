package com.yourcompany.eventmgmt.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class EventRequest {
    @NotBlank private String type; // SHADI, BIRTHDAY, ANNIVERSARY, PARTY, OTHER
    @NotNull private Long userId;
    private String primaryName;
    private String secondaryName;
    @DecimalMin("0.0") private BigDecimal budget;
    @Min(1) private Integer totalPerson;
    @NotBlank private String eventDate; // yyyy-MM-dd (sent from browser)
    @NotBlank private String location;

    // getters / setters
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getPrimaryName() { return primaryName; }
    public void setPrimaryName(String primaryName) { this.primaryName = primaryName; }
    public String getSecondaryName() { return secondaryName; }
    public void setSecondaryName(String secondaryName) { this.secondaryName = secondaryName; }
    public BigDecimal getBudget() { return budget; }
    public void setBudget(BigDecimal budget) { this.budget = budget; }
    public Integer getTotalPerson() { return totalPerson; }
    public void setTotalPerson(Integer totalPerson) { this.totalPerson = totalPerson; }
    public String getEventDate() { return eventDate; }
    public void setEventDate(String eventDate) { this.eventDate = eventDate; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
