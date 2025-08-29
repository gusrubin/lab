package com.gusrubin.legacysoap.legacysoap.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * @author Gustavo Rubin
 */
@XmlRootElement(name = "Localidade")
@XmlAccessorType(XmlAccessType.FIELD)
public class Localidade {
  private String cidade;
  private String estado;
  private String pais;

  public Localidade() {}

  public Localidade(String cidade, String estado, String pais) {
    this.cidade = cidade;
    this.estado = estado;
    this.pais = pais;
  }

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
