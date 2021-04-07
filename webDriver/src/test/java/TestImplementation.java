import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class TestImplementation {

    private WebDriver driver;

    @BeforeClass
    public static void setupWebdriverChromeDriver() {
        // Pour chrome
        //System.setProperty("webdriver.chrome.driver", "E:\\Documents\\Cours\\Epsi\\MethodoDesTests\\Selenium\\selenium\\chromedriver.exe");
        // Pour Edge
        //System.setProperty("webdriver.edge.driver", "E:\\Documents\\Cours\\Epsi\\MethodoDesTests\\Selenium\\selenium\\msedgedriver.exe");
    }

    @Before
    public void setup() {
        // Driver pour chrome dans la partie 2
        //driver = new ChromeDriver();


        // Driver distant pour la partie 3 Chrome version :  89.0.4389.114

        String Hub = "http://localhost:4444";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        try {
            driver = new RemoteWebDriver(new URL(Hub), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        // Driver distant pour la partie 3 Microsoft edge version : 89.0.774.68
        String HubEdge = "http://localhost:4444";
        DesiredCapabilities capsEdge = new DesiredCapabilities();
        capsEdge.setBrowserName("MicrosoftEdge");
        try {
            driver = new RemoteWebDriver(new URL(HubEdge), capsEdge);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }



        // Driver pour Edge
	    //driver = new EdgeDriver();
    }

    @After
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }

    }

    @Test
    public void globalTesting() {
        /*
        driver.get("https://www.github.com");
        assertThat(driver.getTitle(), containsString("GitHub"));
        */

        driver.get("https://lambdatest.github.io/sample-todo-app/");
        assertThat(driver.getTitle(), containsString("Sample page"));

        // Cocher les checkbox et check de si elles sont cochées
        driver.findElement(By.name("li1")).click();
        boolean firstIsChecked = driver.findElement(By.name("li1")).isSelected();
        assertEquals(firstIsChecked, true);


        driver.findElement(By.name("li2")).click();
        boolean secondIsChecked = driver.findElement(By.name("li2")).isSelected();
        assertEquals(secondIsChecked, true);

        driver.findElement(By.name("li3")).click();
        boolean thirdIsChecked = driver.findElement(By.name("li3")).isSelected();
        assertEquals(thirdIsChecked, true);

        driver.findElement(By.name("li4")).click();
        boolean fourthIsChecked = driver.findElement(By.name("li4")).isSelected();
        assertEquals(fourthIsChecked, true);

        driver.findElement(By.name("li5")).click();
        boolean fifthIsChecked = driver.findElement(By.name("li5")).isSelected();
        assertEquals(fifthIsChecked, true);


        //Clique dans le text et ecrire une nouvelle entrée et check si elle est ajoutée et non cochée
        WebElement textZone = driver.findElement(By.id("sampletodotext"));
        textZone.sendKeys("new");
        driver.findElement(By.id("addbutton")).click();

        WebElement newElement = driver.findElement(By.name("li6"));
        assertNotNull(newElement);

        boolean newIsUnChecked = driver.findElement(By.name("li6")).isSelected();
        assertEquals(newIsUnChecked, false);



        // Décoche le 5ème élément et chjeck si il est bien décoché
        driver.findElement(By.name("li5")).click();
        boolean fifthIsUnChecked = driver.findElement(By.name("li5")).isSelected();
        assertEquals(fifthIsUnChecked, false);


        // Clique sur les tous les éléments qui ont la classe well et test si checker
        driver.findElement(By.className("well")).click();
        /*
        boolean wellIsChecked = driver.findElement(By.className("well")).isSelected();
        assertEquals(wellIsChecked, true);
        */



    }
}
