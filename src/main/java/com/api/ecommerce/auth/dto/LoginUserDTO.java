package com.api.ecommerce.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginUserDTO {
    @NotNull(message = "{user.email.notblank}")
    @NotBlank(message = "{user.email.notblank}")
    @Email(message = "{user.email.valid}")
    @Size(max = 255, message = "{user.email.size}")
    private String email;

    @NotNull(message = "{user.password.notblank}")
    @NotBlank(message = "{user.password.notblank}")
    @Size(min = 6, max = 255, message = "{user.password.size}")
    private String password;


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
}
