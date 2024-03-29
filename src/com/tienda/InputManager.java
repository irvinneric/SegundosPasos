package com.tienda;
import java.util.Scanner;

public class InputManager {
    Scanner entrada = new Scanner(System.in);

    //exepciones
    public int leerInt (String mensaje){
        int valor = 0;
        boolean estado = false;

        do {
            try {
                System.out.println(mensaje);
                valor = Integer.parseInt(entrada.nextLine());
                estado = true;
            } catch (NumberFormatException e) {
                System.out.println("Se espera un número real. Inténtalo de nuevo.");
            }
        } while (!estado);
        return valor;
    }

    public double leerDouble (String mensaje){
        double valor = 0;
        boolean estado = false;

        do {
            try {
                System.out.println(mensaje);
                valor = Double.parseDouble(entrada.nextLine());
                estado = true;
            } catch (NumberFormatException e) {
                System.out.println("Se esperaba un número real. Inténtalo de nuevo.");
            }
        } while (!estado);
        return valor;
    }
}
