package org.soulcodeacademy.empresa.domain;

import javax.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEndereço;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String uf;

    public Endereco() {}

    public Endereco(Integer idEndereço, String cidade, String uf) {
        this.idEndereço = idEndereço;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Integer getIdEndereco() {
        return idEndereço;
    }

    public void setIdEndereco(Integer idEndereço) {
        this.idEndereço = idEndereço;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
