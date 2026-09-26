package com.qvision.bonbonite.models;

/**
 * Representa los datos que un usuario ingresa al realizar una compra
 * de un producto en Bon-Bonite.
 */
public record DatosCompra(String talla, String genero, String telefono, String pais, String departamento, String ciudad, String direccion) {
}
