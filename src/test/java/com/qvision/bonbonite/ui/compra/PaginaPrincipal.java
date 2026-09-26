package com.qvision.bonbonite.ui.compra;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaPrincipal {

    public static final Target OPCION_MENU = Target.the("Opción {0} del menú de categorías")
            .locatedBy("//ul[@id='menu-categories-menu']//a[contains(text(), '{0}')]");

    public static final Target OPCION_DATOS = Target.the("Opción datos")
            .locatedBy("//nav[contains(@class, 'my-account-navigation translate-y-px')]//a[contains(text(), 'Datos')]");
}
