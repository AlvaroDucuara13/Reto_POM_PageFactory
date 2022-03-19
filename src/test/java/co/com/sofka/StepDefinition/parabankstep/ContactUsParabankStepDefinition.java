package co.com.sofka.StepDefinition.parabankstep;

import co.com.sofka.StepDefinition.setup.WebUi;

import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ContactUsParabankPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.util.TimeSeconds.EIGHT_SECONDS;


public class ContactUsParabankStepDefinition extends WebUi {
    private static final Logger LOGGER = Logger.getLogger(ContactUsParabankStepDefinition.class);
    private ParabankModel parabankModel;
    private ContactUsParabankPage contactUsParabankPage;
    private static final String MessageConfirm = "Thank you ";
    private static final String MessageError = "Message is required.";

    @Given("el cliente selecciona la opcion ContacUs de la pagina Parabank")
    public void elClienteSeleccionaLaOpcionContacUsDeLaPaginaParabank() {

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
    @When("el cliente registra un nombre, un email, un numero de telefono, un mensaje y culmina la accion")
    public void elClienteRegistraUnNombreUnEmailUnNumeroDeTelefonoUnMensajeYCulminaLaAccion() {

        try{

            parabankModel = new ParabankModel();
            parabankModel.setNameContactUs();
            parabankModel.setEmailContactUs();
            parabankModel.setPhoneContactUs();
            parabankModel.setMessageContactUs();

            contactUsParabankPage = new ContactUsParabankPage(driver, parabankModel, EIGHT_SECONDS.getValue());
            contactUsParabankPage.fillContactUs();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }

    }
    @Then("el cliente recibira un mensaje de confirmacion")
    public void elClienteRecibiraUnMensajeDeConfirmacion() {
        Assertions.assertEquals(ContactUsAssert(), contactUsParabankPage.ContactUsFound());
        quiteDriver();

    }
    @When("el cliente registra un nombre, un email, un numero de telefono, pero no ingresa el mensaje a enviar")
    public void elClienteRegistraUnNombreUnEmailUnNumeroDeTelefonoPeroNoIngresaElMensajeAEnviar() {
        try{

            parabankModel = new ParabankModel();
            parabankModel.setNameContactUs();
            parabankModel.setEmailContactUs();
            parabankModel.setPhoneContactUs();

            contactUsParabankPage = new ContactUsParabankPage(driver, parabankModel, EIGHT_SECONDS.getValue());
            contactUsParabankPage.fillContactUs();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }

    }
    @Then("el cliente recibira un mensaje de advertencia por campo vacio")
    public void elClienteRecibiraUnMensajeDeAdvertenciaPorCampoVacio() {

        Assertions.assertEquals(ContactUsAssertError(), contactUsParabankPage.ContactUsFoundError());
        LOGGER.warn(MessageError);
        quiteDriver();

    }

    private String ContactUsAssert(){
        String AssertContactUs;
        AssertContactUs = MessageConfirm +parabankModel.getNameContactUs();
        return AssertContactUs;
    }

    private String ContactUsAssertError(){
        String AssertContactUs;
        AssertContactUs = MessageError ;
        return AssertContactUs;
    }


}
