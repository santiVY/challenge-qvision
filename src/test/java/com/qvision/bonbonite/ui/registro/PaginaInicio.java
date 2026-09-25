package com.qvision.bonbonite.ui.registro;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Localizadores de la página de inicio de Bon-Bonite relacionados con el registro.
 * AJUSTA los selectores según el DOM real del sitio (usa el inspector de Chrome).
 */
public class PaginaInicio {

    public static final Target TOGGLE_MENU_CUENTA =
            Target.the("toggle para ir al menu cuenta").located(By.id("toggle-account-menu"));

}
