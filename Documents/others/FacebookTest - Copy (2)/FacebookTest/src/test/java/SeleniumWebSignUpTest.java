import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
public class SeleniumWebSignUpTest{
    //import the selenium WebDriver
    private WebDriver driver;
    @Test
    public void start() throws InterruptedException {
        driver = new EdgeDriver();
        //locate where the Edge Driver is
        System.setProperty("webdriver.edge.driver", "resources/msedgedriver");
        // 1. Open your Chrome browser
        driver = new EdgeDriver();
        // 2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        // 3. Maximize the browser
        driver.manage().window().maximize();
        // 4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        // 5. Input username on the username field
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[1]/div[2]/input")).sendKeys("abiola15678");
        // 6. Input email on the email field
        driver.findElement(By.name("user[email]")).sendKeys("testingqa@yopmail9sdf24r3440.com");
        // 7. Locate the password field and Input your password on the username field
        driver.findElement(By.name("user[password]")).sendKeys("Efrdcvgtrsdsdsdsd123");
        // 8. Click on the signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
        // 9. Click on Maegan on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        // 10. Search for an item "Using Python with Selenium" and confirm that it is present
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a")).click();
        // 11. Click on Logout
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a")).click();
    }
    @AfterTest
    public void closeBrowser() {
        // 12. Quit the browser
        driver.quit();
    }
}
