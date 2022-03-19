package co.com.sofka.page.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.common.CommonActionsOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactUsParabankPage extends CommonActionsOnPage {
    private static final Logger LOGGER = Logger.getLogger(ContactUsParabankPage.class);
    private ParabankModel parabankModel;
    private static final String ModelNullMessage = "No existe la Pagina!";

    // Constructor
    public ContactUsParabankPage(WebDriver driver, ParabankModel parabankModel, int seconds) {
        super(driver, seconds);
        pageFactoryInitElement(driver, this);
        this.parabankModel = parabankModel;
    }

    // Input test cases
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"contactForm\"]/table")
    private WebElement LocatorContactPage;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"footerPanel\"]/ul[1]/li[8]/a")
    private WebElement ButtonContactUs;

    @CacheLookup
    @FindBy(id = "name")
    private WebElement CompleteNameContactUs;

    @CacheLookup
    @FindBy(id = "email")
    private WebElement EmailContactUs;

    @CacheLookup
    @FindBy(id = "phone")
    private WebElement PhoneContactUs;

    @CacheLookup
    @FindBy(id = "message")
    private WebElement DescriptionContactUs;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"contactForm\"]/table/tbody/tr[5]/td[2]/input")
    private WebElement SendContactUs;

    //For Assertions Test Case
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p[1]")
    private WebElement AssertionMessageConfirm;

    @CacheLookup
    @FindBy(id = "message.errors")
    private WebElement AssertionMessageError;

    //Functionalities
    public void fillContactUs() {
        scrollOn(ButtonContactUs);
        clickOn(ButtonContactUs);

        if (isDisplayed(LocatorContactPage)) {

            scrollOn(CompleteNameContactUs);
            clearOn(CompleteNameContactUs);
            typeOn(CompleteNameContactUs, parabankModel.getNameContactUs());

            scrollOn(EmailContactUs);
            clearOn(EmailContactUs);
            typeOn(EmailContactUs, parabankModel.getEmailContactUs());

            scrollOn(PhoneContactUs);
            clearOn(PhoneContactUs);
            typeOn(PhoneContactUs, parabankModel.getPhoneContactUs());

            scrollOn(DescriptionContactUs);
            clearOn(DescriptionContactUs);
            typeOn(DescriptionContactUs, parabankModel.getMessageContactUs());

            scrollOn(SendContactUs);
            doSubmit(SendContactUs);

        } else {
            LOGGER.warn(ModelNullMessage);
        }

    }

    public String ContactUsFound() {
        String submitedsendToCostumerCare;
        submitedsendToCostumerCare = getText(AssertionMessageConfirm).trim();
        return submitedsendToCostumerCare;
    }

    public String ContactUsFoundError() {
        String submitedsendToCostumerCare;
        submitedsendToCostumerCare = getText(AssertionMessageError).trim();
        return submitedsendToCostumerCare;
    }
}