/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.MateriaPrima;
import java.util.ArrayList;

/**
 *
 * @author leyma
 */
public class MateriaPrimaDao {

    private ArrayList<MateriaPrima> listaIngredientes = new ArrayList<>();
    private ArrayList<MateriaPrima> listaAgregados = new ArrayList<>();
    private ArrayList<MateriaPrima> listaAccesorios = new ArrayList<>();

    public MateriaPrimaDao() {
    }

    public ArrayList<MateriaPrima> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(ArrayList<MateriaPrima> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public ArrayList<MateriaPrima> getListaAgregados() {
        return listaAgregados;
    }

    public void setListaAgregados(ArrayList<MateriaPrima> listaAgregados) {
        this.listaAgregados = listaAgregados;
    }

    public ArrayList<MateriaPrima> getListaAccesorios() {
        return listaAccesorios;
    }

    public void setListaAccesorios(ArrayList<MateriaPrima> listaAccesorios) {
        this.listaAccesorios = listaAccesorios;
    }

    
}
