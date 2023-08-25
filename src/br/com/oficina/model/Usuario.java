
package br.com.oficina.model;


public class Usuario {
      private int iduser;
      private String nomeuser;
      private double foneuser;
      private String loginuser;
      private String passworduser;
      private String perfiluser;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNomeuser() {
        return nomeuser;
    }

    public void setNomeuser(String nomeuser) {
        this.nomeuser = nomeuser;
    }

    public double getFoneuser() {
        return foneuser;
    }

    public void setFoneuser(double foneuser) {
        this.foneuser = foneuser;
    }

    public String getLoginuser() {
        return loginuser;
    }

    public void setLoginuser(String loginuser) {
        this.loginuser = loginuser;
    }

    public String getPassworduser() {
        return passworduser;
    }

    public void setPassworduser(String passworduser) {
        this.passworduser = passworduser;
    }

    public String getPerfiluser() {
        return perfiluser;
    }

    public void setPerfiluser(String perfiluser) {
        this.perfiluser = perfiluser;
    }
    @Override
    public String toString(){
     return this.getPerfiluser();
    
    }
}
