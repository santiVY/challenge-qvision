package com.qvision.bonbonite.ui.registro;

import net.serenitybdd.screenplay.targets.Target;

/**
 * Localizadores del formulario de registro de Bon-Bonite.
 * AJUSTA los selectores según el DOM real del sitio (usa el inspector de Chrome).
 */
public class PaginaCuentaUsuario {

    public static final Target NOMBRE_USUARIO =
            Target.the("nombre usuario").locatedBy("//h3[contains(text(),'Hola')]");
}
