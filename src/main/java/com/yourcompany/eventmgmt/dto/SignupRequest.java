package com.yourcompany.eventmgmt.dto;

import jakarta.validation.constraints.*;

public class SignupRequest {
    @NotBlank private String username;
    @Min(1) private Integer userage;
    @Email @NotBlank private String email;
    @Size(min = 6) private String password;
    @Size(min = 6) private String confirmPassword;

    // getters/setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public Integer getUserage() { return userage; }
    public void setUserage(Integer userage) { this.userage = userage; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
}
