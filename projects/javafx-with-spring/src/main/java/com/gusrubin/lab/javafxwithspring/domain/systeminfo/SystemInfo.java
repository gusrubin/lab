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

  private String applicationVersion;
  private String springBootVersion;
  private String javafxVersion;
  private String jvmVersion;
  private String operationSystemName;
  private String operationSystemVersion;
}
