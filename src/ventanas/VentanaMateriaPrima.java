package ventanas;

import DAO.MateriaPrimaDao;
import DAO.ProductoDao;
import DTO.ContabilidadNegocio;
import DTO.MateriaPrima;
import DTO.Producto;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VentanaMateriaPrima extends Application {

    private ArrayList<MateriaPrima> inventario = new ArrayList<>();
    private Producto productoActual;
    private ArrayList<MateriaPrima> inventarioAccesorios = new ArrayList<>();
    private ArrayList<MateriaPrima> inventarioAgregados = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestor de Materia Prima");

        // Elementos de UI
        TextField nombreProducto = new TextField();
        nombreProducto.setPromptText("Nombre del producto");

        ComboBox<MateriaPrima> comboIngredientes = new ComboBox<>();
        ComboBox<MateriaPrima> comboAccesorios = new ComboBox<>();
        ComboBox<MateriaPrima> comoboAgregados = new ComboBox<>();

        Button btnCrearProducto = new Button("Crear producto");
        Button btnAgregarIngrediente = new Button("Agregar ingrediente");
        Button btnAgregarAccesorios = new Button("Agregar accesorios");
        Button btnAgregarAgregados = new Button("Agregar añadidos");
        Button btnCalcular = new Button("Calcular costo");
        Button btnLimpiarPantalla = new Button("Limpiar campos");
        Button btnConsultarProducto = new Button("Consultrar productos");
        Button btnGuardar = new Button("Guardar");
        Button btnGestion = new Button("Gestión");

        TextArea areaResultado = new TextArea();
        areaResultado.setEditable(false);

        //Contenedores declarados HBOX
        HBox filaHorizontal1 = new HBox(15);
        filaHorizontal1.getChildren().addAll(new Label("Producto"), nombreProducto, btnCrearProducto
        );
        HBox filaHorizontal2 = new HBox(15);
        filaHorizontal2.getChildren().addAll(new Label("Ingredientes"), comboIngredientes, btnAgregarIngrediente);
        HBox filaHorizontal3 = new HBox(15);
        filaHorizontal3.getChildren().addAll(new Label("Accesorios"), comboAccesorios, btnAgregarAccesorios);
        HBox filaHorizontal4 = new HBox(15);
        filaHorizontal4.getChildren().addAll(new Label("Añadidos"), comoboAgregados, btnAgregarAgregados);
        //VBox
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(25, 20, 15, 25));

        // Contenedores creados: Combino VBox con HBox
        layout.getChildren().add(filaHorizontal1);
        layout.getChildren().add(filaHorizontal2);
        layout.getChildren().add(filaHorizontal3);
        layout.getChildren().add(filaHorizontal4);

        //Agregar botones a la UI
        GridPane botones = new GridPane();
        botones.setHgap(20);
        botones.setVgap(10);
        botones.setPadding(new Insets(10));

        botones.add(btnCalcular, 1, 0);
        botones.add(btnConsultarProducto, 2, 0);
        botones.add(btnLimpiarPantalla, 3, 0);

        layout.getChildren().addAll(botones);

        layout.getChildren().addAll(
                new Label("Información:"), areaResultado
        );

        GridPane botonesFinales = new GridPane();
        botonesFinales.setHgap(100);
        botonesFinales.setVgap(10);
        botonesFinales.setPadding(new Insets(10));

        botonesFinales.add(btnGuardar, 1, 0);
        botonesFinales.add(btnGestion, 2, 0);

        layout.getChildren().addAll(botonesFinales);

        // prerellenar inventario
        MateriaPrima disco = new MateriaPrima("Dicos", 0.30);
        MateriaPrima queso = new MateriaPrima("Queso", 0.10);
        
        MateriaPrima vaso = new MateriaPrima("Vaso", 0.05);

        inventario.add(disco);
        inventario.add(vaso);
        
        inventario.add(queso);

        //inventario de accesorios
        MateriaPrima servilletas = new MateriaPrima("Servilleta", 0.05);
        inventarioAccesorios.add(servilletas);

        //inventario de agregados
        MateriaPrima mayonesa = new MateriaPrima("Mayonesa", 0.10);
        inventarioAgregados.add(mayonesa);

        //Agregar a la lista
        comboIngredientes.getItems().addAll(inventario);
        comboAccesorios.getItems().addAll(inventarioAccesorios);
        comoboAgregados.getItems().addAll(inventarioAgregados);

        //Acciones de teclado
        nombreProducto.textProperty().addListener((obs, oldText, newText) -> {
            if (!newText.matches("[a-zA-ZáéíóúÁÉÍÓÚ ]*")) {
                nombreProducto.setText(oldText);
            }
        });

        //Acciones de botones
        //Accion para crear producto
        btnCrearProducto.setOnAction(e -> {

            String nombre = nombreProducto.getText().trim();
            if (!nombre.isEmpty()) {
                productoActual = new Producto(nombre);
                areaResultado.appendText("Nuevo producto creado: " + nombre + "\n");

            } else {
                areaResultado.appendText("El nombre del producto no debe estar vacio \n");

            }
        });

        //accion para agregar ingredientes seleccionado
        btnAgregarIngrediente.setOnAction(e -> {
            if (productoActual == null) {
                areaResultado.appendText("Primero crea un producto. \n");
                return;
            }
            MateriaPrima seleccionada = comboIngredientes.getValue();
            if (seleccionada != null) {
                productoActual.agregarIngredientes(seleccionada);
                areaResultado.appendText("Ingrediente agregado " + seleccionada.getNombreProducto() + " \n");

            }
        });
        //Accion para agregar accesorio al producto
        btnAgregarAccesorios.setOnAction(e -> {
            if (productoActual == null) {
                areaResultado.appendText("Para agregar accesorios, cree un producto \n");
                return;
            }
            MateriaPrima seleccion = comboAccesorios.getValue();
            if (seleccion != null) {
                productoActual.agregarAccesorios(seleccion);
                areaResultado.appendText("Accesorio " + seleccion.getNombreMateriaPrima() + " agregado. \n");
            }

        });

        //Accion para agregar un agregado
        btnAgregarAgregados.setOnAction(e -> {
            if (productoActual == null) {
                areaResultado.appendText("Para agregar un añadido, primero debe ingresar un producto");
                return;
            }
            MateriaPrima seleccion = comoboAgregados.getValue();
            if (seleccion != null) {
                productoActual.agregarAgredados(seleccion);
                areaResultado.appendText("Accesorio " + seleccion.getNombreProducto() + " Agregado \n");
            }
        });

        //Accion para calcular costo y precio
        btnCalcular.setOnAction(e -> {
            if (productoActual == null) {
                areaResultado.appendText("Debe crear un producto antes de calcular \n");
                return;
            }
            ContabilidadNegocio contabilidad = new ContabilidadNegocio();
            double costo = contabilidad.calcularCostoUnitario(productoActual);
            double pv = contabilidad.calcularPrecioVenta(productoActual, 0.5);
            productoActual.setPrecioUnitario(costo);
            productoActual.setPrecioDeVenta(pv);
            areaResultado.appendText("Costo unitario del producto " + productoActual + " es: $" + String.format("%.2f", costo) + "\n");
            areaResultado.appendText("Precio de venta con 25% de ganancia: %" + String.format("%.2f", pv) + " \n");

        });

        // Mostrar ventana
        Scene scene = new Scene(layout, 480, 525);
        primaryStage.setScene(scene);
        primaryStage.show();

        //Accion para guardar en el archivo
        btnGuardar.setOnAction(e -> {

            if (productoActual == null) {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Advertencia");
                alerta.setHeaderText("Advertencia");
                alerta.setContentText("El producto está vacio");
                alerta.showAndWait();
            } else {
                ProductoDao productosGuardados = new ProductoDao();
                productosGuardados.guardarProductos(productoActual);
                Alert alerta2 = new Alert(Alert.AlertType.INFORMATION);
                alerta2.setTitle("Información");
                alerta2.setContentText("El producto se guardó exitosamente");
                alerta2.showAndWait();
                System.out.println("Accion finaizada");
                
            }

        });

        //Acción para limpiar campos
        btnLimpiarPantalla.setOnAction(e -> {
            nombreProducto.clear();
            comoboAgregados.getSelectionModel().clearSelection();
            comboAccesorios.getSelectionModel().clearSelection();
            comboIngredientes.getSelectionModel().clearSelection();
            areaResultado.setText("");
            productoActual = null;
        });
        
        
        
        

    }

    public boolean match(char c) {
        return "áéíóúÁÉÍÓÚ".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
