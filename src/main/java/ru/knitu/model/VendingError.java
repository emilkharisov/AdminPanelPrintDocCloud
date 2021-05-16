package ru.knitu.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "vending_error")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendingError {

    @Id
    private Long id;

    private String typeOfError;
    private String errorMessage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vending_machine_id")
    private VendingMachine vendingMachine;

}
