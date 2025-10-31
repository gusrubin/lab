package com.gusrubin.lab.javafxwithspring.application.service;

import com.gusrubin.lab.javafxwithspring.application.port.in.GetSystemInfoUseCase;
import com.gusrubin.lab.javafxwithspring.application.port.out.SystemInfoPort;
import com.gusrubin.lab.javafxwithspring.domain.systeminfo.SystemInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SystemInfoService implements GetSystemInfoUseCase {

  private final SystemInfoPort systemInfoPort;

  @Override
  public SystemInfo get() {
    return SystemInfo.builder()
        // @formatter:off
        .applicationVersion(systemInfoPort.getApplicationVersion())
        .springBootVersion(systemInfoPort.getSpringBootVersion())
        .jvmVersion(systemInfoPort.getJavaVersion())
        .javafxVersion(systemInfoPort.getJavaFxVersion())
        .operationSystemName(systemInfoPort.getOperationalSystemName())
        .operationSystemVersion(systemInfoPort.getOperationalSystemVersion())
        .build();
    // @formatter:on
  }
}
