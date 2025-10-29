package com.gusrubin.lab.javafxwithspring.application.port.out;

/**
 * @author Gustavo Rubin
 */
public interface SystemInfoPort {

  String getOperationalSystemName();

  String getOperationalSystemVersion();

  String getJavaVersion();

  String getSpringBootVersion();
}
