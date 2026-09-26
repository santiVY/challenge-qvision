package com.qvision.bonbonite.tasks.actualizacion;

import com.qvision.bonbonite.ui.compra.PaginaPrincipal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class AccederASeccionDatos implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaPrincipal.OPCION_DATOS)
        );
    }

    public static AccederASeccionDatos delPerfil() {
        return new AccederASeccionDatos();
    }
}
