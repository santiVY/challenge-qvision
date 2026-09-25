package com.qvision.bonbonite.stepdefinitions.iniciarsesion;
import com.qvision.bonbonite.models.DatosInicioSesion;
import com.qvision.bonbonite.models.DatosRegistro;
import com.qvision.bonbonite.questions.registro.RegistroExitoso;
import com.qvision.bonbonite.tasks.iniciarsesion.IniciarSesion;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsStringIgnoringCase;


public class IniciarSesionStepDefinitions {

    private DatosInicioSesion datosInicioSesion;

    @When("el usuario ingresas sus credenciales")
    public void elUsuarioIngresasSusCredenciales(DataTable dataTable) {

        Map<String, String> filas = dataTable.asMap(String.class, String.class);

        datosInicioSesion = new DatosInicioSesion(
                filas.get("cedula"),
                filas.get("password"));

        theActorInTheSpotlight().attemptsTo(
                IniciarSesion.conLasCredencialesDelUsuario(datosInicioSesion));
    }

    @Then("el usuario vera el menu de inicio con su nombre de usuario")
    public void elUsuarioVeElMenuDeInicioConSuNombreDeUsuario() {
        theActorInTheSpotlight().should(
                seeThat(RegistroExitoso.alObtenerNombreDeUsuario(), containsStringIgnoringCase("Rocio"))
        );
    }
}
