package sample.weatherapp2.backend.domen;



import sample.weatherapp2.backend.config.Config;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class GetWeather {
    public static void apiWeather(String URL) {
        try {

            URL url = new URL(URL);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
//            int responseCode = httpURLConnection.getResponseCode();

            InputStream inputStream = httpURLConnection.getInputStream();

            String jsonResponse = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().collect(Collectors.joining("\n"));

            httpURLConnection.disconnect();
            writeFile(Config.pathToJsonFile, jsonResponse);
        } catch (Exception e) {

            System.out.println("Error 0x02\n");
        }

    }

    public static void writeFile(String path, String writeJson) {
        try {
            File file = new File(path);
            FileWriter writer = new FileWriter(file);
            writer.write(writeJson);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error 0x01");
        }

    }
}
