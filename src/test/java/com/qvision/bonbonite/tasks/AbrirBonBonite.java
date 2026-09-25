package com.qvision.bonbonite.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirBonBonite implements Task {

    private static final String URL = "https://www.bon-bonite.com/";

    public static AbrirBonBonite isPaginaPrincipal() {
        return new AbrirBonBonite();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Open.url(URL)
        );
    }
}
