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
public class Producto implements Serializable{
    private String nombre;
    
    //Lista en memoria
    private ArrayList<MateriaPrima> ingredientes = new ArrayList<>();
    private ArrayList<MateriaPrima> agregados = new ArrayList<>();
    private ArrayList<MateriaPrima> accesorios = new ArrayList<>();
    private double precioUnitario;
    private double precioDeVenta;
    
    
                
    
    public Producto(String nombre){
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(double precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  
    
    //Metodos para agregar
    
    
    public ArrayList<MateriaPrima> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<MateriaPrima> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public ArrayList<MateriaPrima> getAgregados() {
        return agregados;
    }

    public void setAgregados(ArrayList<MateriaPrima> agregados) {
        this.agregados = agregados;
    }

    public ArrayList<MateriaPrima> getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(ArrayList<MateriaPrima> accesorios) {
        this.accesorios = accesorios;
    }
    
    
    
    
    public void agregarIngredientes(MateriaPrima mp){
        ingredientes.add(mp);
    }
    public void agregarAccesorios(MateriaPrima mp){
        accesorios.add(mp);
    }
    public void agregarAgredados(MateriaPrima mp){
        agregados.add(mp);
    }
    
    //Metodos para borrar
    public void eliminarIngredientes(MateriaPrima mp){
        agregados.remove(mp);
    }
    public void eliminarAccesorios(MateriaPrima mp){
        agregados.remove(mp);
    }
    public void eliminarAgregados(MateriaPrima mp){
        agregados.remove(mp);
    }
    
    //Metodos de busqueda
    
    //toString
    @Override
    public String toString() {
        return nombre +"\n"+
                "Sus ingredientes son: " +ingredientes+ " \n"+
                "Sus accesorios son: "+accesorios+ " \n"+
                "Sus añadidos son: "+agregados+ " \n"+
                "Su precio unitario (PU):" ;
                        
    }
    
    
    
}
