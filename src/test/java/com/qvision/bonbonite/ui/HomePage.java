package com.qvision.bonbonite.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target BODY = Target.the("body element").located(By.cssSelector("body"));
    public static final Target HEADER = Target.the("header").located(By.cssSelector("header"));
}
