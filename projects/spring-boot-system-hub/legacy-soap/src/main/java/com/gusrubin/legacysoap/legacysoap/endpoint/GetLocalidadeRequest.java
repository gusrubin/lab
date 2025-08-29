package com.gusrubin.legacysoap.legacysoap.endpoint;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * @author Gustavo Rubin
 */
@XmlRootElement(name = "getLocalidadeRequest", namespace = "http://example.com/localidade")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetLocalidadeRequest {
  private String nomeCidade;

  // getters e setters
  public String getNomeCidade() {
    return nomeCidade;
  }

  public void setNomeCidade(String nomeCidade) {
    this.nomeCidade = nomeCidade;
  }
}
