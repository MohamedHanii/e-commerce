package com.api.ecommerce.auth.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateUserDTO {

    @NotNull(message = "{user.email.notblank}")
    @NotBlank(message = "{user.email.notblank}")
    @Max(value = 255,message = "{user.email.size}")
    private String email;

    @NotNull(message = "{user.password.notblank}")
    @NotBlank(message = "{user.password.notblank}")
    @Min(value = 6,message = "{user.password.size}")
    @Max(value = 255,message = "{user.password.size}")
    private String password;

    @NotNull(message = "{user.first_name.notblank}")
    @NotBlank(message = "{user.first_name.notblank}")
    @Min(value = 2,message = "{user.first_name.size}")
    @Max(value = 255,message = "{user.first_name.size}")
    private String firstName;

    @NotNull(message = "{user.last_name.notblank}")
    @NotBlank(message = "{user.last_name.notblank}")
    @Min(value = 2,message = "{user.last_name.size}")
    @Max(value = 255,message = "{user.last_name.size}")
    private String lastName;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
