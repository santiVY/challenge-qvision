package com.qvision.bonbonite.stepdefinitions;

import com.qvision.bonbonite.tasks.AbrirBonBonite;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


public class InicioPaginaStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el usuario se encuentra en la página principal de Bon-Bonite")
    public void queElUsuarioSeEncuentraEnLaPáginaPrincipalDeBonBonite() {
        OnStage.theActorCalled("Santiago").attemptsTo(
            AbrirBonBonite.isPaginaPrincipal()
        );
    }

}
