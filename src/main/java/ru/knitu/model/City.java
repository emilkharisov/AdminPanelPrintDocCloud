package ru.knitu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city_list")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class City {

    @Id
    private Long id;
    private String city;

}
