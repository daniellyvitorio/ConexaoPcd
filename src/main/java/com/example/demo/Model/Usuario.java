package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "senha", nullable = false, length = 256)
    private String senha;

    @ManyToMany /*n para n */
    private List<NivelAcesso > nivelAcesso;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<NivelAcesso> getNivelAcesso() {
        return this.nivelAcesso;
    }

    public void setNivelAcesso(List<NivelAcesso> nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    
}
