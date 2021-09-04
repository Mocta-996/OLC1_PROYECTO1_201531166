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
public class Pe_metodo {
    private String archivo ;
    private String clase1 ;
    private String clase2 ;
    private String variable ;
    private double punteo;
    private boolean r;
    
    public void Pe_metodo(){
    archivo ="";
    clase1 ="";
    clase2 ="";
    punteo =0;
    r=false;
    }

    public String getClase1() {
        return clase1;
    }

    public void setClase1(String clase1) {
        this.clase1 = clase1;
    }

    public String getClase2() {
        return clase2;
    }

    public void setClase2(String clase2) {
        this.clase2 = clase2;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public double getPunteo() {
        return punteo;
    }

    public void setPunteo(double punteo) {
        this.punteo = punteo;
    }

    public boolean isR() {
        return r;
    }

    public void setR(boolean r) {
        this.r = r;
    }
    
    
    
}
