/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Pilo Tuy
 */
public class Pie {
    String titulo ;
    String ejex ;
    String valores ;
    
    public void Pie()
    {
        titulo = "";
        ejex = "";
        valores = "";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEjex() {
        return ejex;
    }

    public void setEjex(String ejex) {
        this.ejex = ejex;
    }

    public String getValores() {
        return valores;
    }

    public void setValores(String valores) {
        this.valores = valores;
    }
    
}
