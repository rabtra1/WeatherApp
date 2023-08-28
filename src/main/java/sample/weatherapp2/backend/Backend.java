package sample.weatherapp2.backend;



import sample.weatherapp2.HelloController;
import sample.weatherapp2.backend.config.Config;
import sample.weatherapp2.backend.domen.GetWeather;
import sample.weatherapp2.backend.domen.ResponseParser;

import java.io.IOException;
import java.util.Scanner;


public class Backend extends ResponseParser {

    public static String runApp(String userCity) {
        HelloController controller = new HelloController();

        try {
            String URL = "https://api.openweathermap.org/data/2.5/weather?q="+ userCity +"&units=metric&appid="+ Config.API;


            GetWeather.apiWeather(URL);
            return run();
        } catch (Exception e) {
            System.out.println("Error 0x03");
        }

        return null;
    }


}