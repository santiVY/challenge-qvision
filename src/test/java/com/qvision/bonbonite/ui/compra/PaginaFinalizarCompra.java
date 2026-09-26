package com.qvision.bonbonite.ui.compra;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaFinalizarCompra {

    public static final Target SELECTOR_GENERO = Target.the("Desplegable de Género")
            .located(By.id("billing_gender"));

    public static final Target TELEFONO = Target.the("Telefono")
            .located(By.id("billing_phone"));

    public static final Target SELECTOR_PAIS = Target.the("seleccionar pais")
            .located(By.id("select2-billing_country-container"));

    public static final Target SELECTOR_DEPARTAMENTO = Target.the("seleccionar departamento")
            .located(By.id("select2-billing_state-container"));

    public static final Target SELECTOR_CIUDAD = Target.the("seleccionar ciudad")
            .located(By.id("select2-billing_city-container"));

    public static final Target INPUT_SELECT2 = Target.the("Input de búsqueda Select2")
            .locatedBy(".select2-search__field");

    public static final Target DIRECCION = Target.the("direccion")
            .located(By.id("billing_address_1"));

    public static final Target ACEPTAR_TERMINOS = Target.the("check para aceptar terminos")
            .located(By.id("terms"));

    public static final Target REGISTRAR_ORDEN = Target.the("registrar orden")
            .located(By.id("place_order"));

    public static final Target BOTON_PAGAR_WOMPI = Target.the("boton pagar con wompi").located(By.className("waybox-button"));
}
