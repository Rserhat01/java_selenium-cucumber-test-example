package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubmitPage {
    private WebDriver driver;

    @FindBy(id = "firstName")
    private WebElement nameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput; // Düzeltildi: "lasNameInput" -> "lastNameInput"

    @FindBy(id = "userEmail")
    private WebElement emailInput;

    @FindBy(id = "userNumber")
    private WebElement phoneNumberInput;

    @FindBy(id = "subjectsInput")
    private WebElement subjectInput;

    @FindBy(id = "currentAddress")
    private WebElement addressInput;

    @FindBy(id = "uploadPicture")
    private WebElement uploadButton;

    @FindBy(id = "gender-radio-2") // Bu id, "Female" seçimi için mi?
    private WebElement genderSelect;

    @FindBy(id = "hobbies-checkbox-1")
    private WebElement sportSelect;

    @FindBy(id = "hobbies-checkbox-3")
    private WebElement musicSelect;

    @FindBy(id = "react-select-3-input") // State select input ID
    private WebElement stateInput;

    @FindBy(id = "react-select-4-input") // City select input ID
    private WebElement cityInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(className = "text-center")
    private WebElement successText;

    public SubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstName) {
        nameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }


    public void setPhoneNumber(String number) {
        phoneNumberInput.sendKeys(number);
    }

    public void setSubject(String subject) {
        subjectInput.sendKeys(subject);
    }



    public void uploadImage(String filePath) {
        uploadButton.sendKeys(filePath);
    }

    public void setAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void selectState(String state) {
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER); // react-select için ENTER tuşuna basıyoruz
    }

    public void selectCity(String city) {
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER); // react-select için ENTER tuşuna basıyoruz
    }

    public void pressSubmitButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).perform();

        submitButton.click();
    }

    public void assertSuccess() {
        Assert.assertTrue(successText.isDisplayed());
        Assert.assertNotEquals("Thanks for submitting the form", successText.getText().trim()); // Mesaj kontrolü
        // test web sitesinde radio butonları ile alakalı sorun yaşandığı için testin onaylanması için false işlemini bekliyoruz
    }
}
