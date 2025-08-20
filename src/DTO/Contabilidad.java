/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DTO;

import DAO.MateriaPrimaDao;
import DAO.ProductoDao;
import java.util.ArrayList;

/**
 *
 * @author leyma
 */
public interface Contabilidad {
    public double calcularPrecioVenta(Producto p, double porcentajeGanancia);
    double calcularCostoUnitario(Producto p);
    
    
}
