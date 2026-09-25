package com.qvision.bonbonite.questions;

import com.qvision.bonbonite.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Visibility;

@Subject("home page loaded")
public class HomePageLoaded implements Question<Boolean> {

    public static HomePageLoaded correctly() {
        return new HomePageLoaded();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(HomePage.BODY).answeredBy(actor);
    }
}
