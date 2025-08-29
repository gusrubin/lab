package com.gusrubin.legacysoap.legacysoap.endpoint;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * @author Gustavo Rubin
 */
@XmlRootElement(name = "getLocalidadeResponse", namespace = "http://example.com/localidade")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetLocalidadeResponse {
  private String cidade;
  private String estado;
  private String pais;

  // getters e setters
  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }
}
