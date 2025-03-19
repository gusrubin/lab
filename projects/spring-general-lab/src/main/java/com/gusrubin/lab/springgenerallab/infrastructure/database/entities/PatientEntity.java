package com.gusrubin.lab.springgenerallab.infrastructure.database.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Entity(name = "patient")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_id_sequence")
    @SequenceGenerator(name = "patient_id_sequence", sequenceName = "patient_id_sequence", allocationSize = 1)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

//    @OneToOne
//    @JoinColumn(name = "medical_record_id")
    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    MedicalRecordEntity medicalRecordEntity;

}
