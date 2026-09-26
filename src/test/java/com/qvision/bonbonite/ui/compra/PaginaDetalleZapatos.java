package com.qvision.bonbonite.ui.compra;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaDetalleZapatos {
public static final Target TALLA_CALZADO = Target.the("Talla de calzado {0}")
        .locatedBy("[data-value='{0}']");

public static final Target BOTON_COMPRAR = Target.the("Botón Comprar Ahora")
        .locatedBy("//a[contains(text(),'Comprar Ahora')]");

public static final Target BOTON_FINALIZAR_COMPRA = Target.the("Botón Finalizar compra")
        .locatedBy("//a[contains(text(),'Finalizar compra')]");

    public static final Target BOTON_CONTINUAR = Target.the("Botón Continuar")
            .locatedBy("//button[contains(text(), 'Continuar')]");
}


