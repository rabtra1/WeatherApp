package sample.weatherapp2.backend.domen;


import org.json.JSONObject;
import sample.weatherapp2.backend.config.Config;

import java.io.*;

public class ResponseParser {

    public static String run() throws IOException {
        var resultForParsing = getWeather();
        JSONObject jsonObject = new JSONObject(resultForParsing);
        var temp = jsonObject.getJSONObject("main").getDouble("temp");
        return String.valueOf(temp);
    }

    public static String getWeather() throws IOException {

        File f = new File(Config.pathToJsonFile);
        BufferedReader fin = new BufferedReader(new FileReader(f));
        StringBuilder stringBuilder = new StringBuilder();

        String line;
        while ((line = fin.readLine()) != null) {
            stringBuilder.append(line);
        }

        fin.close();
        return stringBuilder.toString();
    }
}
