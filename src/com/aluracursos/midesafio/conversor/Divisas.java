package com.aluracursos.midesafio.conversor;
import java.util.Scanner;

public class Divisas {

    public void convertirDivisa() {
        Scanner scanner = new Scanner(System.in);

        // Definir las opciones de conversión de divisas
        String[] opcionesDivisa = {
                "Dolar ==>> Peso Argentino",
                "Peso Argentino ==>> Dolar",
                "Dolar ==>> Real brasileño",
                "Real Brasileño ==>> Dolar",
                "Dolar ==>> Peso colombiano",
                "Peso colombiano ==>> Dolar",
                "Salir del Programa"
        };

        // Mostrar las opciones de conversión de divisas en la consola
        System.out.println("Seleccione una opción:");
        for (int i = 0; i < opcionesDivisa.length; i++) {
            System.out.println((i + 1) + ". " + opcionesDivisa[i]);
        }

        // Leer la opción seleccionada por el usuario desde la consola
        System.out.print("Ingrese el número de la opción deseada: ");
        int opcionSeleccionada = scanner.nextInt();

        // Validar la opción seleccionada por el usuario
        if (opcionSeleccionada < 1 || opcionSeleccionada > opcionesDivisa.length) {
            System.out.println("Opción inválida. Programa Finalizado.");

        } else {
            String opcionDivisaElegida = opcionesDivisa[opcionSeleccionada - 1];
            if (opcionDivisaElegida.equals("Salir del Programa")) {
                System.out.println("Saliendo del programa. ¡Hasta luego!");
            } else {
            // Solicitar la cantidad a convertir desde la consola
            System.out.print("Ingrese la cantidad que desea convertir de " + opcionDivisaElegida + ": ");
            double cantidadAConvertir = scanner.nextDouble();

            // Realizar la operación de conversión
            DivisasCalculo operacion = new DivisasCalculo();
            operacion.resultadoConversion(opcionDivisaElegida, String.valueOf(cantidadAConvertir));
        }
        }
        // Mostrar el mensaje final en la consola
        System.out.println("Programa Finalizado. Muchas Gracias.");

        scanner.close();
    }
}
