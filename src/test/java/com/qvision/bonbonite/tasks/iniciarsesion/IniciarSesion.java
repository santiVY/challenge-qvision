package com.qvision.bonbonite.tasks.iniciarsesion;

import com.qvision.bonbonite.models.DatosInicioSesion;
import com.qvision.bonbonite.ui.registro.PaginaInicio;
import com.qvision.bonbonite.ui.registro.PaginaLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IniciarSesion implements Task {

    private final DatosInicioSesion datos;

    private IniciarSesion(DatosInicioSesion datos) {
        this.datos = datos;
    }
    public static IniciarSesion conLasCredencialesDelUsuario(DatosInicioSesion datosInicioSesion) {
        return new IniciarSesion(datosInicioSesion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaInicio.TOGGLE_MENU_CUENTA),
                Enter.theValue(datos.cedula()).into(PaginaLogin.CAMPO_CORREO),
                Enter.theValue(datos.password()).into(PaginaLogin.CAMPO_PASSWORD),
                Click.on(PaginaLogin.BOTON_INICIAR_SESION)
        );
    }
}
