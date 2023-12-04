package com.gusrubin.lab.springgenerallab.infrastructure.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Gustavo Rubin
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_sequence")
    @SequenceGenerator(name = "person_id_sequence", sequenceName = "person_id_sequence", allocationSize = 1)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "age")
    Integer age;

}
