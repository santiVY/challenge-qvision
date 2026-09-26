package com.qvision.bonbonite.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.core.environment.WebDriverConfiguredEnvironment;

public class AbrirBonBonite implements Task {

    public static AbrirBonBonite isPaginaPrincipal() {
        return new AbrirBonBonite();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String baseUrl = WebDriverConfiguredEnvironment.getEnvironmentVariables()
                .getProperty("webdriver.base.url");
        actor.attemptsTo(
            Open.url(baseUrl)
        );
    }
}
