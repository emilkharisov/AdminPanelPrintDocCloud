package ru.knitu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type_of_location")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TypeOfLocation {

    @Id
    private Long id;

    private String type;

}
