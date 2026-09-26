package com.qvision.bonbonite.tasks.compra;

import com.qvision.bonbonite.ui.compra.PaginaZapatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionarZapato implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaZapatos.IMAGE_ZAPATOS)
        );
    }

    public static SeleccionarZapato delCatalogo() {
        return new SeleccionarZapato();
    }
}
