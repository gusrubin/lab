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
public class MedicalRecord {

    Long id;
    String descriptionOfLastVisit;

}
