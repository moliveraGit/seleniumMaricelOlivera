package PruebaSeleniumJunio;

import clase6.DataProviderGenerator;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PruebaNetflixTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/");

        driver.manage().window().fullscreen();

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        driver.findElement(By.xpath("//*[@class='btn-red btn-accept']")).click();

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void iniciarSesionPageTest(){

        System.out.println("El titulo de la página es: " + driver.getTitle());
        System.out.println("La URL de la página es: " + driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(), "Netflix España - Ver series en línea, ver películas en línea", "Se esperaba otro título");

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        driver.findElement(By.xpath("//*[@href='/login']")).click();

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        System.out.println("El titulo de la página es: " + driver.getTitle());
        System.out.println("La URL de la página es: " + driver.getCurrentUrl());

       Assert.assertEquals(driver.getTitle(), "Netflix", "Se esperaba otro título");

       boolean seEncuentraInicioSesion = false;

       List<WebElement> listH1s = driver.findElements(By.tagName("h1"));

        System.out.println("********** H1 **********");
        for (WebElement h1: listH1s){
            System.out.println("H1 ---> " + h1.getText());

            if(h1.getText().contains("Iniciar sesión")){
                seEncuentraInicioSesion = true;
            }
        }

        Assert.assertTrue(seEncuentraInicioSesion, "Se esperaba el h1 'Iniciar Sesión'");

        WebElement elementIniciarSesión = driver.findElement(By.xpath("//*[@class='fbBtnText']"));

        Assert.assertEquals(elementIniciarSesión.getText(), "Iniciar sesión con FacebooK", "Se esperaba otro título");

    }

    @Test
    public void fakeEmailTest(){

        Faker faker = new Faker();

        driver.findElement(By.name("email")).sendKeys(faker.internet().emailAddress());

        driver.findElement(By.xpath("//*[@class='btn btn-red nmhp-cta nmhp-cta-extra-large btn-none btn-custom']")).click();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        System.out.println("La URL de la página es: " + driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().contains("signup"), "Se esperaba otra URL");

    }

    @Test (dataProvider = "emails", dataProviderClass = DataProviderGeneretiorEmails.class)
    public void dataProviderEmailTest(String anEmail){

        driver.findElement(By.name("email")).sendKeys(anEmail);

        driver.findElement(By.xpath("//*[@class='btn btn-red nmhp-cta nmhp-cta-extra-large btn-none btn-custom']")).click();
    }
}
