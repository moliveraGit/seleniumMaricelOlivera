package PruebaSeleniumJunio;

import org.testng.annotations.DataProvider;

public class DataProviderGeneretiorEmails {

    @DataProvider(name = "emails")
    public Object[][] crearDatosEmails() {
        return new Object[][]{
                {"test1@gmail.com"},
                {"test1@gmail.com"},
                {"test1@gmail.com"}
        };
    }
}

