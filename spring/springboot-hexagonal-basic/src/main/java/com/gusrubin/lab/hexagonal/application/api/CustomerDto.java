package com.gusrubin.lab.hexagonal.application.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
 * @author Gustavo Rubin
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	private String name;
	private String email;

}
