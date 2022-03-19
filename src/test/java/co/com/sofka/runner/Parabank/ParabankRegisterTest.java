package co.com.sofka.runner.Parabank;

import co.com.sofka.StepDefinition.setup.WebUi;
import co.com.sofka.model.parabank.ParabankModel;
import co.com.sofka.page.parabank.RegisterParabankPage;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static co.com.sofka.util.TimeSeconds.EIGHT_SECONDS;


public class ParabankRegisterTest extends WebUi {
    private ParabankModel parabankModel;
    private static final String MessageError = "PASSWORDS DO NOT MATCH";
    private static final String MessageConfirm = "Welcome ";
    private static final Logger LOGGER = Logger.getLogger(ParabankRegisterTest.class);


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
        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(),exception);
        }
    }

    @Test
    public void parabankTestMandatoryFieldsRegister(){
        try{
            RegisterParabankPage registerParabankPage = new RegisterParabankPage(driver, parabankModel, EIGHT_SECONDS.getValue());
            registerParabankPage.fillRegister();
            Assertions.assertEquals(RegisterAssert(), registerParabankPage.RegisterFound());
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

    private String RegisterAssert(){
        String ComparRegister;
        if(parabankModel.getPasswordRegister()!=parabankModel.getConfirmPassRegister()){
            ComparRegister = MessageError;
            LOGGER.warn(MessageError);
        }else{
            ComparRegister = MessageConfirm + parabankModel.getUsernameRegister();
        }
        return ComparRegister;
    }


}
