package com.gusrubin.legacysoap.legacysoap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * @author Gustavo Rubin
 */
@EnableWs
@Configuration
public class WebServiceConfig {

  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
      ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean<>(servlet, "/ws/*");
  }

  @Bean(name = "localidades")
  public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema localidadeSchema) {
    DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
    definition.setPortTypeName("LocalidadePort");
    definition.setLocationUri("/ws");
    definition.setTargetNamespace("http://example.com/localidade");
    definition.setSchema(localidadeSchema);
    return definition;
  }

  @Bean
  public XsdSchema localidadeSchema() {
    return new SimpleXsdSchema(new ClassPathResource("localidade.xsd"));
  }
}
