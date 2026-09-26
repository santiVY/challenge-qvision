package com.qvision.bonbonite.questions.actualizacion;

import com.qvision.bonbonite.ui.actualizacion.PaginaActualizarDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ActualizacionExitosa implements Question<Boolean> {

    public static ActualizacionExitosa delPerfil() {
        return new ActualizacionExitosa();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(PaginaActualizarDatos.MENSAJE_ACTUALICACION_EXITOSA, isVisible()).forNoMoreThan(10).seconds()
        );
        
        String mensaje = Text.of(PaginaActualizarDatos.MENSAJE_ACTUALICACION_EXITOSA).answeredBy(actor);
        return mensaje.toLowerCase().contains("exitosa") || mensaje.toLowerCase().contains("actualizado");
    }
}
