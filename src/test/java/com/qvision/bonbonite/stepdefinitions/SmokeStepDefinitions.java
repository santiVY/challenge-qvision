package com.qvision.bonbonite.stepdefinitions;

import com.qvision.bonbonite.questions.HomePageLoaded;
import com.qvision.bonbonite.tasks.OpenBonBonite;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class SmokeStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el usuario se encuentra en la página principal de Bon-Bonite")
    public void queElUsuarioSeEncuentraEnLaPáginaPrincipalDeBonBonite() {
        OnStage.theActorCalled("Santiago").attemptsTo(
            OpenBonBonite.homePage()
        );
    }

    @Then("debería visualizar correctamente la página principal")
    public void deberíaVisualizarCorrectamenteLaPáginaPrincipal() {
        OnStage.theActorInTheSpotlight().should(
            seeThat(HomePageLoaded.correctly(), is(true))
        );
    }
}
