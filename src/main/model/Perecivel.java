package main.model;

import java.time.LocalDate;

public class Perecivel extends ProdutoBase{
    private LocalDate dtFabricacao;
    private LocalDate dtValidade;
    private String categoria;
    private String embalagem;
    private String origem;

    public Perecivel(){
        super();
        setTipoProduto(TipoProduto.PERECIVEL);
    }

    public Perecivel(int id, String nome, String marca, String categoria, String embalagem, String origem, double preco,
                     int quantidade, LocalDate dtFabricacao, LocalDate dtValidade){
        super(id, nome, marca, quantidade,preco, java.time.LocalDate.now(), TipoProduto.PERECIVEL);

        this.categoria = categoria;
        this.embalagem = embalagem;
        this.origem = origem;
        this.dtFabricacao = dtFabricacao;
        this.dtValidade = dtValidade;
    }

    public String getCategoria(){
        return categoria;
    }

    public String getEmbalagem(){
        return embalagem;
    }

    public String getOrigem(){
        return origem;
    }

    public LocalDate getDtFabricacao(){
        return dtFabricacao;
    }

    public LocalDate getDtValidade(){
        return dtValidade;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setEmbalagem(String embalagem){
        this.embalagem = embalagem;
    }

    public void setOrigem(String origem){
        this.origem = origem;
    }


    public void setDtFabricacao(String data) {
        try {
            this.dtFabricacao = LocalDate.parse(data);
        } catch (Exception e) {
            throw new ExcecaoDataInvalida("Data de fabricação inválida!");
        }
    }

    public void setDtValidade(String data) {
        try {
            this.dtValidade = LocalDate.parse(data);
        } catch (Exception e) {
            throw new ExcecaoDataInvalida("Data de validade inválida!");
        }
    }


    public boolean estaVencido(){
        return LocalDate.now().isAfter(dtValidade);
    }

    @Override
    public String exibirInfo(){
        return "Produto: " + getNome() +
                "\n Marca: "+ getMarca() +
                "\n Categoria: "+ categoria +
                "\n Embalagem: " + embalagem +
                "\n Origem: "+ origem +
                "\n Preço: " + getPreco() +
                "\n Quantidade: " + getQuantidade() +
                "\n Data de Fabricação: " + dtFabricacao +
                "\n Data de Validade: " + dtValidade;
    }

    @Override
    public double calcularValorFinal() {
        // imposto de 15%
        return getPreco() * 1.15;
    }


}