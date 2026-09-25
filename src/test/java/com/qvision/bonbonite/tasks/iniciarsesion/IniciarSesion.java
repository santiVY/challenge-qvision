package com.qvision.bonbonite.tasks.iniciarsesion;

import com.qvision.bonbonite.ui.registro.PaginaInicio;
import com.qvision.bonbonite.ui.registro.PaginaLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IniciarSesion implements Task {

    private IniciarSesion() {
    }
    public static IniciarSesion conLasCredencialesDelUsuario() {
        return new IniciarSesion();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaInicio.TOGGLE_MENU_CUENTA),
                Enter.theValue("1216765765").into(PaginaLogin.CAMPO_CORREO),
                Enter.theValue("1234567889").into(PaginaLogin.CAMPO_PASSWORD),
                Click.on(PaginaLogin.BOTON_INICIAR_SESION)
        );
    }
}
