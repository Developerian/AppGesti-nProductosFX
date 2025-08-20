/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.MateriaPrima;
import DTO.Producto;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author leyma
 */
public class ProductoDao {

    private ArrayList<Producto> listaProductos = new ArrayList<>();

    private static final String ARCHIVO = "productos.dat";

    public void guardarProducto(ArrayList<Producto> productos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(productos);
            System.out.println("Archivo guardado");

        } catch (IOException ioe) {
            System.out.println("Ocurrio un error" + ioe.getMessage());
            ioe.printStackTrace();
        }
    }

    public ArrayList<Producto> leerProductos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            listaProductos = (ArrayList<Producto>) ois.readObject();
            System.out.println("Producto guardado");
        } catch(FileNotFoundException fnfe){
            System.out.println("Archivo no encontrado");
            
        } catch (IOException  | ClassNotFoundException e) {
            System.out.println("Ocurrio un error de lectura"+e.getMessage());
            e.printStackTrace();
            
        }
        
        return listaProductos;

    }

    public void guardarProductos(Producto p) {
        ArrayList<Producto> productos = leerProductos();
        productos.add(p);
        guardarProducto(productos);
        System.out.println("Producto guardado");
    }

}
