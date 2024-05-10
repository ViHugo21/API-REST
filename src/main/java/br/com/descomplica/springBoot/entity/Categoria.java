package br.com.descomplica.springBoot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "categoria_id")
    private String id;

    @Column(name = "categoria_nome")
    private String nome;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY) // Uma categoria pode ter vários produtos
    @JsonIgnore
    private List<Produto> produtos = new ArrayList<>();

    // Métodos
    public Categoria() {
    }

    public Categoria(String id, String nome, List<Produto> produtos) {
        this.id = id;
        this.nome = nome;
        this.produtos = produtos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
