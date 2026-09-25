package com.qvision.bonbonite.ui.registro;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Localizadores del formulario de inicio de sesión de Bon-Bonite.
 * AJUSTA los selectores según el DOM real del sitio (usa el inspector de Chrome).
 */
public class PaginaLogin {

    public static final Target CAMPO_CORREO =
            Target.the("campo correo de login").located(By.id("username"));

    public static final Target CAMPO_PASSWORD =
            Target.the("campo contraseña de login").located(By.name("password"));

    public static final Target BOTON_INICIAR_SESION =
            Target.the("botón iniciar sesión").located(By.name("login"));

    public static final Target ENLACE_REGISTRO =
            Target.the("enlace o botón de registro / crear cuenta")
                    .located(By.id("show_register"));
}
