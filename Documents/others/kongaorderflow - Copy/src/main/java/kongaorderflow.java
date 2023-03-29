import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class kongaorderflow {
    //import selenium webdriver
    private WebDriver driver;
@BeforeTest
    public void setup() throws InterruptedException{
        //locate where the chrome driver is
        System.setProperty("webdriver.chromedriver.exe", "resources/chromedriver.exe");
    //open your Chrome browser
    ChromeOptions option = new ChromeOptions();
    option.addArguments("--remote-allow-origins=*");
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver(option);
    //input your url
    driver.get("https://www.konga.com/");
    Thread.sleep(10000);
    //maximize the browser
    driver.manage().window().maximize();
    //click on the login button to open login page
    driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
    Thread.sleep(10000);
    }
@Test (priority = 0)
    public void positivelogin() throws InterruptedException{
    //Test 1. Verify user can login with valid email and password
    //input your username in the username field
    driver.findElement(By.id("username")).sendKeys("yfatunbi@gmail.com");
    //input your password on the password field
    driver.findElement(By.id("password")).sendKeys("Fatunbi@001");
    //click on the login page
    driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
    Thread.sleep(10000);
    }
@Test(priority = 1)
    public void ClickComputerAndAccessories() throws InterruptedException{
    //Test 2. Verify user can click on computer and accessories
    //from the categories, click on computer and accessories
    driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
    Thread.sleep(10000);
    }
@Test(priority = 2)
public void ClickLaptopSubCategory() throws InterruptedException{
    //Test 2. Verify user can click on Laptop sub category
    //click LaptopSubCategory
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
    Thread.sleep(10000);
}
@Test(priority = 3)
public void ClickAppleMacbooks() throws InterruptedException{
    //Test 3. Verify user can click on Apple Mac Books
    //click ClickAppleMacbooks
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li/a/ul/li[1]/a/label/span")).click();
    Thread.sleep(10000);
}
@Test(priority = 4)
public void Addtocart() throws InterruptedException{
    //Test 4. Verify user can click on cart
   //click Add to cart
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button")).click();
    Thread.sleep(10000);
}
@Test(priority = 5)
public void ProceedtoMycart() throws InterruptedException{
    //Test 5. Verify user can click on proceed to my cart
    //click My cart
    driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
    Thread.sleep(10000);
}
@Test(priority = 6)
public void ClickCheckout() throws InterruptedException{
    //Test 6. Verify user can click on checkout
    //click checkout
    driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
    Thread.sleep(10000);
}
@Test(priority = 7)
public void ClickAddDeliveryAddress() throws InterruptedException{
    //Test 7. Verify user can click add delivery address
    //click Add delivery address
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
    Thread.sleep(10000);
}
@Test(priority = 8)
public void SelectAddress() throws InterruptedException{
    //Test 8. Verify user can select address
   //Select Address
   driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div[2]/form/button")) .click();
    Thread.sleep(10000);
}
@Test(priority = 9)
public void UseThisAddress() throws InterruptedException{
    //Test 9. Verify user can use the selected address
    //Click Use this address
  driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
   Thread.sleep(10000);
}

@Test(priority = 10)
public void ClickPayNow() throws InterruptedException{
    //Test 10. Verify user can click on pay now
    //Click Pay Now
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
    Thread.sleep(10000);
}
@Test(priority = 11)
public void ContinueToPayment() throws InterruptedException{
    //Test 11. Verify user can click on continue to payment
    //Continue to payment
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
    Thread.sleep(10000);
}
@Test(priority = 12)
public void LocateIframe() throws InterruptedException{
    //Test 12. Verify user can locate iframe
    //Locate Iframe
    driver.findElement(By.id("kpg-frame-component"));
    //Switch to Iframe
    driver.switchTo().frame("kpg-frame-component");
    Thread.sleep(10000);
}
@Test(priority = 13)
public void ClickCard() throws InterruptedException{
    //Test 13. Verify user can click on card option
    //Click Card
    driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button/div/span[1]")).click();
    Thread.sleep(10000);
}
@Test(priority = 14)
public void InvalidCardNumber() throws InterruptedException{
    //Test 14. Verify user can enter invalid card No and click pay now
    //invalid card number
    driver.findElement(By.id("card-number")).sendKeys("539923705");
    driver.findElement(By.id("expiry")).sendKeys("1420");
    driver.findElement(By.id("cvv")).sendKeys("230");
    //click Pay Now
    driver.findElement(By.id("validateCardForm")).click();
    Thread.sleep(10000);

    //Print out invalid card number
    String error = driver.findElement(By.id("card-number_unhappy")).getText();
    System.out.println(error);

    //To close Iframe
    driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
    Thread.sleep(10000);

}
@AfterTest
    public void Closebrowser() {
    //To Quit Browser
    driver.quit();
}
}
