package ventanas;

import javafx.geometry.Insets;
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

    public Scene getScene() {
        Label label = new Label("Gestione sus productos o sus materias primas");
        Button btnCerrar = new Button("Regresar");
        Button btnMateriaPrima = new Button("Materia Prima");
        Button btnProducto = new Button("Productos");

        //Contenedores
        HBox fila = new HBox(15);
        fila.getChildren().addAll(label);

        VBox columna = new VBox(15);
        columna.setPadding(new Insets(25, 20, 15, 25));

        columna.getChildren().add(fila);

        GridPane botones = new GridPane();
        botones.setHgap(20);
        botones.setVgap(10);
        botones.setPadding(new Insets(10));

        botones.add(btnMateriaPrima, 1, 0);
        botones.add(btnProducto, 2, 0);
        
        
        
        Scene scene = new Scene(columna, 200, 200);

        btnCerrar.setOnAction(e -> {
            ((javafx.stage.Stage)btnCerrar.getScene().getWindow()).close();
        });
        return scene;
    }
}
