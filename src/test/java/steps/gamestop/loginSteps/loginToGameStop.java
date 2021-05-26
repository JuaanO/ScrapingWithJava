package steps.gamestop.loginSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.testBase;

import static java.lang.Thread.sleep;

public class loginToGameStop extends testBase {

    private static final long TIMEOUT = 20;

    @Given("a user correctly logged to gameStop")
    public void aUserCorrectlyLoggedToGameStop() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        driver.findElement(By.xpath("//*[@id='account-modal-link-nocache']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='signIn']")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='login-form-email']"))).
                sendKeys("juanjose_@hotmail.es");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='login-form-password']"))).
                sendKeys("Iwannabeudog1");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Sign in']"))).
                click();

    }
    @When("^I searches for a (.*?) to buy$")
    public void elUsuarioBuscaComprar(String products) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='q']"))).
                sendKeys(products);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='search-icon']"))).
                click();
        sleep(2000);
        WebElement element = driver.findElement(By.xpath("//p[normalize-space()='"+products+"']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

}
