package com.gusrubin.lab.javafxwithspring.domain.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WordRecord {

	private Long id;
	private String word;

}
