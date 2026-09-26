package com.qvision.bonbonite.tasks.compra;

import com.qvision.bonbonite.models.DatosCompra;
import com.qvision.bonbonite.ui.compra.PaginaDetalleZapatos;
import com.qvision.bonbonite.ui.compra.PaginaFinalizarCompra;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import org.openqa.selenium.Keys;

public class CompletarCompra implements Task {

    private final DatosCompra datos;

    private CompletarCompra(DatosCompra datos) {
        this.datos = datos;
    }

    public static CompletarCompra conLosDatos(DatosCompra datos) {
        return new CompletarCompra(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaDetalleZapatos.TALLA_CALZADO.of(datos.talla())),
                Click.on(PaginaDetalleZapatos.BOTON_COMPRAR),
                Click.on(PaginaDetalleZapatos.BOTON_FINALIZAR_COMPRA),
                Click.on(PaginaDetalleZapatos.BOTON_CONTINUAR),
                SelectFromOptions.byVisibleText(datos.genero()).from(PaginaFinalizarCompra.SELECTOR_GENERO),
                Enter.theValue(datos.telefono()).into(PaginaFinalizarCompra.TELEFONO),
                Click.on(PaginaFinalizarCompra.SELECTOR_PAIS),
                Enter.theValue(datos.pais()).into(PaginaFinalizarCompra.INPUT_SELECT2),
                Hit.the(Keys.ENTER).into(PaginaFinalizarCompra.INPUT_SELECT2),
                Click.on(PaginaFinalizarCompra.SELECTOR_DEPARTAMENTO),
                Enter.theValue(datos.departamento()).into(PaginaFinalizarCompra.INPUT_SELECT2),
                Hit.the(Keys.ENTER).into(PaginaFinalizarCompra.INPUT_SELECT2),
                Click.on(PaginaFinalizarCompra.SELECTOR_CIUDAD),
                Enter.theValue(datos.ciudad()).into(PaginaFinalizarCompra.INPUT_SELECT2),
                Hit.the(Keys.ENTER).into(PaginaFinalizarCompra.INPUT_SELECT2),
                Enter.theValue(datos.direccion()).into(PaginaFinalizarCompra.DIRECCION),
                JavaScriptClick.on(PaginaFinalizarCompra.ACEPTAR_TERMINOS),
                Click.on(PaginaFinalizarCompra.REGISTRAR_ORDEN),
                Click.on(PaginaFinalizarCompra.BOTON_PAGAR_WOMPI)
        );
    }
}
