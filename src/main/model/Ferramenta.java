package main.model;

public class Ferramenta extends ProdutoBase{
    private String tipo;
    private boolean eletrica;
    private int potencia;
    private String categoria;
    private String material;
    private double peso;
    private double comprimento;


    public Ferramenta(){
        super();
        setTipoProduto(TipoProduto.FERRAMENTA);
    }

    public Ferramenta(int id, String nome, String marca, String tipo, boolean eletrica, int potencia, String categoria, String material, double peso,
                      double comprimento, int quantidade, double preco){
        super(id, nome, marca, quantidade, preco, java.time.LocalDate.now(), TipoProduto.FERRAMENTA);

        this.tipo = tipo;
        this.eletrica = eletrica;
        this.potencia = potencia;
        this.categoria = categoria;
        this.material = material;
        this.peso = peso;
        this.comprimento = comprimento;

    }

    public String getTipo(){
        return tipo;
    }

    public boolean isEletrica() {
        return eletrica;
    }

    public int getPotencia() {
        return potencia;
    }

    public String getCategoria(){
        return categoria;
    }

    public String getMaterial(){
        return material;
    }

    public double getPeso(){
        return peso;
    }

    public double getComprimento(){
        return comprimento;
    }



    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setEletrica(boolean eletrica) {
        this.eletrica = eletrica;

        if (!eletrica) {
            this.potencia = 0;
        }
    }


    public void setPotencia(int potencia) {
        if (!this.eletrica) {
            this.potencia = 0;
            return;
        }

        if (potencia < 0) {
            throw new IllegalArgumentException("Potência não pode ser negativa.");
        }

        this.potencia = potencia;
    }


    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public void setComprimento(double comprimento){
        this.comprimento = comprimento;
    }


    @Override
    public String exibirInfo(){
        return "Produto: " + getNome() +
                "\n Marca: " + getMarca() +
                "\n Tipo: " + tipo +
                "\n Elétrica: " + (isEletrica() ? "Sim \n Potência: " + getPotencia() + "W" : "Não")+
                "\n Categoria: "+ categoria +
                "\n Material: " + material +
                "\n Peso: " + peso +
                "\n Comprimento: " + comprimento +
                "\n Preço: " + getPreco() +
                "\n Quantidade: " + getQuantidade();
    }

    @Override
    public double calcularValorFinal(){
        //imposto de 15%
        return getPreco() * 1.15;
    }

}