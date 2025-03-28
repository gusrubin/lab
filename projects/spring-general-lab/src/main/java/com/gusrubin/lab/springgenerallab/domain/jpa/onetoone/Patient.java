package com.gusrubin.lab.springgenerallab.domain.jpa.onetoone;

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
public class Patient {
    
    Long id;
    String name;
    MedicalRecord medicalRecord;

}
