package br.com.descomplica.springBoot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "produto_id")
    private String id;

    @Column(name = "codigo_barras_produto")
    private String codigoBarras;

    @Column(name = "nome_produto")
    private String nome;


    @Column(name = "preco_produto")
    private double preco;

    @ManyToOne(cascade = CascadeType.ALL) // alterações realizadas em Produto são refletivas em Categoria
    @JoinColumn(name = "categoria_id") // foreign key
    private Categoria categoria;

    // Métodos

    public Produto() {}

    public Produto(String id, String codigoBarras, String nome, double preco, Categoria categoria) {
        this.id = id;
        this.codigoBarras = codigoBarras;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
