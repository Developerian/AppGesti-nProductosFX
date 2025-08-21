package controladores;

import DAO.ProductoDao;
import DTO.ContabilidadNegocio;
import DTO.MateriaPrima;
import DTO.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class VentanaMateriaPrima {

    @FXML private TextField nombreProducto;
    @FXML private ComboBox<MateriaPrima> comboIngredientes;
    @FXML private ComboBox<MateriaPrima> comboAccesorios;
    @FXML private ComboBox<MateriaPrima> comboAgregados;
    @FXML private TextArea areaResultado;

    private Producto productoActual;
    private ArrayList<MateriaPrima> inventario = new ArrayList<>();
    private ArrayList<MateriaPrima> inventarioAccesorios = new ArrayList<>();
    private ArrayList<MateriaPrima> inventarioAgregados = new ArrayList<>();

    @FXML
    private void initialize() {
        // Prellenar inventario
        inventario.add(new MateriaPrima("Disco", 0.30));
        inventario.add(new MateriaPrima("Queso", 0.10));
        inventario.add(new MateriaPrima("Vaso", 0.05));
        inventarioAccesorios.add(new MateriaPrima("Servilleta", 0.05));
        inventarioAgregados.add(new MateriaPrima("Mayonesa", 0.10));

        comboIngredientes.getItems().addAll(inventario);
        comboAccesorios.getItems().addAll(inventarioAccesorios);
        comboAgregados.getItems().addAll(inventarioAgregados);

        // Validar texto (solo letras y espacios)
        nombreProducto.textProperty().addListener((obs, oldText, newText) -> {
            if (!newText.matches("[a-zA-ZáéíóúÁÉÍÓÚ ]*")) {
                nombreProducto.setText(oldText);
            }
        });
    }

    @FXML
    private void crearProducto() {
        String nombre = nombreProducto.getText().trim();
        if (!nombre.isEmpty()) {
            productoActual = new Producto(nombre);
            areaResultado.appendText("Nuevo producto creado: " + nombre + "\n");
        } else {
            areaResultado.appendText("El nombre del producto no debe estar vacío.\n");
        }
    }

    @FXML
    private void agregarIngrediente() {
        if (productoActual == null) {
            areaResultado.appendText("Primero crea un producto.\n");
            return;
        }
        MateriaPrima seleccionada = comboIngredientes.getValue();
        if (seleccionada != null) {
            productoActual.agregarIngredientes(seleccionada);
            areaResultado.appendText("Ingrediente agregado: " + seleccionada.getNombreProducto() + "\n");
        }
    }

    @FXML
    private void agregarAccesorio() {
        if (productoActual == null) {
            areaResultado.appendText("Primero crea un producto.\n");
            return;
        }
        MateriaPrima seleccionada = comboAccesorios.getValue();
        if (seleccionada != null) {
            productoActual.agregarAccesorios(seleccionada);
            areaResultado.appendText("Accesorio agregado: " + seleccionada.getNombreMateriaPrima() + "\n");
        }
    }

    @FXML
    private void agregarAgregado() {
        if (productoActual == null) {
            areaResultado.appendText("Primero crea un producto.\n");
            return;
        }
        MateriaPrima seleccionada = comboAgregados.getValue();
        if (seleccionada != null) {
            productoActual.agregarAgredados(seleccionada);
            areaResultado.appendText("Agregado: " + seleccionada.getNombreProducto() + "\n");
        }
    }

    @FXML
    private void calcularCosto() {
        if (productoActual == null) {
            areaResultado.appendText("Crea un producto antes de calcular.\n");
            return;
        }
        ContabilidadNegocio contabilidad = new ContabilidadNegocio();
        double costo = contabilidad.calcularCostoUnitario(productoActual);
        double pv = contabilidad.calcularPrecioVenta(productoActual, 0.5);
        productoActual.setPrecioUnitario(costo);
        productoActual.setPrecioDeVenta(pv);
        areaResultado.appendText("Costo unitario: $" + String.format("%.2f", costo) + "\n");
        areaResultado.appendText("Precio de venta: $" + String.format("%.2f", pv) + "\n");
    }

    @FXML
    private void guardar() {
        if (productoActual == null) {
            new Alert(Alert.AlertType.WARNING, "El producto está vacío").showAndWait();
        } else {
            new ProductoDao().guardarProductos(productoActual);
            new Alert(Alert.AlertType.INFORMATION, "Producto guardado exitosamente").showAndWait();
        }
    }

    @FXML
    private void limpiar() {
        nombreProducto.clear();
        comboIngredientes.getSelectionModel().clearSelection();
        comboAccesorios.getSelectionModel().clearSelection();
        comboAgregados.getSelectionModel().clearSelection();
        areaResultado.clear();
        productoActual = null;
    }

    @FXML
    private void abrirGestion() {
        // Aquí deberías cargar otro FXML (VentanaGestion.fxml)
        areaResultado.appendText("Abrir ventana de gestión...\n");
    }
}
