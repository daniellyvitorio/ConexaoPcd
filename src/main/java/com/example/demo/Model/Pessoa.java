package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "nome", nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "pessoas")
    private List<Deficiencia> deficiencia;

    @ManyToMany(mappedBy = "pessoas")
    private List<Endereco> endereco;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Deficiencia> getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(List<Deficiencia> deficiencia) {
        this.deficiencia = deficiencia;
    }
}
