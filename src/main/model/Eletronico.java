package main.model;

public class Eletronico extends ProdutoBase {
    private int garantiaMeses;
    private String modelo;

    public Eletronico(){
        super();
        setTipoProduto(TipoProduto.ELETRONICO);
    }

    public Eletronico(int id, String nome, String marca, String modelo, int garantiaMeses, int quantidade, double preco) {
        super(id, nome, marca, quantidade, preco, java.time.LocalDate.now(), TipoProduto.ELETRONICO);

        this.garantiaMeses = garantiaMeses;
        this.modelo = modelo;
    }


    public int getGarantiaMeses(){
        return garantiaMeses;
    }

    public String getModelo(){
        return modelo;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String exibirInfo(){
        return "Produto: " + getNome() +
                "\n Marca: "+ getMarca() +
                "\n Modelo: " + modelo +
                "\n Garantia (meses) : " + garantiaMeses +
                "\n Quantidade: " + getQuantidade() +
                "\n Preço: " + getPreco();

    }

    @Override
    public double calcularValorFinal(){
        //imposto de 15%
        return getPreco() * 1.15;
    }

}