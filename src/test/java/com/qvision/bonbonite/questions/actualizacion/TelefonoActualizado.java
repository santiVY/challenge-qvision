package com.qvision.bonbonite.questions.actualizacion;

import com.qvision.bonbonite.ui.actualizacion.PaginaActualizarDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TelefonoActualizado implements Question<String> {

    public static TelefonoActualizado enElPerfil() {
        return new TelefonoActualizado();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(PaginaActualizarDatos.VALIDACION_TELEFONO).answeredBy(actor);
    }
}
