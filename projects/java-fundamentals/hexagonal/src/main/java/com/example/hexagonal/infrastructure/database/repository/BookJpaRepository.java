package com.example.hexagonal.infrastructure.database.repository;

import com.example.hexagonal.infrastructure.database.entity.BookEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gustavo Rubin
 */public interface BookJpaRepository extends JpaRepository<BookEntity, UUID> {
}
