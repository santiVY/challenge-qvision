package com.qvision.bonbonite.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class GeneradorDatosUnicos {

    private static final Random random = new Random();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static String generarCedula() {
        return String.valueOf(100000000 + random.nextInt(900000000));
    }

    public static String generarNombre() {
        String[] nombres = {"Juan", "María", "Carlos", "Ana", "Pedro", "Laura", "Miguel", "Sofía", "Diego", "Valentina"};
        return nombres[random.nextInt(nombres.length)];
    }

    public static String generarApellido() {
        String[] apellidos = {"García", "Rodríguez", "Martínez", "López", "González", "Pérez", "Sánchez", "Romero", "Torres", "Ruiz"};
        return apellidos[random.nextInt(apellidos.length)];
    }

    public static String generarCorreo(String nombre, String apellido) {
        String timestamp = LocalDateTime.now().format(formatter);
        String nombreNormalizado = nombre.toLowerCase().replaceAll("á", "a").replaceAll("é", "e").replaceAll("í", "i").replaceAll("ó", "o").replaceAll("ú", "u");
        String apellidoNormalizado = apellido.toLowerCase().replaceAll("á", "a").replaceAll("é", "e").replaceAll("í", "i").replaceAll("ó", "o").replaceAll("ú", "u");
        return String.format("%s.%s.%s@qa.example.com", nombreNormalizado, apellidoNormalizado, timestamp);
    }

    public static String generarPassword() {
        return "Bonbonite#" + LocalDateTime.now().format(formatter);
    }
}
