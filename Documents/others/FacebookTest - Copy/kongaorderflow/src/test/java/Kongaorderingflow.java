import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


class KongaOrderingTest2 {
    //import the selenium webdriver
    private WebDriver driver;
    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chromedriver.exe", "resources/chromedriver.exe");
        //open your chrome driver
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
    }
    @Test (priority = 1)
    public void url() throws InterruptedException {
        //input your konga url(https://www.konga.com/)
        driver.get("https://www.konga.com/");
        //Test 1. verify the user input the right url
        if(driver.getCurrentUrl().contains("https://www.konga.com/"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
        System.out.println("Wrong Webpage");
        Thread.sleep(5000);
        //maximize the browser
        driver.manage().window().maximize();
        //click on the login/signup button to open login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        //Test 2. verify that when user clicks on the login button, the user is directed to the right login page
        if(driver.getCurrentUrl().contains("https://www.konga.com/account/login?return_url=/"))
            //Pass
            System.out.println("Correct loginpage");
        else
            //Fail
            System.out.println("Wrong loginpage");
        Thread.sleep(5000);
        //input your right username on the username field
        driver.findElement(By.id("username")).sendKeys("olumidefatunbi1@gmail.com");
        //input your password on the password field
        driver.findElement(By.id("password")).sendKeys("Fatunbi@001");
        //click on the login page
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(15000);
    }
    @Test (priority = 2)
    public void clickCompAndAccessories() throws InterruptedException {
        //click computer and accessories
        WebElement CompAndAccessories = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]"));
        CompAndAccessories.click();
        Thread.sleep(20000);
    }
    @Test (priority = 3)
    public void goLaptops() throws InterruptedException {
        //find the laptops
        WebElement Laptop = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span"));
        Laptop.click();
        Thread.sleep(10000);
    }
    @Test (priority = 4)
    public void clickAppleMacBooks() throws InterruptedException {
        //click on apple macbooks
        WebElement AppleMacBooks = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span"));
        AppleMacBooks.click();
        Thread.sleep(10000);
    }
    @Test (priority = 5)
    public void verifyItem() throws InterruptedException {
        // search for an item
        //Click on add an item to the cart for Apple MacBook Pro 2021 With M1 Max - 16" - 1TB SSD - 64GB RAM Unified Memory - Space Grey
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(10000);
    }
    @Test (priority = 6)
    public void clickCartButton() throws InterruptedException {
        // click on my cart button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        Thread.sleep(10000);
    }
    @Test(priority = 7)
    public void clickContinueToCheckout() throws InterruptedException {
        //click checkout on the iframe that displays
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(20000);
    }
    @Test (priority = 8)
    public void clickRegisteredAddress() throws InterruptedException {
        //Select the address by click on your registered address
        driver.findElement(By.id("5995549")).click();
        Thread.sleep(10000);

    }
    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();
    }
    }