package com.qvision.bonbonite.ui.actualizacion;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaActualizarDatos {

    public static final Target BOTON_ACTUALIZAR = Target.the("Botón actualizar información")
            .locatedBy("#profile-update-form button.update-info-btn");

    public static final Target TELEFONO = Target.the("Teléfono cliente").located(By.name("billing_phone"));

    public static final Target BOTON_GUARDAR= Target.the("Botón guardar información")
            .locatedBy("form#profile-update-form button.save-info-btn");

    public static final Target VALIDACION_TELEFONO = Target.the("Validación teléfono")
            .located(By.cssSelector("[data-field=billing_phone]"));

    public static final Target MENSAJE_ACTUALICACION_EXITOSA = Target.the("Mensaje de actualización exitosa")
            .located(By.cssSelector("[class='text-lg']:not([id=password-message-text][class='text-lg'])"));
}