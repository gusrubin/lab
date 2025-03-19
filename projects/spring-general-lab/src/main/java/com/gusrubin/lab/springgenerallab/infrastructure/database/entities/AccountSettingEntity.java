package com.gusrubin.lab.springgenerallab.infrastructure.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "account_setting")
public class AccountSettingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_setting_id_sequence")
    @SequenceGenerator(name = "account_setting_id_sequence", sequenceName = "account_setting_id_sequence", allocationSize = 1)
    @Column(name = "id")
    Long id;

    @Column(name = "setting_name")
    String settingName;

    @Column(name = "setting_value")
    String settingValue;

    @ManyToOne
    @JoinColumn(name = "account_id")
    AccountEntity account;

}
