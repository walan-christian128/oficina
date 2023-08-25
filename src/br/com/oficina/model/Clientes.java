
package br.com.oficina.model;

public class Clientes {
 
    private int idcli;
    private String nomecli;
    private String endereco;
    private String fonecli;
    private String emailcli;

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public String getNomecli() {
        return nomecli;
    }

    public void setNomecli(String nomecli) {
        this.nomecli = nomecli;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFonecli() {
        return fonecli;
    }

    public void setFonecli(String fonecli) {
        this.fonecli = fonecli;
    }

    public String getEmailcli() {
        return emailcli;
    }

    public void setEmailcli(String emailcli) {
        this.emailcli = emailcli;
    }
    @Override
    public String toString(){
     return this.getNomecli();
    
    
    }
    
}
