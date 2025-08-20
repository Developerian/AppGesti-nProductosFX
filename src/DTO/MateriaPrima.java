/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author leyma
 */
public class MateriaPrima implements Serializable {

    private String nombreMateriaPrima;
    private double precioProducto;
    
    
    
    public MateriaPrima(String nombreMateriaPrima, double precioProducto) {
        this.nombreMateriaPrima = nombreMateriaPrima;
        this.precioProducto = precioProducto;
        
    }
    public MateriaPrima(){
        
    }
    public MateriaPrima(String nombre){
        this.nombreMateriaPrima = nombre;
    }

    

    public String getNombreProducto() {
        return nombreMateriaPrima;
    }

    public void setNombreProducto(String nombreMateriaPrima) {
        this.nombreMateriaPrima = nombreMateriaPrima;
    }

    public double getPrecioMateriaPrima() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioMateriaPrima) {
        this.precioProducto = precioMateriaPrima;
    }
    
    
    
    
    
    
    
    
    
    
    public String getNombreMateriaPrima() {
        return nombreMateriaPrima;
    }

    public void setNombreMateriaPrima(String nombreMateriaPrima) {
        this.nombreMateriaPrima = nombreMateriaPrima;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    @Override
    public String toString() {
        return nombreMateriaPrima;
    }

    

}
