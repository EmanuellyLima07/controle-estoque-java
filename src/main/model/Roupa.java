package main.model;

public class Roupa extends ProdutoBase{
    private String cor;
    private String tamanho;
    private String genero;
    private String material;
    private boolean lavavelNaMaquina;

    public Roupa(){
        super();
        setTipoProduto(TipoProduto.ROUPA);
    }

    public Roupa(int id, String nome, String cor, String tamanho, String genero, String marca,
                 String material, boolean lavavelNaMaquina, int quantidade, double preco){

        super(id, nome, marca, quantidade, preco, java.time.LocalDate.now(), TipoProduto.ROUPA);

        this.cor = cor;
        this.tamanho = tamanho;
        this.genero = genero;
        this.material = material;
        this.lavavelNaMaquina = lavavelNaMaquina;

    }

    public String getCor(){
        return cor;
    }

    public String getTamanho(){
        return tamanho;
    }

    public String getGenero(){
        return genero;
    }

    public String getMaterial(){
        return material;
    }

    public boolean isLavavelNaMaquina(){
        return lavavelNaMaquina;
    }



    public void setCor(String cor){
        this.cor = cor;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setGenero (String genero){
        this.genero = genero;
    }

    public void setMaterial (String material){
        this.material = material;
    }

    public void setLavavelNaMaquina(boolean lavavelNaMaquina){
        this.lavavelNaMaquina = lavavelNaMaquina;
    }



    @Override
    public String exibirInfo(){
        return "Produto: " + getNome() +
                "\n Cor: " + cor +
                "\n Tamanho: " + tamanho +
                "\n Gênero: " + genero +
                "\n Marca: " + getMarca() +
                "\n Material: " + material +
                "\n Lavável na Máquina: "  + (isLavavelNaMaquina() ? "Sim" : "Não") +
                "\n Preço: " + getPreco() +
                "\n Quantidade: " + getQuantidade();

    }


    @Override
    public double calcularValorFinal(){
        //imposto de 15%
        return getPreco() * 1.15;
    }
}