package co.com.sofka.page.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.common.CommonActionsOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterParabankPage extends CommonActionsOnPage {

    private static final Logger LOGGER = Logger.getLogger(RegisterParabankPage.class);
    private ParabankModel parabankModel;
    private static final String ModelNullMessage = "No existe la Pagina!";

    // Constructor
    public RegisterParabankPage(WebDriver driver, ParabankModel parabankModel, int seconds) {
        super(driver, seconds);
        pageFactoryInitElement(driver, this);
        this.parabankModel = parabankModel;
    }

    // Input test cases
    @CacheLookup
    @FindBy(xpath= "//*[@id=\"loginPanel\"]/p[2]/a")
    private WebElement ButtonRegister;

    @CacheLookup
    @FindBy(id= "customerForm")
    private WebElement LocatorRegisterPage;

    @CacheLookup
    @FindBy(id= "customer.firstName")
    private WebElement FirstNameRegister;

    @CacheLookup
    @FindBy(id= "customer.lastName")
    private WebElement LastNameRegister;

    @CacheLookup
    @FindBy(id= "customer.address.street")
    private WebElement AddressRegister;

    @CacheLookup
    @FindBy(id= "customer.address.city")
    private WebElement CityRegister;

    @CacheLookup
    @FindBy(id= "customer.address.state")
    private WebElement StateRegister;

    @CacheLookup
    @FindBy(id= "customer.address.zipCode")
    private WebElement ZipCodeRegister;

    @CacheLookup
    @FindBy(id= "customer.phoneNumber")
    private WebElement PhoneRegister;

    @CacheLookup
    @FindBy(id= "customer.ssn")
    private WebElement NumberSSNRegister;

    @CacheLookup
    @FindBy(id= "customer.username")
    private WebElement UserNameRegister;

    @CacheLookup
    @FindBy(id= "customer.password")
    private WebElement PasswordRegister;

    @CacheLookup
    @FindBy(id= "repeatedPassword")
    private WebElement ConfirmPassRegister;

    @CacheLookup
    @FindBy(css= "input[value=Register]")
    private WebElement ApplyRegister;

    //For Assertions Test Case
    @CacheLookup
    @FindBy(xpath= "//*[@id=\"rightPanel\"]/h1")
    private WebElement assertionMessageUserRegistration;

    @CacheLookup
    @FindBy(xpath= "//*[@id=\"repeatedPassword.errors\"]")
    private WebElement assertionMessagePassRepeated;

    @CacheLookup
    @FindBy(id= "customer.ssn.errors")
    private WebElement AssertionMessageError;


    //Functionalities
    public void fillRegister(){
        scrollOn(ButtonRegister);
        clickOn(ButtonRegister);

        if(isDisplayed(LocatorRegisterPage)) {

            scrollOn(FirstNameRegister);
            clearOn(FirstNameRegister);
            typeOn(FirstNameRegister, parabankModel.getFirstNameRegister());

            scrollOn(LastNameRegister);
            clearOn(LastNameRegister);
            typeOn(LastNameRegister, parabankModel.getLastNameRegister());

            scrollOn(AddressRegister);
            clearOn(AddressRegister);
            typeOn(AddressRegister, parabankModel.getAddressRegister());

            scrollOn(CityRegister);
            clearOn(CityRegister);
            typeOn(CityRegister, parabankModel.getCityRegister());

            scrollOn(StateRegister);
            clearOn(StateRegister);
            typeOn(StateRegister, parabankModel.getStateRegister());

            scrollOn(ZipCodeRegister);
            clearOn(ZipCodeRegister);
            typeOn(ZipCodeRegister, parabankModel.getZipCodeRegister());

            scrollOn(PhoneRegister);
            clearOn(PhoneRegister);
            typeOn(PhoneRegister, parabankModel.getPhoneRegister());

            scrollOn(NumberSSNRegister);
            clearOn(NumberSSNRegister);
            typeOn(NumberSSNRegister, parabankModel.getSsnRegister());

            scrollOn(UserNameRegister);
            clearOn(UserNameRegister);
            typeOn(UserNameRegister, parabankModel.getUsernameRegister());

            scrollOn(PasswordRegister);
            clearOn(PasswordRegister);
            typeOn(PasswordRegister, parabankModel.getPasswordRegister());

            scrollOn(ConfirmPassRegister);
            clearOn(ConfirmPassRegister);
            typeOn(ConfirmPassRegister, parabankModel.getConfirmPassRegister());

            scrollOn(ApplyRegister);
            doSubmit(ApplyRegister);

        }else{
            LOGGER.warn(ModelNullMessage);
        }
    }

    public String RegisterFound(){

        String submitedRegister;

        if(isDisplayed(assertionMessagePassRepeated)){
            submitedRegister = getText(assertionMessagePassRepeated).trim();
        }else {
            submitedRegister = getText(assertionMessageUserRegistration).trim();
        }
        return submitedRegister;

    }

    public String RegisterFoundError(){
        String RegisterError;
        RegisterError = getText(AssertionMessageError).trim();
        return RegisterError;
    }


}