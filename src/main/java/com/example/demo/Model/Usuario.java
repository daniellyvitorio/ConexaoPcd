package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "usuario_nivel_acesso", joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "nivel_acesso_id")
        )
    private List<NivelAcesso > nivelAcesso;

   @OneToMany(mappedBy = "usuario")
   private List<Noticia> noticia;

   public Usuario(List<NivelAcesso> nivelAcesso, List<Noticia> noticia) {
    this.nivelAcesso = nivelAcesso;
    this.noticia = noticia;
}

@OneToMany(mappedBy = "usuario")
    private List<Acesso> acesso;

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
        return nivelAcesso;
    }

    public void setNivelAcesso(List<NivelAcesso> nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public List<Noticia> getNoticia() {
        return noticia;
    }

    public void setNoticia(List<Noticia> noticia) {
        this.noticia = noticia;
    }

    public List<Acesso> getAcesso() {
        return acesso;
    }

    public void setAcesso(List<Acesso> acesso) {
        this.acesso = acesso;
    }

    
}
