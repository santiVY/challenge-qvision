package com.qvision.bonbonite.tasks.actualizacion;

import com.qvision.bonbonite.ui.actualizacion.PaginaActualizarDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class GuardarCambios implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaActualizarDatos.BOTON_GUARDAR)
        );
    }

    public static GuardarCambios deLaInformacion() {
        return new GuardarCambios();
    }
}
