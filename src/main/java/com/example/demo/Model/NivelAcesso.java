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
@Table(name = "nivel_acesso")
public class NivelAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name= "tipo", nullable = false, length = 100)
    private String tipo;
    
    @ManyToMany(mappedBy = "nivelAcesso")
    private List<Usuario> usuarios;

    public Long getId() {
    return this.id;
    }

    public void setId(Long id) {
    this.id = id;
    }

    public String getTipo() {
    return this.tipo;
    }

    public void setTipo(String tipo) {
    this.tipo = tipo;
    }

    public List<Usuario> getUsuarios() {
    return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
    }

}
