package co.com.sofka.runner.Parabank;

import co.com.sofka.StepDefinition.setup.WebUi;
import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.LoginParabankPage;
import co.com.sofka.page.parabank.RegisterParabankPage;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static co.com.sofka.util.TimeSeconds.EIGHT_SECONDS;

public class LoginParabankTest extends WebUi {
    private ParabankModel parabankModel;
    private static final Logger LOGGER = Logger.getLogger(LoginParabankTest.class);
    private static final String MESSAGE_CONFIRM = "Account";


    @BeforeEach
    public void setUp(){
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            parabankModel = new ParabankModel();
            parabankModel.setFirstNameRegister();
            parabankModel.setLastNameRegister();
            parabankModel.setAddressRegister();
            parabankModel.setCityRegister();
            parabankModel.setStateRegister();
            parabankModel.setZipCodeRegister();
            parabankModel.setPhoneRegister();
            parabankModel.setSsnRegister();
            parabankModel.setUsernameRegister();
            parabankModel.setPasswordRegister();
            parabankModel.setConfirmPassRegister();

            RegisterParabankPage registerParabankPage = new RegisterParabankPage(driver, parabankModel, EIGHT_SECONDS.getValue());
            registerParabankPage.fillRegister();

            parabankModel.setUsernameLogin();
            parabankModel.setPasswordLogin();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @Test
    public void parabankTestLogin(){
        try{
            LoginParabankPage loginParabankPage = new LoginParabankPage(driver, parabankModel, EIGHT_SECONDS.getValue());
            loginParabankPage.fillLogin();
            Assertions.assertEquals(forSubmittedLogin(), loginParabankPage.Loginfound());
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @AfterEach
    public void tearDown(){
        quiteDriver();
    }

    private String forSubmittedLogin() {
        String submitedLogin;
        submitedLogin = MESSAGE_CONFIRM;
        return submitedLogin;
    }

}
