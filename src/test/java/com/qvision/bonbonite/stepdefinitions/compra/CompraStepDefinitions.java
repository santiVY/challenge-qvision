package com.qvision.bonbonite.stepdefinitions.compra;

import com.qvision.bonbonite.models.DatosCompra;
import com.qvision.bonbonite.questions.compra.PasarelaPagosActiva;
import com.qvision.bonbonite.tasks.compra.CompletarCompra;
import com.qvision.bonbonite.tasks.compra.NavegarAModulo;
import com.qvision.bonbonite.tasks.compra.SeleccionarZapato;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CompraStepDefinitions {

    @When("el usuario navega al módulo {string}")
    public void elUsuarioNavegaAlModulo(String modulo) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarAModulo.llamado(modulo)
        );
    }

    @When("el usuario realiza la compra de un producto disponible")
    public void elUsuarioRealizaLaCompraDeUnProductoDisponible(DataTable dataTable) {
        Map<String, String> datosMap = dataTable.asMap(String.class, String.class);
        DatosCompra datos = new DatosCompra(
                datosMap.get("talla"),
                datosMap.get("genero"),
                datosMap.get("telefono"),
                datosMap.get("pais"),
                datosMap.get("departamento"),
                datosMap.get("ciudad"),
                datosMap.get("direccion")
        );
        
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarZapato.delCatalogo(),
                CompletarCompra.conLosDatos(datos)
        );
    }

    @Then("el sistema debería ver la pasarela de pagos activa para la compra")
    public void elSistemaDeberíaVerLaPasarelaDePagosActivaParaLaCompra() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("La pasarela de pagos con Nequi está activa",
                        PasarelaPagosActiva.conNequiDisponible())
        );
    }
}
