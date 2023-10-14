/**
 * 
 */
package com.gusrubin.lab.springgenerallab.infrastructure.database.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gusrubin.lab.springgenerallab.infrastructure.database.entities.PageableResourceEntity;

/**
 * @author Gustavo Rubin
 *
 */
public interface PageableResourceRepository extends JpaRepository<PageableResourceEntity, Long> {

    Optional<PageableResourceEntity> findByText(String text);

}
