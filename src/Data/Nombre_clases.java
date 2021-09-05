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
public class Nombre_clases {
    String nombre;
    String archivo;
    int cant_lineas;
    public void Nombre_clases(){
        nombre ="";
        archivo = "";
        cant_lineas =0;
    }
    public int getCant_lineas() {
        return cant_lineas;
    }

    public void setCant_lineas(int cant_lineas) {
        this.cant_lineas = cant_lineas;
    }
    
    

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
