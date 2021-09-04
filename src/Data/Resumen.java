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
public class Resumen {
    private String Proyecto ;
    private String archivo;
    private int t_variables ;
    private int t_clases ;
    private int t_metodos ;
    private int t_comentarios; 
    
    public void Resumen(){
        Proyecto ="";
        archivo = "";
        t_variables = 0;
        t_clases = 0;
        t_metodos = 0;
        t_comentarios =0;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    
    public String getProyecto() {
        return Proyecto;
    }

    public void setProyecto(String Proyecto) {
        this.Proyecto = Proyecto;
    }

    public int getT_variables() {
        return t_variables;
    }

    public void setT_variables(int t_variables) {
        this.t_variables = t_variables;
    }

    public int getT_clases() {
        return t_clases;
    }

    public void setT_clases(int t_clases) {
        this.t_clases = t_clases;
    }

    public int getT_metodos() {
        return t_metodos;
    }

    public void setT_metodos(int t_metodos) {
        this.t_metodos = t_metodos;
    }

    public int getT_comentarios() {
        return t_comentarios;
    }

    public void setT_comentarios(int t_comentarios) {
        this.t_comentarios = t_comentarios;
    }
    
}
