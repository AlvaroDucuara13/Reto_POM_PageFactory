package co.com.sofka.model.parabank;


import com.github.javafaker.Faker;

import java.util.Locale;

public class ParabankModel {

    // ContactUs
    private String nameContactUs;
    private String emailContactUs;
    private String phoneContactUs;
    private String messageContactUs="";

    // Register
    private String firstNameRegister ;
    private String lastNameRegister;
    private String addressRegister;
    private String cityRegister;
    private String stateRegister;
    private String zipCodeRegister;
    private String phoneRegister;
    private String ssnRegister="";
    private String usernameRegister;
    private String passwordRegister;
    private String confirmPassRegister;

    // LoginUser
    private String usernameLogin="";
    private String passwordLogin="";

    //Datos de usuario Random
    Faker DatosRandom = new Faker(new Locale("es-MX"));
    String FirstName = DatosRandom.name().firstName();
    String LastName = DatosRandom.name().lastName();
    String CompleteName = FirstName +" "+ LastName;
    String Address = DatosRandom.address().secondaryAddress();
    String City = DatosRandom.address().cityName();
    String State = DatosRandom.address().state();
    String zipCode = DatosRandom.address().zipCode();
    String CellPhone = DatosRandom.phoneNumber().cellPhone();
    String NumberSSN = String.valueOf(DatosRandom.number().numberBetween(000001,999999));
    String UserName = FirstName + "_"+NumberSSN;
    String Password = LastName + NumberSSN;
    String Email = FirstName + "_"  + City+ "@outlook.com";
    String Description = "Hola, deseo contactar con la gerencia de Parabank";



    // Getters and Setter ContactUS
    public String getNameContactUs() {
        return nameContactUs;
    }
    public void setNameContactUs() {this.nameContactUs = CompleteName;}

    public String getEmailContactUs() {
        return emailContactUs;
    }
    public void setEmailContactUs() {
        this.emailContactUs = Email;
    }

    public String getPhoneContactUs() {
        return phoneContactUs;
    }
    public void setPhoneContactUs() {this.phoneContactUs = CellPhone;}

    public String getMessageContactUs() {
        return messageContactUs;
    }
    public void setMessageContactUs() {this.messageContactUs = Description;}

    // Getters and Setter Register
    public String getFirstNameRegister() {
        return firstNameRegister;
    }
    public void setFirstNameRegister() {this.firstNameRegister = FirstName;}

    public String getLastNameRegister() {
        return lastNameRegister;
    }
    public void setLastNameRegister() {
        this.lastNameRegister = LastName;
    }

    public String getAddressRegister() {
        return addressRegister;
    }
    public void setAddressRegister() {
        this.addressRegister = Address;
    }

    public String getCityRegister() {
        return cityRegister;
    }
    public void setCityRegister() {
        this.cityRegister = City;
    }

    public String getStateRegister() {
        return stateRegister;
    }
    public void setStateRegister() {
        this.stateRegister = State;
    }

    public String getZipCodeRegister() {
        return zipCodeRegister;
    }
    public void setZipCodeRegister() {
        this.zipCodeRegister = zipCode;
    }

    public String getPhoneRegister() {
        return phoneRegister;
    }
    public void setPhoneRegister() {
        this.phoneRegister = CellPhone;
    }

    public String getSsnRegister() {
        return ssnRegister;
    }
    public void setSsnRegister() {
        this.ssnRegister = NumberSSN;
    }

    public String getUsernameRegister() {
        return usernameRegister;
    }
    public void setUsernameRegister() {
        this.usernameRegister = UserName;
    }

    public String getPasswordRegister() {
        return passwordRegister;
    }
    public void setPasswordRegister() {
        this.passwordRegister = Password;
    }

    public String getConfirmPassRegister() {
        return confirmPassRegister;
    }
    public void setConfirmPassRegister() {
        this.confirmPassRegister = Password;
    }

    // Getters and SetterLoginUser
    public String getUsernameLogin() {
        return usernameLogin;
    }
    public void setUsernameLogin() {
        this.usernameLogin = UserName;
    }

    public String getPasswordLogin() {
        return passwordLogin;
    }
    public void setPasswordLogin() {
        this.passwordLogin = Password;
    }
}
