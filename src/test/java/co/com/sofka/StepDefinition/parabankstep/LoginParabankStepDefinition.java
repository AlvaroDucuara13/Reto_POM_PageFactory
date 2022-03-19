package co.com.sofka.StepDefinition.parabankstep;
import co.com.sofka.StepDefinition.setup.WebUi;
import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.LoginParabankPage;
import co.com.sofka.page.parabank.RegisterParabankPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.util.TimeSeconds.EIGHT_SECONDS;

public class LoginParabankStepDefinition extends WebUi {
    private static final Logger LOGGER = Logger.getLogger(LoginParabankStepDefinition.class);
    private ParabankModel  parabankModel = new ParabankModel();
    private LoginParabankPage loginParabankPage;
    private RegisterParabankPage registerParabankPage;
    private static final String MessageConfirm = "Account";
    private static final String MessageError = "Please enter a username and password.";

    @Given("el usuario accede a la opcion Customer Login del home principal de la plataforma Parabank")
    public void elUsuarioAccedeALaOpcionCustomerLoginDelHomePrincipalDeLaPlataformaParabank() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();


        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }

    }
    @When("el cliente ingresa sus credenciales usuario y password")
    public void elClienteIngresaSusCredencialesUsuarioYPassword() {
        try{

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

            registerParabankPage = new RegisterParabankPage(driver, parabankModel, EIGHT_SECONDS.getValue());
            registerParabankPage.fillRegister();

            parabankModel.setUsernameLogin();
            parabankModel.setPasswordLogin();

            loginParabankPage = new LoginParabankPage(driver, parabankModel, EIGHT_SECONDS.getValue());
            loginParabankPage.fillLogin();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }

    }
    @Then("el cliente accede a los servicios que ofrece Parabank")
    public void elClienteAccedeALosServiciosQueOfreceParabank() {
        Assertions.assertEquals(forSubmittedLogin(), loginParabankPage.Loginfound());
        quiteDriver();
    }

    @When("el cliente no ingresa ninguna credencial de autentificacion")
    public void elClienteNoIngresaNingunaCredencialDeAutentificacion() {

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

        registerParabankPage = new RegisterParabankPage(driver, parabankModel, EIGHT_SECONDS.getValue());
        registerParabankPage.fillRegister();

        loginParabankPage = new LoginParabankPage(driver, parabankModel, EIGHT_SECONDS.getValue());
        loginParabankPage.fillLogin();

    }
    @Then("el cliente recibira un mensaje de advertencia sobre los campos vacios de la seccion Login")
    public void elClienteRecibiraUnMensajeDeAdvertenciaSobreLosCamposVaciosDeLaSeccionLogin() {
        Assertions.assertEquals(LoginError(), loginParabankPage.LoginFoundError());
        LOGGER.warn(MessageError);
        quiteDriver();
    }

    private String forSubmittedLogin() {
        String submitedLogin;
        submitedLogin = MessageConfirm;
        return submitedLogin;
    }

    private String LoginError() {
        String AssertLoginError;
        AssertLoginError = MessageError;
        return AssertLoginError;
    }
}
