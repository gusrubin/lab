package com.gusrubin.lab.javafxwithspring.domain.systeminfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemInfo {

	private String operationSystemName;
	private String operationSystemVersion;
	private String jvmVersion;
	private String springBootVersion;

}
