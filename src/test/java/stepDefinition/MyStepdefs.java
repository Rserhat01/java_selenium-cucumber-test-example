package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SubmitPage;
import utilites.MyDriver;

import java.time.Duration;

public class MyStepdefs {
    private static WebDriver driver;
    SubmitPage submitPage;

    @Given("go to login page")
    public void goToLoginPage() {
        driver = MyDriver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @And("down scroll bar")
    public void downScrollBar() {
        submitPage = new SubmitPage(driver);

    }

    @And("type name as {string}")
    public void typeNameAs(String firstName) {
        submitPage.setFirstName(firstName);
    }

    @And("type lastname as {string}")
    public void typeLastnameAs(String lastName) {
        submitPage.setLastName(lastName);
    }

    @And("type email as {string}")
    public void typeEmailAs(String email) {
        submitPage.setEmail(email);
    }


    @And("type number as {string}")
    public void typeNumberAs(String number) {
        submitPage.setPhoneNumber(number);
    }


    @And("type subject as {string}")
    public void typeSubjectAs(String subject) {
        submitPage.setSubject(subject);
    }


    @And("upload image {string}")
    public void uploadImage(String path) {
        submitPage.uploadImage(path);
    }

    @And("type address as {string}")
    public void typeAddressAs(String address) {
        submitPage.setAddress(address);
    }

    @And("select state {string}")
    public void selectState(String state) {
        submitPage.selectState(state);
    }

    @And("select city {string}")
    public void selectCity(String city) {
        submitPage.selectCity(city);
    }

    @When("click submit button")
    public void clickSubmitButton() {
        submitPage.pressSubmitButton();
    }

    @Then("success submit message")
    public void successSubmitMessage() {
        submitPage.assertSuccess();
    }
}
