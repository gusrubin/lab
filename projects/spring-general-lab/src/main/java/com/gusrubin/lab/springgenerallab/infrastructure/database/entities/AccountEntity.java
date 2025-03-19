package com.gusrubin.lab.springgenerallab.infrastructure.database.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Entity(name = "account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_sequence")
    @SequenceGenerator(name = "account_id_sequence", sequenceName = "account_id_sequence", allocationSize = 1)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "email")
    String email;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<AccountSettingEntity> accountSettingEntities;

}
