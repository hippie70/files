import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Establecemos la propiedad webdriver.chrome.driver
        //con la ubicación del chromedriver que descargamos
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\maxim\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.buho21.com/alta/");
        Thread.sleep(5000);
        submitForm(driver);
        waitForAlertBanner(driver);
        assertEquals("hippie70gp existe en nuestra base de datos. Por favor, elige otro nickname",getAlertBannerText(driver));
        // driver.quit();
    }
    public static void submitForm (WebDriver driver) throws InterruptedException {
        WebElement usertxt = driver.findElement(By.id("register:j_id105:nickname"));
        usertxt.sendKeys("hippie70gp");
        WebElement pswdtxt = driver.findElement(By.id("register:j_id105:password1"));
        pswdtxt.sendKeys("GestionCalidad99");
        WebElement pswdtxt2 = driver.findElement(By.id("register:j_id105:password2"));
        pswdtxt2.sendKeys("GestionCalidad99");

        WebElement user_mailtxt = driver.findElement(By.id("register:j_id105:email1"));
        user_mailtxt.sendKeys("carlosvidrio99@gmail.com");
        WebElement nombrestxt = driver.findElement(By.id("register:j_id105:firstName"));
        nombrestxt.sendKeys("Juan Carlos");
        WebElement apellidostxt = driver.findElement(By.id("register:j_id105:lastName"));
        apellidostxt.sendKeys("Vidrio Ramírez");
        WebElement radioHombre = driver.findElement(By.id("register:j_id105:sex:0"));
        radioHombre.click();
        Select drpPais = new Select(driver.findElement(By.id("register:j_id105:countries")));
        drpPais.selectByVisibleText("México");
        Thread.sleep(2000);
        Select downProvincia = new Select(driver.findElement(By.id("register:j_id105:regions")));
        downProvincia.selectByVisibleText("Sonora");
        Thread.sleep(2000);
        Select downPoblacion = new Select(driver.findElement(By.id("register:j_id105:cities")));
        downPoblacion.selectByVisibleText("Hermosillo");
        Thread.sleep(2000);
        Select downDay =new Select(driver.findElement(By.id("register:j_id105:day")));
        downDay.selectByVisibleText("9");
        Select downMonth = new Select(driver.findElement(By.id("register:j_id105:month")));
        downMonth.selectByVisibleText("julio");
        Select downYear = new Select(driver.findElement(By.id("register:j_id105:year")));
        downYear.selectByVisibleText("1999");
        WebElement btnTerminar = driver.findElement(By.id("register:j_id105:j_id155"));
        btnTerminar.click();
    }
    public static void waitForAlertBanner(WebDriver driver){
        WebDriverWait wait= new WebDriverWait(driver, 10);
        WebElement alert= wait.until((ExpectedConditions.visibilityOfElementLocated(By.className("rich-message-label"))));
    }
    public static String getAlertBannerText (WebDriver driver){
        return driver.findElement(By.className("rich-message-label")).getText();
    }
}