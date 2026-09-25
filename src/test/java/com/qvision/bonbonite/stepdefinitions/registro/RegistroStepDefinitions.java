package com.qvision.bonbonite.stepdefinitions.registro;

import com.qvision.bonbonite.models.DatosRegistro;
import com.qvision.bonbonite.questions.registro.RegistroExitoso;
import com.qvision.bonbonite.tasks.registro.AccederAlFormularioDeRegistro;
import com.qvision.bonbonite.tasks.registro.CompletarFormularioDeRegistro;
import com.qvision.bonbonite.tasks.registro.ConfirmarRegistro;
import com.qvision.bonbonite.utils.GeneradorDatosUnicos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.is;

/**
 * Nota: el step "Given que el usuario se encuentra en la página de inicio de Bon-Bonite"
 * ya existe en el step definition del smoke test (según el README) y se reutiliza aquí
 * al ser el mismo texto Gherkin, así que no se vuelve a implementar.
 */
public class RegistroStepDefinitions {

    private DatosRegistro datosRegistro;

    @When("el usuario accede al formulario de registro")
    public void elUsuarioAccedeAlFormularioDeRegistro() {
        theActorInTheSpotlight().attemptsTo(
                AccederAlFormularioDeRegistro.elUsuario()
        );
    }

    @And("el usuario completa el formulario de registro con los siguientes datos")
    public void elUsuarioCompletaElFormularioDeRegistro(DataTable dataTable) {
        Map<String, String> filas = dataTable.asMap(String.class, String.class);

        String cedula = obtenerValorDinamicoSiEsNecesario(filas.get("cedula"), "cedula");
        String nombre = obtenerValorDinamicoSiEsNecesario(filas.get("nombre"), "nombre");
        String apellido = obtenerValorDinamicoSiEsNecesario(filas.get("apellido"), "apellido");
        String correo = obtenerValorDinamicoSiEsNecesario(filas.get("correo"), "correo", nombre, apellido);
        String password = obtenerValorDinamicoSiEsNecesario(filas.get("password"), "password");

        datosRegistro = new DatosRegistro(cedula, nombre, apellido, correo, password);

        theActorInTheSpotlight().attemptsTo(
                CompletarFormularioDeRegistro.conLosDatos(datosRegistro)
        );
    }


    @And("el usuario confirma el registro")
    public void elUsuarioConfirmaElRegistro() {
        theActorInTheSpotlight().attemptsTo(
                ConfirmarRegistro.elUsuario()
        );
    }

    @Then("el usuario verá la pagina de inicio con su usuario registrado")
    public void elSistemaDeberiaMostrarUnMensajeDeRegistroExitoso() {
        theActorInTheSpotlight().should(
                seeThat(RegistroExitoso.alObtenerNombreDeUsuario(), containsStringIgnoringCase(datosRegistro.nombre()))
        );
    }

    private String obtenerValorDinamicoSiEsNecesario(String valor, String tipoCampo) {
        return obtenerValorDinamicoSiEsNecesario(valor, tipoCampo, null, null);
    }

    private String obtenerValorDinamicoSiEsNecesario(String valor, String tipoCampo, String nombre, String apellido) {
        if (valor == null || valor.trim().isEmpty() || valor.equalsIgnoreCase("DINAMICO")) {
            switch (tipoCampo) {
                case "cedula":
                    return GeneradorDatosUnicos.generarCedula();
                case "nombre":
                    return GeneradorDatosUnicos.generarNombre();
                case "apellido":
                    return GeneradorDatosUnicos.generarApellido();
                case "correo":
                    return GeneradorDatosUnicos.generarCorreo(nombre, apellido);
                case "password":
                    return GeneradorDatosUnicos.generarPassword();
                default:
                    return valor;
            }
        }
        return valor;
    }

}
