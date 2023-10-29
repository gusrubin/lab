package com.gusrubin.lab.javafxwithspring.domain.persistence;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersistenceServiceTests {

    @Mock
    private PersistenceRepositoryPort persistenceRepositoryPort;

    @Spy
    @InjectMocks
    private PersistenceService persistenceService;

    @Test
    void shouldPostWordRecordSucessfully() {
	// Preconditions
	WordRecord wordRecord = new WordRecord();
	wordRecord.setWord("TestWord");

	when(persistenceRepositoryPort.save(wordRecord)).thenReturn(wordRecord);

	// Test
	WordRecord result = persistenceService.post(wordRecord);

	// Validations
	verify(persistenceRepositoryPort, times(1)).save(any(WordRecord.class));
	assertNotNull(result);
	assertEquals("TestWord", result.getWord());
    }

    @Test
    void shouldFailWhenPostNullWordRecord() {
	// Test and Validations
	assertThrows(IllegalArgumentException.class, () -> persistenceService.post(null));
	verify(persistenceRepositoryPort, never()).save(any());
    }

    @Test
    void shouldFailWhenPostBlankWord() {
	// Preconditions
	WordRecord wordRecord = new WordRecord();

	// Test and Validations
	assertThrows(IllegalArgumentException.class, () -> persistenceService.post(wordRecord));
	verify(persistenceRepositoryPort, never()).save(any());
    }

}
