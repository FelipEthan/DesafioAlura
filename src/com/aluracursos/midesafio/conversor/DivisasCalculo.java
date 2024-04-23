package com.aluracursos.midesafio.conversor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DivisasCalculo {

    private Scanner scanner;

    public DivisasCalculo() {
        this.scanner = new Scanner(System.in);
    }

    public void resultadoConversion(String tipoDivisa, String cantidadAConvertir) {
        // Crear un arreglo para almacenar los datos necesarios para la API
        String[] datosAPI = new String[3];
        String deDivisa = "", aDivisa = "";

        // Determinar las divisas de origen y destino según el tipo de conversión seleccionado
        switch (tipoDivisa) {
            case "Dolar ==>> Peso Argentino":
                deDivisa = "USD";
                aDivisa = "ARS";
                break;
            case "Peso Argentino ==>> Dolar":
                deDivisa = "ARS";
                aDivisa = "USD";
                break;
            case "Dolar ==>> Real brasileño":
                deDivisa = "USD";
                aDivisa = "BRL";
                break;
            case "Real Brasileño ==>> Dolar":
                deDivisa = "BRL";
                aDivisa = "USD";
                break;
            case "Dolar ==>> Peso colombiano":
                deDivisa = "USD";
                aDivisa = "COP";
                break;
            case "Peso colombiano ==>> Dolar":
                deDivisa = "COP";
                aDivisa = "USD";
                break;
            default:
                System.out.println("Opción de conversión no válida");
                return; // Salir del método si la opción no es válida
        }

        try {
            // Reemplazar la coma por un punto en la cantidad a convertir
            cantidadAConvertir = cantidadAConvertir.replace(",", ".");

            // Imprimir la cantidad a convertir para verificar su formato
            System.out.println("Cantidad a convertir: " + cantidadAConvertir);

            // Obtener la fecha actual y formatearla
            LocalDate actualDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLL yyyy");
            String fechaFormateada = actualDate.format(formatter);

            // Actualizar los datos necesarios para la API
            datosAPI[0] = cantidadAConvertir;
            datosAPI[1] = deDivisa;
            datosAPI[2] = aDivisa;

            DivisasApi res = new DivisasApi();
            double cantidadConvertida = res.get(datosAPI[0], datosAPI[1], datosAPI[2]);

            // Mostrar el resultado de la conversión en la consola
            System.out.println("$" + datosAPI[0] + " " + datosAPI[1] + " equivale a $" + cantidadConvertida + " " + datosAPI[2] + " (" + fechaFormateada + ")");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al realizar la conversión. Por favor, inténtelo de nuevo más tarde.");
        }
    }

    public static void main(String[] args) {
        DivisasCalculo conversor = new DivisasCalculo();

        // Simular una conversión de ejemplo desde la consola
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de USD que desea convertir:");
        String cantidad = inputScanner.nextLine();

        conversor.resultadoConversion("USD a ARS", cantidad);

        inputScanner.close();
    }
}
