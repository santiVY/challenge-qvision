package com.qvision.bonbonite.models;

/**
 * Representa los datos que un usuario ingresa en el formulario de registro
 * de Bon-Bonite. Se usa también para reutilizar las credenciales al iniciar sesión.
 */
public record DatosInicioSesion(String cedula, String password) {
}
