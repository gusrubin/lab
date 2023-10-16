package com.gusrubin.lab.javafxwithspring.domain.systeminfo;

import org.springframework.boot.SpringBootVersion;

public class SystemInfoService implements GetSystemInfoUseCase {

	@Override
	public SystemInfo get() {
		return SystemInfo.builder()
		// @formatter:off
				.operationSystemName(System.getProperty("os.name"))
				.operationSystemVersion(System.getProperty("os.version"))
				.jvmVersion(System.getProperty("java.version"))
				.springBootVersion(SpringBootVersion.getVersion())
				.build();
		// @formatter:on
	}

}
