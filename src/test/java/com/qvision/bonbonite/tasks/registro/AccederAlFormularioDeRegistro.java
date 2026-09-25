package com.qvision.bonbonite.tasks.registro;

import com.qvision.bonbonite.ui.iniciosesion.PaginaInicio;
import com.qvision.bonbonite.ui.iniciosesion.PaginaLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class AccederAlFormularioDeRegistro implements Task {

    public static AccederAlFormularioDeRegistro elUsuario() {
        return new AccederAlFormularioDeRegistro();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaInicio.TOGGLE_MENU_CUENTA),
                Click.on(PaginaLogin.ENLACE_REGISTRO)
        );
    }
}
