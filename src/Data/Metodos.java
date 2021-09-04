
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
public class Metodos {
    private String clase;
    private String id;
    private int parametros;
    private int lineas;
    public void Metodo(){
        clase ="";
        id ="";
        parametros =0;
        lineas =0;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getParametros() {
        return parametros;
    }

    public void setParametros(int parametros) {
        this.parametros = parametros;
    }

    public int getLineas() {
        return lineas;
    }

    public void setLineas(int lineas) {
        this.lineas = lineas;
    }
    
}
