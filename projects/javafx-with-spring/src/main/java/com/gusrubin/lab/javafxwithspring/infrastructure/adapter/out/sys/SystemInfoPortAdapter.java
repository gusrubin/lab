package com.gusrubin.lab.javafxwithspring.infrastructure.adapter.out.sys;

import com.gusrubin.lab.javafxwithspring.application.port.out.SystemInfoPort;
import org.springframework.boot.SpringBootVersion;
import org.springframework.stereotype.Component;

/**
 * @author Gustavo Rubin
 */
@Component
public class SystemInfoPortAdapter implements SystemInfoPort {

  @Override
  public String getOperationalSystemName() {
    return System.getProperty("os.name");
  }

  @Override
  public String getOperationalSystemVersion() {
    return System.getProperty("os.version");
  }

  @Override
  public String getJavaVersion() {
    return System.getProperty("java.version");
  }

  @Override
  public String getSpringBootVersion() {
    return SpringBootVersion.getVersion();
  }
}
