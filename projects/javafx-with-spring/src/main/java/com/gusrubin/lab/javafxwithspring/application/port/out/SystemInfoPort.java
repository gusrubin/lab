package com.gusrubin.lab.javafxwithspring.application.port.out;

/**
 * @author Gustavo Rubin
 */
public interface SystemInfoPort {

  String getApplicationVersion();

  String getSpringBootVersion();

  String getJavaFxVersion();

  String getJavaVersion();

  String getOperationalSystemName();

  String getOperationalSystemVersion();
}
