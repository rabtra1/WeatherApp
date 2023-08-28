module sample.weatherapp2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens sample.weatherapp2 to javafx.fxml;
    exports sample.weatherapp2;
}