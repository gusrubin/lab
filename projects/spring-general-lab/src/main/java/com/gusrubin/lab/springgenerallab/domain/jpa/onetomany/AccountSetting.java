package com.gusrubin.lab.springgenerallab.domain.jpa.onetomany;

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
public class AccountSetting {

    Long id;
    String settingName;
    String settingValue;

}
