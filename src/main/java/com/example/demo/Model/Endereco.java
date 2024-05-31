package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "logadouro", nullable = false)
    private String logadouro;

    @Column(name = "numero", nullable = false)
    private Double  numero;

    @Column(name = "cep", nullable = false)
    private Double cep;

    @ManyToMany
    @JoinTable(
        name = "pessoa_endereco",
        joinColumns = @JoinColumn(name = "endereco_id"),
        inverseJoinColumns = @JoinColumn(name = "pessoa_id")
    )
    private List<Pessoa> pessoas;

    @ManyToOne
    @JoinColumn(name = "bairro_id", nullable = false)
    private Bairro bairro;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogadouro() {
        return this.logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public Double getNumero() {
        return this.numero;
    }

    public void setNumero(Double numero) {
        this.numero = numero;
    }

    public Double getCep() {
        return this.cep;
    }

    public void setCep(Double cep) {
        this.cep = cep;
    }

    public List<Pessoa> getPessoa() {
        return getPessoa();
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

}