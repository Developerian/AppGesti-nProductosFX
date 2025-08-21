package controladores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author leyma
 */
public class VentanaGestion {

    private Scene scene;   // guardamos la escena para reutilizarla

    public VentanaGestion() {
        // --- Controles ---
        Label label = new Label("Gestione sus productos o sus materias primas");

        Button btnCerrar = new Button("Regresar");
        Button btnMateriaPrima = new Button("Materia Prima");
        Button btnProducto = new Button("Productos");

        // --- Layouts ---
        HBox fila = new HBox(15, label);
        fila.setAlignment(Pos.CENTER);

        GridPane botones = new GridPane();
        botones.setHgap(20);
        botones.setVgap(10);
        botones.setPadding(new Insets(10));
        botones.add(btnMateriaPrima, 0, 0);
        botones.add(btnProducto, 1, 0);

        VBox columna = new VBox(20, fila, botones, btnCerrar);
        columna.setPadding(new Insets(25, 20, 15, 25));
        columna.setAlignment(Pos.CENTER);

        // --- Escena ---
        this.scene = new Scene(columna, 400, 300);

        // --- Eventos ---
        btnCerrar.setOnAction(e -> {
            ((javafx.stage.Stage) btnCerrar.getScene().getWindow()).close();
        });
    }

    public Scene getScene() {
        return this.scene;   // devolvemos siempre la misma escena
    }
}
