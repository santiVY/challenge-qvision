package com.qvision.bonbonite.questions.compra;

import com.qvision.bonbonite.ui.compra.PaginaPasarela;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PasarelaPagosActiva implements Question<Boolean> {

    public static PasarelaPagosActiva conNequiDisponible() {
        return new PasarelaPagosActiva();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WebDriver driver = actor.usingAbilityTo(net.serenitybdd.screenplay.abilities.BrowseTheWeb.class).getDriver();

        actor.attemptsTo(
                WaitUntil.the(PaginaPasarela.IFRAME_WOMPI, isVisible()).forNoMoreThan(10).seconds()
        );
        
        driver.switchTo().frame(PaginaPasarela.IFRAME_WOMPI.resolveFor(actor));
        
        boolean nequiVisible = Visibility.of(PaginaPasarela.BOTON_NEQUI).answeredBy(actor);
        
        driver.switchTo().defaultContent();
        
        return nequiVisible;
    }
}
