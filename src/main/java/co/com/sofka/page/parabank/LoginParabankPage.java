package co.com.sofka.page.parabank;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.common.CommonActionsOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginParabankPage extends CommonActionsOnPage {

    private static final Logger LOGGER = Logger.getLogger(LoginParabankPage.class);
    private ParabankModel parabankModel;
    private static final String ModelNullMessage = "No existe la Pagina!";

    // Constructor
    public LoginParabankPage(WebDriver driver, ParabankModel parabankModel, int seconds) {
        super(driver, seconds);
        pageFactoryInitElement(driver, this);
        this.parabankModel = parabankModel;
    }

    // Input test cases
    @CacheLookup
    @FindBy(xpath= "//*[@id=\"loginPanel\"]/form/p[1]/b")
    private WebElement loginPageLocator;

    @CacheLookup
    @FindBy(xpath= "//*[@id=\"loginPanel\"]/form/div[1]/input")
    private WebElement usernameLogin;

    @CacheLookup
    @FindBy(xpath= "//*[@id=\"loginPanel\"]/form/div[2]/input")
    private WebElement passwordLogin;

    @CacheLookup
    @FindBy(xpath= "//*[@id=\"loginPanel\"]/form/div[3]/input")
    private WebElement sendLogin;

    //For Assertions Test Case
    @CacheLookup
    @FindBy(xpath= "//*[@id=\"accountTable\"]/thead/tr/th[1]")
    private WebElement assertionMessageConfirm;
    @CacheLookup
    @FindBy(xpath= "//*[@id=\"rightPanel\"]/p")
    private WebElement assertionMessageUserLoginError;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[8]/a")
    private WebElement ButtonLogOut;


    //Functionalities
    public void fillLogin(){

        scrollOn(ButtonLogOut);
        clickOn(ButtonLogOut);

        if(isDisplayed(loginPageLocator)) {

            scrollOn(usernameLogin);
            clearOn(usernameLogin);
            typeOn(usernameLogin, parabankModel.getUsernameLogin());

            scrollOn(passwordLogin);
            clearOn(passwordLogin);
            typeOn(passwordLogin, parabankModel.getPasswordLogin());

            scrollOn(sendLogin);
            doSubmit(sendLogin);

        }else{
            LOGGER.warn(ModelNullMessage);
        }
    }

    public String Loginfound(){
        String submitedLogin ;
        submitedLogin = getText(assertionMessageConfirm).trim();
        return submitedLogin;
    }

    public String LoginFoundError(){
        String LoginError ;
        LoginError = getText(assertionMessageUserLoginError).trim();
        return LoginError;
    }

}