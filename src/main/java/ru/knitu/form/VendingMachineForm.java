package ru.knitu.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendingMachineForm {

    @NotNull(message = "Поле обязательно")
    private long city;
    @NotNull(message = "Поле обязательно")
    private long typeOfLocation;
    @NotBlank(message = "Поле обязательно")
    private String address;
    private long university;
    @NotNull(message = "Поле обязательно")
    private int rentCoast;
    @NotNull(message = "Поле обязательно")
    private int coastForPrint;
    @NotNull(message = "Поле обязательно")
    private long owner;

}
