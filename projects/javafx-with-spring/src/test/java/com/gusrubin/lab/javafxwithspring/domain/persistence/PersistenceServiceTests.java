package com.gusrubin.lab.javafxwithspring.domain.persistence;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.gusrubin.lab.javafxwithspring.application.port.out.PersistenceRepositoryPort;
import com.gusrubin.lab.javafxwithspring.application.service.PersistenceService;
import com.gusrubin.lab.javafxwithspring.domain.persistence.WordRecord.WordRecordCreateDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersistenceServiceTests {

  @Mock private PersistenceRepositoryPort persistenceRepositoryPort;

  @Spy @InjectMocks private PersistenceService persistenceService;

  @Test
  void shouldPostWordRecordSucessfully() {
    // Preconditions
    WordRecordCreateDto dto = new WordRecordCreateDto("TestWord");
    when(persistenceRepositoryPort.save(any(WordRecord.class))).thenReturn(any(WordRecord.class));

    // Test
    persistenceService.post(dto);

    // Validations
    verify(persistenceRepositoryPort, times(1)).save(any(WordRecord.class));
  }

  @Test
  void shouldFailWhenPostNullWordRecord() {
    // Test and Validations
    assertThrows(IllegalArgumentException.class, () -> persistenceService.post(null));
    verify(persistenceRepositoryPort, never()).save(any());
  }
}
