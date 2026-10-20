package com.mycompany.gastoss;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GastosController implements Initializable {

    @FXML
    private TextField txtAlimentacion;

    @FXML
    private TextField txtRefrigerios;

    @FXML
    private TextField txtTransporte;

    @FXML
    private TextField txtTelefonia;

    @FXML
    private TextField txtOtros;

    @FXML
    private TextField txtTotalSemanal;

    @FXML
    private TextField txtGastoMayor;

    @FXML
    private Button btncalcularest;

    @FXML
    private Button btnlimpiar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        txtTotalSemanal.setEditable(false);
        txtGastoMayor.setEditable(false);

    }

    @FXML
    private void calcularestadisticas(ActionEvent event) {

        try {

            double alimentacion =
                    Double.parseDouble(txtAlimentacion.getText().trim());

            double refrigerios =
                    Double.parseDouble(txtRefrigerios.getText().trim());

            double transporte =
                    Double.parseDouble(txtTransporte.getText().trim());

            double telefonia =
                    Double.parseDouble(txtTelefonia.getText().trim());

            double otros =
                    Double.parseDouble(txtOtros.getText().trim());

            double total =
                    alimentacion +
                    refrigerios +
                    transporte +
                    telefonia +
                    otros;

            txtTotalSemanal.setText(String.valueOf(total));

            double mayor = alimentacion;
            String categoria = "Alimentación";

            if (refrigerios > mayor) {
                mayor = refrigerios;
                categoria = "Refrigerios";
            }

            if (transporte > mayor) {
                mayor = transporte;
                categoria = "Transporte";
            }

            if (telefonia > mayor) {
                mayor = telefonia;
                categoria = "Telefonía";
            }

            if (otros > mayor) {
                mayor = otros;
                categoria = "Otros";
            }

            txtGastoMayor.setText(categoria);

        } catch (NumberFormatException e) {

            Alert alerta =
                    new Alert(Alert.AlertType.WARNING);

            alerta.setTitle("Dato incorrecto");
            alerta.setHeaderText("Entrada no válida");
            alerta.setContentText(
                    "Ingrese únicamente números en todos los campos.");

            alerta.showAndWait();
        }
    }

    @FXML
    private void Limpiar(ActionEvent event) {

        txtAlimentacion.clear();
        txtRefrigerios.clear();
        txtTransporte.clear();
        txtTelefonia.clear();
        txtOtros.clear();
        txtTotalSemanal.clear();
        txtGastoMayor.clear();

        txtAlimentacion.requestFocus();
    }
}