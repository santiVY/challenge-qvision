package com.qvision.bonbonite.stepdefinitions.actualizacion;

import com.qvision.bonbonite.models.DatosActualizacion;
import com.qvision.bonbonite.questions.actualizacion.ActualizacionExitosa;
import com.qvision.bonbonite.questions.actualizacion.TelefonoActualizado;
import com.qvision.bonbonite.tasks.actualizacion.AccederASeccionDatos;
import com.qvision.bonbonite.tasks.actualizacion.ActualizarInformacionPerfil;
import com.qvision.bonbonite.tasks.actualizacion.GuardarCambios;
import com.qvision.bonbonite.utils.GeneradorDatosUnicos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ActualizarDatosStepDefinitions {

    private String telefonoActualizado;

    @When("el usuario accede a la seccion datos")
    public void elUsuarioAccedeALaSeccionDatos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AccederASeccionDatos.delPerfil()
        );
    }

    @And("el usuario actualiza su información de perfil con los siguientes datos")
    public void elUsuarioActualizaSuInformacionDePerfilConLosSiguientesDatos(DataTable dataTable) {
        Map<String, String> datosMap = dataTable.asMap(String.class, String.class);

        String telefono = datosMap.get("teléfono");
        if (telefono != null && telefono.equals("DINAMICO")) {
            telefono = GeneradorDatosUnicos.generarTelefono();
        }
        
        this.telefonoActualizado = telefono;
        
        DatosActualizacion datos = new DatosActualizacion(telefono);
        
        OnStage.theActorInTheSpotlight().attemptsTo(
                ActualizarInformacionPerfil.conLosDatos(datos)
        );
    }

    @And("el usuario guarda los cambios")
    public void elUsuarioGuardaLosCambios() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GuardarCambios.deLaInformacion()
        );
    }

    @Then("el sistema debería mostrar un mensaje de actualización exitosa")
    public void elSistemaDeberíaMostrarUnMensajeDeActualizaciónExitosa() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La actualización del perfil fue exitosa",
                        ActualizacionExitosa.delPerfil()),
                seeThat("El teléfono actualizado coincide con el ingresado",
                        TelefonoActualizado.enElPerfil(), equalTo(telefonoActualizado))
        );
    }
}
