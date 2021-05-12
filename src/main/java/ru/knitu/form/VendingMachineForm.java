package ru.knitu.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import ru.knitu.model.TypeOfLocation;
import ru.knitu.model.University;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendingMachineForm {


    private long city;
    private long typeOfLocation;
    private String address;
    private long university;
    private int rentCoast;
    private int coastForPrint;


}
