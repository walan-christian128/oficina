
 package br.com.oficina.model;

/**
 *
 * @author Walan
 */
public class intesOS {

    private int id_item;
    private Produtos produto;
    private int qtd_os;
    private OS os;  

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public int getQtd_os() {
        return qtd_os;
    }

    public void setQtd_os(int qtd_os) {
        this.qtd_os = qtd_os;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

}
