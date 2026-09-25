package com.qvision.bonbonite.tasks.registro;

import com.qvision.bonbonite.models.DatosRegistro;
import com.qvision.bonbonite.ui.registro.PaginaRegistro;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class CompletarFormularioDeRegistro implements Task {

    private final DatosRegistro datos;

    private CompletarFormularioDeRegistro(DatosRegistro datos) {
        this.datos = datos;
    }

    public static CompletarFormularioDeRegistro conLosDatos(DatosRegistro datos) {
        return new CompletarFormularioDeRegistro(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(datos.cedula()).into(PaginaRegistro.CEDULA),
                Enter.theValue(datos.nombre()).into(PaginaRegistro.CAMPO_NOMBRE),
                Enter.theValue(datos.apellido()).into(PaginaRegistro.CAMPO_APELLIDO),
                Enter.theValue(datos.correo()).into(PaginaRegistro.CAMPO_CORREO),
                Enter.theValue(datos.password()).into(PaginaRegistro.CAMPO_PASSWORD),
                Enter.theValue(datos.password()).into(PaginaRegistro.CAMPO_REPETIR_PASSWORD)
        );
    }
}
