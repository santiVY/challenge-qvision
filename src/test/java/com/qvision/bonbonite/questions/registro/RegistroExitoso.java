package com.qvision.bonbonite.questions.registro;

import com.qvision.bonbonite.ui.registro.PaginaCuentaUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class RegistroExitoso implements Question<String> {

    public static RegistroExitoso alObtenerNombreDeUsuario() {
        return new RegistroExitoso();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(PaginaCuentaUsuario.NOMBRE_USUARIO).answeredBy(actor).toLowerCase();
    }
}
