package com.qvision.bonbonite.ui.registro;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Localizadores del formulario de registro de Bon-Bonite.
 * AJUSTA los selectores según el DOM real del sitio (usa el inspector de Chrome).
 */
public class PaginaRegistro {

    public static final Target CEDULA =
            Target.the("campo cedula").located(By.id("reg_username"));

    public static final Target CAMPO_NOMBRE =
            Target.the("campo nombre").located(By.id("first_name"));

    public static final Target CAMPO_APELLIDO =
            Target.the("campo apellido").located(By.id("last_name"));

    public static final Target CAMPO_CORREO =
            Target.the("campo correo").located(By.id("reg_email"));

    public static final Target CAMPO_PASSWORD =
            Target.the("campo contraseña").located(By.id("reg_password"));

    public static final Target CAMPO_REPETIR_PASSWORD =
            Target.the("campo repetir contraseña").located(By.id("reg_password2"));

    public static final Target CHECK_DATOS_PERSONALES =
            Target.the("check datos personales").located(By.id("privacy_policy_reg"));

    public static final Target ENLACE_REGISTRO =
            Target.the("enlace o botón de registro / crear cuenta").located(By.name("register"));

}
