package com.tienda;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Producto {
    private int codigoProducto;
    private String nombreProducto;
    private double precioProducto;
    private int cantidadProducto;

    /**
     *
     *
     * @return Para representar el producto como una cadena Legible.
     */
    public String toString() {
        return "Codigo: " + codigoProducto + " Nombre: " + nombreProducto + " Precio: " + precioProducto + " Cantidad: " + cantidadProducto;
    }

}
