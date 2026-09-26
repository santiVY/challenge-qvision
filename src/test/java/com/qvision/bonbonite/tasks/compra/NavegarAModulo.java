package com.qvision.bonbonite.tasks.compra;

import com.qvision.bonbonite.ui.compra.PaginaPrincipal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class NavegarAModulo implements Task {

    private final String modulo;

    private NavegarAModulo(String modulo) {
        this.modulo = modulo;
    }

    public static NavegarAModulo llamado(String modulo) {
        return new NavegarAModulo(modulo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaPrincipal.OPCION_MENU.of(modulo))
        );
    }
}
