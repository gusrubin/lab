package com.gusrubin.lab.springgenerallab.domain.jpa.onetomany;

import java.util.List;

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
public class Account {

    Long id;
    String name;
    String email;
    List<AccountSetting> accountSettings;

}
