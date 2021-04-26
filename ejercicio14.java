package clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;


public class ejercicio14 {

    /*Crear un método con un nombre a seleccionar
    Acceder a Netflix: https://www.netflix.com/uy/
    Mostrar los elementos h1 y h2 que hay en el sitio
    Refrescar la página
    Mostrar el texto de los botones que se encuentran en la página
    Mostrar la cantidad de elementos div que contiene el sitio
    Obtener y mostrar el título de la página
    Mostrar la cantidad de elementos de tipos link*/

     @Test
    public void gitHubPract1Ej1() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netflix.com/uy/");

         List<WebElement> listH1s = driver.findElements(By.tagName("h1"));
         List<WebElement> listH2s = driver.findElements(By.tagName("h2"));


         int cantH1 = 1;

         System.out.println("Elementos H1s: ");
         for (WebElement h1: listH1s){
             System.out.println(cantH1 + ": H1--> " + h1.getText());
             cantH1++;
         }

         int cantH2 = 1;

         System.out.println("Elementos H2s: ");
         for (WebElement h2: listH2s){
             System.out.println(cantH2 + ": H2--> " + h2.getText());
             cantH2++;
         }

         driver.navigate().refresh();

         //Thread.sleep(6000);

         List<WebElement> listButtons = driver.findElements(By.tagName("button"));

         int cantButtons = 1;

         System.out.println(listButtons.size());

         System.out.println("Elementos buttons: ");
         for (WebElement button: listButtons){
             System.out.println(cantButtons + ": Button--> " + button.getText());
             cantButtons++;
         }

         listButtons.get(0).click();

         List<WebElement> listDiv = driver.findElements(By.tagName("div"));
         System.out.println("La página contiene " + listDiv.size() + " elementos DIV");

         String tituloPag = driver.getTitle();
         System.out.println("El Título de la página es: " + tituloPag);

         List<WebElement> listLink = driver.findElements(By.tagName("a"));
         System.out.println("La cantidad de Links en la página es: " + listLink.size());









    }
}
