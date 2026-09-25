package com.qvision.bonbonite.stepdefinitions.iniciarsesion;

import com.qvision.bonbonite.models.DatosRegistro;
import com.qvision.bonbonite.questions.registro.RegistroExitoso;
import com.qvision.bonbonite.tasks.iniciarsesion.IniciarSesion;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsStringIgnoringCase;


/**
 * Nota: el step "Given que el usuario se encuentra en la página de inicio de Bon-Bonite"
 * ya existe en el step definition del smoke test (según el README) y se reutiliza aquí
 * al ser el mismo texto Gherkin, así que no se vuelve a implementar.
 */
public class IniciarSesionStepDefinitions {

    @When("el usuario ingresas sus credenciales")
    public void elUsuarioIngresasSusCredenciales() {
        theActorInTheSpotlight().attemptsTo(
                IniciarSesion.conLasCredencialesDelUsuario());
    }

    @Then("el usuario vera el menu de inicio con su nombre de usuario")
    public void elUsuarioVeElMenuDeinicioConSuNombreDeUsuario() {
        theActorInTheSpotlight().should(
                seeThat(RegistroExitoso.alObtenerNombreDeUsuario(), containsStringIgnoringCase("Rocio"))
        );
    }
}
