/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import DAO.MateriaPrimaDao;
import DAO.ProductoDao;
import java.util.ArrayList;

/**
 *
 * @author leyma
 */
public class ContabilidadNegocio implements Contabilidad {
    private double precioVenta;
    private double costoUnitario;

    public ContabilidadNegocio() {
    }
    
    
    
    public ContabilidadNegocio(double precioVenta, double costoUnitario) {
        this.precioVenta = precioVenta;
        this.costoUnitario = costoUnitario;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
    
    

    @Override
    public double calcularPrecioVenta(Producto p, double porcentajeGanancia) {
        double resultado;
        double pv = calcularCostoUnitario(p);
        resultado = pv / (1-porcentajeGanancia);
        setPrecioVenta(resultado);
        return resultado;
        
        
        
    }

    @Override
    public double calcularCostoUnitario(Producto p){
        double total = 0.0;
        
        for(MateriaPrima m : p.getIngredientes()){
            total += m.getPrecioProducto();
        }
        
        setCostoUnitario(total);
        return total;
    }

    
    
    
    
}
