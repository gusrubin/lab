package com.gusrubin.lab.springgenerallab.infrastructure.database.entities;

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
@Entity(name = "medical_record")
public class MedicalRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medical_record_id_sequence")
    @SequenceGenerator(name = "medical_record_id_sequence", sequenceName = "medical_record_id_sequence", allocationSize = 1)
    @Column(name = "id")
    Long id;

    @Column(name = "description_of_last_visit")
    String descriptionOfLastVisit;
    
    @OneToOne
    @JoinColumn(name = "patient_id")
    PatientEntity patient;

}
