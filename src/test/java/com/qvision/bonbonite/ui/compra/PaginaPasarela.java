package com.qvision.bonbonite.ui.compra;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaPasarela {

    public static final Target IFRAME_WOMPI = Target.the("Iframe de la pasarela Wompi")
            .located(By.cssSelector("[class='waybox-iframe']"));

    public static final Target BOTON_NEQUI = Target.the("Opción de pago Nequi")
            .located(By.xpath("//div[contains(text(), 'Nequi')]"));
}
