package model;
public class Procedimento {
    private String cod;
    private String descricao;
    private String tipo;


    public Procedimento(String cod, String descricao, String tipo){
        this.cod = cod;
        this.descricao = descricao;
        this.tipo = tipo;
    }
    //getters
    public String getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public String getTipo() {
        return tipo;
    }
    //setters
    public void setCod(String cod) {
        this.cod = cod;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void expandirAbreviacoes(){
        this.tipo = Colunas.getDescricao(this.tipo);
    }

}
