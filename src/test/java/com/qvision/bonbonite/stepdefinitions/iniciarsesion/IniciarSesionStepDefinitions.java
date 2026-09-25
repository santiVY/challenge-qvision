package com.qvision.bonbonite.stepdefinitions.iniciarsesion;
import com.qvision.bonbonite.questions.registro.RegistroExitoso;
import com.qvision.bonbonite.tasks.iniciarsesion.IniciarSesion;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsStringIgnoringCase;


public class IniciarSesionStepDefinitions {

    @When("el usuario ingresas sus credenciales")
    public void elUsuarioIngresasSusCredenciales() {
        theActorInTheSpotlight().attemptsTo(
                IniciarSesion.conLasCredencialesDelUsuario());
    }

    @Then("el usuario vera el menu de inicio con su nombre de usuario")
    public void elUsuarioVeElMenuDeInicioConSuNombreDeUsuario() {
        theActorInTheSpotlight().should(
                seeThat(RegistroExitoso.alObtenerNombreDeUsuario(), containsStringIgnoringCase("Rocio"))
        );
    }
}
