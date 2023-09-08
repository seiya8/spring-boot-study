package com.example.addressapp.form;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class CustomerForm {
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String phoneNumber;
}
