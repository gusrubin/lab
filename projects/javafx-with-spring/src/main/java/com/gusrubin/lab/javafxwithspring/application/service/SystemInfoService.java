package com.gusrubin.lab.javafxwithspring.application.service;

import com.gusrubin.lab.javafxwithspring.application.port.in.GetSystemInfoUseCase;
import com.gusrubin.lab.javafxwithspring.application.port.out.SystemInfoPort;
import com.gusrubin.lab.javafxwithspring.domain.systeminfo.SystemInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SystemInfoService implements GetSystemInfoUseCase {

  private final SystemInfoPort systemInfoPort;

  @Override
  public SystemInfo get() {
    return SystemInfo.builder()
        // @formatter:off
        .operationSystemName(systemInfoPort.getOperationalSystemName())
        .operationSystemVersion(systemInfoPort.getOperationalSystemVersion())
        .jvmVersion(systemInfoPort.getJavaVersion())
        .springBootVersion(systemInfoPort.getSpringBootVersion())
        .build();
    // @formatter:on
  }
}
