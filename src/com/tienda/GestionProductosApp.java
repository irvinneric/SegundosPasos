package com.tienda;

import java.util.Scanner;

public class GestionProductosApp {
    private ProductoManager productoManager = new ProductoManager();
    InputManager inputManager = new InputManager();
    private Scanner entrada = new Scanner(System.in);

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);
        entrada.close();
    }

    private void mostrarMenu() {
        System.out.println("*****MENU:****");
        System.out.println("1. Agregar productos.");
        System.out.println("2. Eliminar productos.");
        System.out.println("3. Mostrar productos.");
        System.out.println("4. Modificar stock.");
        System.out.println("5. Modificar el nombre del producto.");
        System.out.println("0. salir");
    }

    private int leerOpcion() {
        return inputManager.leerInt("Elige una opción");
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                productoManager.agregarProductos();
                break;
            case 2:
                productoManager.eliminarProductos();
                break;
            case 3:
                productoManager.mostrarProductos();
                break;
            case 4:
                productoManager.modificarStock();
                break;
            case 5:
                productoManager.modificarNombre();
                break;
            case 0:
                System.out.println("Saliendo del programa.");
                System.exit(0); // Termina el programa
                break;
            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
        }

    }
}