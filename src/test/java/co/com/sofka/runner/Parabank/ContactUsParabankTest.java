package co.com.sofka.runner.Parabank;

import co.com.sofka.StepDefinition.setup.WebUi;
import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.ContactUsParabankPage;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static co.com.sofka.util.TimeSeconds.EIGHT_SECONDS;

public class ContactUsParabankTest extends WebUi {

    private ParabankModel parabankModel;
    private static final Logger LOGGER = Logger.getLogger(ContactUsParabankTest.class);
    private static final String MESSAGE_CONFIRM = "Thank you ";

    @BeforeEach
    public void setUp(){
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();


            parabankModel = new ParabankModel();
            parabankModel.setNameContactUs();
            parabankModel.setEmailContactUs();
            parabankModel.setPhoneContactUs();
            parabankModel.setMessageContactUs();
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @Test
    public void parabankTestMandatoryFieldsContactUs(){
        try{
            ContactUsParabankPage contactUsParabankPage = new ContactUsParabankPage(driver, parabankModel, EIGHT_SECONDS.getValue());
            contactUsParabankPage.fillContactUs();
            Assertions.assertEquals(ContactUsAssert(), contactUsParabankPage.ContactUsFound());
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

    private String ContactUsAssert(){
        String AssertContactUs;
        AssertContactUs = MESSAGE_CONFIRM+parabankModel.getNameContactUs();
        return AssertContactUs;
    }
}
