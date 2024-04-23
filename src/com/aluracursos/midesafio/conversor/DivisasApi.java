package com.aluracursos.midesafio.conversor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DivisasApi {
    public double get(String cantidadDinero, String deDivisa, String aDivisa) {
        double resultado = 0;
        double cantidad = Double.parseDouble(cantidadDinero);
        //Clave de API
        String APIKey = "df35f584e83d709ba38e6cd0";

        try {
            // Construir la URL de la API con los parámetros de conversión
            URL url = new URL("https://v6.exchangerate-api.com/v6/" + APIKey + "/pair/" + deDivisa + "/" + aDivisa + "/" + cantidad);

            // Establecer la conexión HTTP
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Verificar el código de respuesta HTTP
            if (request.getResponseCode() == 200) {
                // Parsear la respuesta JSON
                JsonParser parser = new JsonParser();
                JsonElement root = parser.parse(new InputStreamReader(request.getInputStream()));

                // Convertir a JsonObject
                JsonObject jsonObject = root.getAsJsonObject();

                // Verificar si los elementos necesarios no son nulos
                if (jsonObject.has("conversion_result") && jsonObject.has("conversion_rate") && jsonObject.has("time_last_update_utc")) {
                    // Obtener la tasa de conversión y reemplazar la coma por un punto
                    String tasaConversionStr = jsonObject.get("conversion_rate").getAsString();
                    tasaConversionStr = tasaConversionStr.replace(",", ".");
                    double tasaConversion = Double.parseDouble(tasaConversionStr);
                    String ultimaActualizacion = jsonObject.get("time_last_update_utc").getAsString();
                    System.out.println("La tasa de conversión es de: $" + tasaConversion + "\nFecha: " + ultimaActualizacion);

                    // Obtener el resultado de la conversión
                    double conversionResult = jsonObject.get("conversion_result").getAsDouble();

                    // Asignar el resultado de la conversión
                    resultado = conversionResult;
                    System.out.println("Resultado Total: " + conversionResult);
                } else {
                    System.out.println("La respuesta JSON no tiene los elementos esperados.");
                }
            } else {
                System.out.println("Error de Respuesta " + request.getResponseCode());
            }
            // Cerrar la conexión HTTP
            request.disconnect();

        } catch (MalformedURLException e) {
            System.out.println("URL mal formada: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de IO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return resultado;
    }
}
