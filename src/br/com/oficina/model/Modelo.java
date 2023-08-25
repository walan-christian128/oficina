package br.com.oficina.model;

public class Modelo {

    private int id;
    private String descricacao;
    private String potencia;
    private String fabricante;
    private String ano;

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricacao() {
        return descricacao;
    }

    public void setDescricacao(String descricacao) {
        this.descricacao = descricacao;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    @Override
    public String toString(){
      return this.getDescricacao() + this.getAno();
     
    }
    
}
