package com.tienda;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductoManager {
    ArrayList<Producto> arrayListaproductos = new ArrayList<>();
    Scanner entrada = new Scanner(System.in);
    InputManager inputManager = new InputManager();

    //Metodos
    public void agregarProductos() {
        int codigoProducto = inputManager.leerInt("Por favor, Ingresa el código del producto: ");
        if (productoExistente(codigoProducto)) {
            System.out.println("El producto ya está registrado en el inventario.");
            return;
        }
        System.out.println("Ingresa el nombre del producto: ");
        String nombreProducto = entrada.nextLine();
        double precioProducto = inputManager.leerDouble("Por favor, Ingresa el precio del producto: ");
        int cantidadProducto = inputManager.leerInt("Ingresa la cantidad de productos: ");

        arrayListaproductos.add(new Producto(codigoProducto, nombreProducto, precioProducto, cantidadProducto));
    }

    public void eliminarProductos() {
        if (arrayListaproductos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        mostrarProductos();//Se muestran arrayList de los productos
        int codigoProdcuto = inputManager.leerInt("Ingresa el código del producto para eliminarlo.");//Se recibe el codigo del producto

        Producto productoAEliminar = null;

        for (Producto producto : arrayListaproductos) {
            if (producto.getCodigoProducto() == codigoProdcuto) {
                productoAEliminar = producto;
                break;
            }
        }

        if (productoAEliminar != null) {
            System.out.println("Estás se guro que quieres eliminar el producto s/n?");
            String confirmacion = entrada.nextLine();
            if (confirmacion.equalsIgnoreCase("s")) {
                arrayListaproductos.remove(productoAEliminar);
                System.out.println("Producto eliminado correctamente.");
            } else {
                System.out.println("Operacion cancelada");
            }
        } else {
            System.out.println("Producto no encontrado");
        }


    }

    public void mostrarProductos() {
        if (arrayListaproductos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        for (Producto producto : arrayListaproductos) {
            System.out.println(producto);
        }
    }

    public void modificarStock() {
        if (arrayListaproductos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        mostrarProductos();//Mostramos la lista de productos.
        int codigoProducto = inputManager.leerInt("Ingresa el código del producto para cambiar el stock. ");

        for (Producto producto : arrayListaproductos) {

            if (producto.getCodigoProducto() == codigoProducto) {
                int nuevaCantidad = inputManager.leerInt("Ingresa ls nueva cantidad: " + "Nombre " + producto.getNombreProducto() + "(" + producto.getCantidadProducto() + ")");
                producto.setCantidadProducto(nuevaCantidad);
                System.out.println("Stock modificado exitosamente");
                return;
            }
        }
    }

    public void modificarNombre() {
        if (arrayListaproductos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        }

        mostrarProductos();
        int codigo = inputManager.leerInt("Ingresa el codigo del producto para modificar el nombre: ");

        for (Producto producto : arrayListaproductos) {
            if (producto.getCodigoProducto() == codigo) {
                System.out.println("Ingresa el nuevo nombre del producto" + "Producto encontado: " + producto.getNombreProducto());
                String nuevoNombre = entrada.nextLine();

                producto.setNombreProducto(nuevoNombre);
                System.out.println("Nombre del producto cambiado exitosamente.");
                return;
            }
        }
    }

    //metodos auxiliares
    public boolean productoExistente(int codigoProducto) {
        for (Producto producto : arrayListaproductos) {
            if (producto.getCodigoProducto() == codigoProducto) {
                return true;
            }
        }
        return false;
    }
}
