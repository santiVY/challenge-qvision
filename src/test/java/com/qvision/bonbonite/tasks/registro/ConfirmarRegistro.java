package com.qvision.bonbonite.tasks.registro;

import com.qvision.bonbonite.ui.registro.PaginaRegistro;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ConfirmarRegistro implements Task {

    public static ConfirmarRegistro elUsuario() {
        return new ConfirmarRegistro();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaRegistro.CHECK_DATOS_PERSONALES),
                Click.on(PaginaRegistro.ENLACE_REGISTRO)
        );
    }
}
