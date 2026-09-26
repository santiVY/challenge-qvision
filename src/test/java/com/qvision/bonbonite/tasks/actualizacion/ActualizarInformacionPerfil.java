package com.qvision.bonbonite.tasks.actualizacion;

import com.qvision.bonbonite.models.DatosActualizacion;
import com.qvision.bonbonite.ui.actualizacion.PaginaActualizarDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Clear;

public class ActualizarInformacionPerfil implements Task {

    private final DatosActualizacion datos;

    private ActualizarInformacionPerfil(DatosActualizacion datos) {
        this.datos = datos;
    }

    public static ActualizarInformacionPerfil conLosDatos(DatosActualizacion datos) {
        return new ActualizarInformacionPerfil(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaActualizarDatos.BOTON_ACTUALIZAR),
                Click.on(PaginaActualizarDatos.TELEFONO),
                Clear.field(PaginaActualizarDatos.TELEFONO),
                Enter.theValue(datos.telefono()).into(PaginaActualizarDatos.TELEFONO)
        );
    }
}
