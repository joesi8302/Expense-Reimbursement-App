package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ReimbPOM {
    WebDriver driver;

    Wait<WebDriver> wait;

    WebElement usernameInputElem;
    WebElement passwordInputElem;

    By usernameSelector = By.id("username-input");
    By passwordSelector = By.id("password-input");
    By amountSelector = By.id("amountInput");
    By descriptionSelector = By.id("descriptionInput");
    By typeSelector = By.id("typeInput");
    By submitReimbSelector = By.id("reimbSubmit");




    public ReimbPOM(WebDriver driver){
        this.driver = driver;

    }

    public void userLogin(String username, String password, String amount, String description, String type){
        this.wait = new FluentWait<>(this.driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500));
        this.usernameInputElem = this.driver.findElement(usernameSelector);
        this.passwordInputElem = this.driver.findElement(passwordSelector);
        usernameInputElem.sendKeys(username);
        passwordInputElem.sendKeys(password + Keys.ENTER);


    }

    public void createReimb(String amount, String description, String type){
        //driver.getCurrentUrl();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amountInput")));

        WebElement amountInputElem = this.driver.findElement(By.id("amountInput"));
        WebElement descriptionInputElem = this.driver.findElement(By.id("descriptionInput"));
        Select typeInputElem = new Select(this.driver.findElement(By.id("typeInput")));
        WebElement submitReimbBtnElem = this.driver.findElement(By.id("reimbSubmit"));

        amountInputElem.sendKeys(amount);
        descriptionInputElem.sendKeys(description);
        typeInputElem.selectByVisibleText(type);
        submitReimbBtnElem.click();

    }

//    public WebElement getAmountInputElem(){
//
//    }

}
