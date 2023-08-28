package sample.weatherapp2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.weatherapp2.backend.Backend;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public TextField nameOfCity;

    @FXML
    private Label weatherResult;

    @FXML
    private Button weatherResultButton;


    @FXML
    void initialize() {
        weatherResultButton.setOnAction(event -> weatherResult.setText("Temperature: " + Backend.runApp(nameOfCity.getText().trim())));

    }

}
