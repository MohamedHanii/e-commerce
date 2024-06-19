package com.api.ecommerce.auth.dto;

import jakarta.validation.constraints.*;

public class CreateUserDTO {

    @NotNull(message = "{user.email.notblank}")
    @NotBlank(message = "{user.email.notblank}")
    @Email(message = "{user.email.valid}")
    @Size(max = 255, message = "{user.email.size}")
    private String email;

    @NotNull(message = "{user.password.notblank}")
    @NotBlank(message = "{user.password.notblank}")
    @Size(min = 6, max = 255, message = "{user.password.size}")
    private String password;

    @NotNull(message = "{user.first_name.notblank}")
    @NotBlank(message = "{user.first_name.notblank}")
    @Size(min = 2, max = 255, message = "{user.first_name.size}")
    private String firstName;

    @NotNull(message = "{user.last_name.notblank}")
    @NotBlank(message = "{user.last_name.notblank}")
    @Size(min = 2, max = 255, message = "{user.last_name.size}")
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
