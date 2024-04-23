package com.aluracursos.midesafio.modelos;

import com.aluracursos.midesafio.conversor.Divisas;

import java.util.Scanner;
//Menu principal
public class Menu {

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        // Definir las opciones del menú
        String[] opciones = { "Conversor de Divisas"};

        // Mostrar las opciones del menú en la consola
        System.out.println("Seleccione una opción:");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }

        // Leer la opción seleccionada por el usuario desde la consola
        System.out.print("Ingrese el número de la opción deseada: ");
        int opcionSeleccionada = scanner.nextInt();

        // Validar la opción seleccionada por el usuario
        if (opcionSeleccionada < 1 || opcionSeleccionada > opciones.length) {
            System.out.println("Opción inválida. Programa Finalizado.");
        } else {
            String opcionElegida = opciones[opcionSeleccionada - 1];
            // Realizar la acción correspondiente según la opción seleccionada
            if (opcionElegida.equals("Conversor de Divisas")) {
                Divisas conversorDivisas = new Divisas();
                conversorDivisas.convertirDivisa();
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.iniciar();
    }
}
