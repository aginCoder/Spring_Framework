package com.vti.kshop.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class CarCreateForm {
    @NotBlank(message = "Car license plate must not be blank")
    @Length(max = 10, message = "Car license plate has max 10 characters")
    private String licensePlate;

    @NotNull(message = "Car repair date must not be null")
    @PastOrPresent(message = "Car repair date must be past or present")
    private LocalDate repairDate;

    @NotBlank(message = "Car customer name must not be blank")
    @Length(max = 50, message = "Car customer name has max 50 characters")
    private String customerName;

    @NotBlank(message = "Car catalog must not be blank")
    @Length(max = 50, message = "Car catalog has max 50 characters")
    private String catalog;

    @NotBlank(message = "Car maker must not be blank")
    @Length(max = 50, message = "Car maker has max 50 characters")
    private String carMaker;
}
