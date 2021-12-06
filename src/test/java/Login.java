import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    WebDriver driver;

    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir").concat("\\src\\test\\resources\\drivers\\chromedriver.exe"));
        this.driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    void envioCredencialesValidas(){
        /**Ingreso a Sing In*/
        WebElement btnSingIn = driver.findElement(By.className("login"));
        btnSingIn.click();
        WebElement tittleSingIn = driver.findElement(By.className("page-heading"));

        /**VALIDACION DE INGRESO A LA PANTALLA DE LOGIN*/
        Assertions.assertEquals("AUTHENTICATION", tittleSingIn.getText());

        WebElement user =driver.findElement(By.xpath("//input[@id='email']"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement btnIniciarSeion =driver.findElement(By.id("SubmitLogin"));

        user.sendKeys("pepito900@gmail.com");
        password.sendKeys("123456");
        btnIniciarSeion.click();

        /** VALIDACION CON EL  NOMBRE DE USUARIO*/
        WebElement userName = driver.findElement(By.xpath("//span[contains(.,'Pepito Perez')]"));
        Assertions.assertEquals("Pepito Perez",userName.getText());

    }

    @AfterEach
    void tearDown() throws  InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }
}
