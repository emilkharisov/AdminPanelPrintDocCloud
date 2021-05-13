package ru.knitu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "selling")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Selling {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vending_machine_id")
    private VendingMachine vendingMachine;

    private LocalDateTime time;
    private Integer countOfPaper;
    private Long sum;

}
