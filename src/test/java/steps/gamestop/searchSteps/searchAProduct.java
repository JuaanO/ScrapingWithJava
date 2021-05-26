package steps.gamestop.searchSteps;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.testBase;

public class searchAProduct extends testBase {

    private static final long TIMEOUT = 20;
    @And("add the product to the cart")
    public void addTheProductToTheCart() {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        driver.findElement(By.xpath("//div[@id='add-to-cart-buttons']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='VIEW CART']"))).
                click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()=\"I'm 17 or older\"]"))).click();
    }
}
