package main.model;

import java.time.LocalDate;
import java.util.Objects;


public abstract class ProdutoBase {
    private int id;
    private String nome;
    private String marca;
    private int quantidade;
    private double preco;
    private LocalDate dataCadastro;
    private TipoProduto tipoProduto; // enum

    public ProdutoBase(){
        this.dataCadastro = LocalDate.now();
        this.nome = "Sem nome";
        this.marca = "Sem marca";
        this.quantidade = 0;
        this.preco = 0;
        this.tipoProduto = null;
    }

    public ProdutoBase(int id, String nome, String marca, int quantidade,
                       double preco, LocalDate dataCadastro, TipoProduto tipoProduto) {

        this.id = id;
        this.nome = Objects.requireNonNull(nome, "Nome não pode ser nulo.");
        this.marca = Objects.requireNonNull(marca, "Marca não pode ser nula.");
        setQuantidade(quantidade);
        setPreco(preco);

        this.dataCadastro = (dataCadastro == null) ? LocalDate.now() : dataCadastro;
        this.tipoProduto = Objects.requireNonNull(tipoProduto, "Tipo Produto não pode ser nulo.");
    }


    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getMarca(){
        return marca;
    }

    public double getPreco(){
        return preco;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public LocalDate getDataCadastro(){
        return dataCadastro;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }



    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = Objects.requireNonNull(nome, "Nome não pode ser nulo");
    }

    public void setMarca(String marca) {
        this.marca = Objects.requireNonNull(marca, "Marca não pode ser nula.");
    }

    public void setPreco(double preco){
        if (preco < 0){
            throw new IllegalArgumentException("Preço não pode ser negativo.");
        }
        this.preco = preco;
    }

    public void setQuantidade(int quantidade){
        if (quantidade < 0){
            throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        }
        this.quantidade = quantidade;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = (dataCadastro == null) ? LocalDate.now() : dataCadastro;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = Objects.requireNonNull(tipoProduto,
                "Tipo Produto não pode ser nulo.");
    }

    public abstract String exibirInfo();
    public abstract double calcularValorFinal();


    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "\n Id: " + id +
                "\n Nome: " + nome +
                "\n Marca: " + marca +
                "\n Quantidade: " + quantidade +
                "\n Preço: " + preco +
                "\n Data Cadastro: " + dataCadastro +
                "\n Tipo Produto: " + tipoProduto +
                " }";
    }

}
