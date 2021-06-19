package PruebaSeleniumJunio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InterviewQuestionSiteTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://allstq.com/most-popular-testng-interview-questions/");

        driver.manage().window().fullscreen();

        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

    }

    @Test
    public void landingPageTest(){

        System.out.println(driver.findElement(By.xpath("//h1[@class='entry-title']")).getText());

        List<WebElement> listTitulosH3 = driver.findElements(By.tagName("h3"));

        System.out.println("********** TITULOS **********");

        int cont5Titulos = 0;

        for (WebElement tituloH3: listTitulosH3){
            if (cont5Titulos < 5) {
                cont5Titulos++;
                System.out.println("Titulo " + cont5Titulos+ "----> " + tituloH3.getText());
            }
        }

        //System.out.println("El titulo de la página es: " + driver.getTitle());
        //System.out.println("La URL de la página es: " + driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(), "Most popular TestNG interview questions - Software Testing Questions", "Se esperaba otro título");
        Assert.assertEquals(driver.getCurrentUrl(), "https://allstq.com/most-popular-testng-interview-questions/", "Se esperaba otra URL");
        Assert.assertTrue(driver.getCurrentUrl().contains("allstq.com/most-popular-testng-interview-questions"));

        WebElement listMenu = driver.findElement(By.xpath("//*[@class='main-header-menu ast-nav-menu ast-flex ast-justify-content-flex-end  submenu-with-border astra-menu-animation-slide-down ']"));

        boolean haySeleniumJava = false;

            System.out.println("Menú ----> " + listMenu.getText());

            if (listMenu.getText().contains("Selenium") || listMenu.getText().contains("Java")) {
                  haySeleniumJava = true;
            }

            Assert.assertTrue(haySeleniumJava, "Se esperaba encontrar en el menú las opciones Java y Selenium");

    }

    @AfterMethod
    public void close(){
        driver.close();
    }
}
