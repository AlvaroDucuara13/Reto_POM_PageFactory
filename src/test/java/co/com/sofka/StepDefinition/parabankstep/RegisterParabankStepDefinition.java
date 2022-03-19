package co.com.sofka.StepDefinition.parabankstep;

import co.com.sofka.StepDefinition.setup.WebUi;
import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.RegisterParabankPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.util.TimeSeconds.EIGHT_SECONDS;


public class RegisterParabankStepDefinition extends WebUi {

    private static final Logger LOGGER = Logger.getLogger(RegisterParabankStepDefinition.class);
    private ParabankModel  parabankModel = new ParabankModel();
    private RegisterParabankPage registerParabankPage;
    private static final String MessageConfirm = "Welcome ";
    private static final String MessageError = "Social Security Number is required.";
    private static final String MessagePasswordError = "Passwords did not match.";

    @Given("el cliente accede a la opcion Register de la pagina Parabank")
    public void elClienteAccedeALaOpcionRegisterDeLaPaginaParabank() {

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
    @When("el cliente registra sus datos personales para acceder a los servicios que ofrece parabank")
    public void elClienteRegistraSusDatosPersonalesParaAccederALosServiciosQueOfreceParabank() {
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
            Assertions.assertEquals(RegisterAssert(), registerParabankPage.RegisterFound());
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }

    }
    @Then("el cliente recibira un mensaje de confirmacion en la seccion register")
    public void elClienteRecibiraUnMensajeDeConfirmacionEnLaSeccionRegister() {
        Assertions.assertEquals(RegisterAssert(), registerParabankPage.RegisterFound());
        quiteDriver();

    }
    @When("el cliente registra sus datos personales, pero no ingresa el numero SSN")
    public void elClienteRegistraSusDatosPersonalesPeroNoIngresaElNumeroSSN() {

        try{

            parabankModel.setFirstNameRegister();
            parabankModel.setLastNameRegister();
            parabankModel.setAddressRegister();
            parabankModel.setCityRegister();
            parabankModel.setStateRegister();
            parabankModel.setZipCodeRegister();
            parabankModel.setPhoneRegister();
            parabankModel.setUsernameRegister();
            parabankModel.setPasswordRegister();
            parabankModel.setConfirmPassRegister();

            registerParabankPage = new RegisterParabankPage(driver, parabankModel, EIGHT_SECONDS.getValue());
            registerParabankPage.fillRegister();
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }

    }
    @Then("el cliente recibira un mensaje de advertencia por campo vacio en la seccion register")
    public void elClienteRecibiraUnMensajeDeAdvertenciaPorCampoVacioEnLaSeccionRegister() {
        Assertions.assertEquals(RegisterAssertError(), registerParabankPage.RegisterFoundError());
        LOGGER.warn(MessageError);
        quiteDriver();

    }

    @When("el cliente registra sus datos personales, pero no confirma con exito el password")
    public void elClienteRegistraSusDatosPersonalesPeroNoConfirmaConExitoElPassword() {
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
            parabankModel.setConfirmPassRegisterError();

            registerParabankPage = new RegisterParabankPage(driver, parabankModel, EIGHT_SECONDS.getValue());
            registerParabankPage.fillRegister();
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }

    }
    @Then("el cliente recibira un mensaje de advertencia indicando que la confirmacion del password no es el mismo")
    public void elClienteRecibiraUnMensajeDeAdvertenciaIndicandoQueLaConfirmacionDelPasswordNoEsElMismo() {
        Assertions.assertEquals(RegisterAssertPasswordError(), registerParabankPage.RegisterPasswordFoundError());
        LOGGER.warn(MessagePasswordError);
        quiteDriver();

    }


    private String RegisterAssert(){
        String ComparRegister;
        ComparRegister = MessageConfirm + parabankModel.getUsernameRegister();
        return ComparRegister;
    }

    private String RegisterAssertError(){
        String ComparRegister;
        ComparRegister = MessageError;
        return ComparRegister;
    }

    private String RegisterAssertPasswordError(){
        String ComparRegister;
        ComparRegister = MessagePasswordError;
        return ComparRegister;
    }

}
