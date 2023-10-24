
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class NopCommerce01
{
    protected static WebDriver driver;



    public static String timeStamp()
    {

        String timeStamp = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
        return timeStamp;

    }

    public static void  OpenBrowser()
    {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");

        driver=new ChromeDriver();
        //instantiate chrome driver class

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //waits for 10 secondsdriver.manage().timeouts().wait(10);

        driver.manage().window().fullscreen();
        //open windows in to full screen

        driver.get("https://demo.nopcommerce.com/");
        //launches the website
    }


public static void waitForClickable(int second, By by)
{


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
    wait.until(ExpectedConditions.elementToBeClickable(by));


}

public static void waitForVisible(int second, By by)
{
    WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(second));
    wait1.until(ExpectedConditions.visibilityOfElementLocated(by));

}
    public static void waitForInvisible(int second,By by)
    {
        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(second));
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public static void waitForUrlToBe(int second, String url)
    {

        WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(second));
        wait3.until(ExpectedConditions.urlToBe(url));

    }
    public static void waitForDisappear(int second, By by)
    {

        WebDriverWait wait4 = new WebDriverWait (driver, Duration.ofSeconds(second));
        wait4.until(ExpectedConditions.not(presenceOfElementLocated(by)));
    }

public static void Click(By by)
{

    driver.findElement(by).click();

}

public static void TypeKey(By by, String name)
{
    driver.findElement(by).sendKeys(name);

}

public static String GetText(By by)
{


    String getResult = driver.findElement(by).getText();
    return getResult;

}
public static void Birthday(By by,String Text)
{
    Select selectDay = new Select(driver.findElement(by));
    selectDay.selectByVisibleText(Text);

}


    public static void main(String[] args)

    {
     OpenBrowser();
     waitForClickable(5,By.linkText("Register")); // wait for register button to be clickable
     Click((By.linkText("Register")));
     waitForInvisible(2,By.xpath("//img[@class=\"nivo-main-image\"]")); // wait for image to be invisiblewaitForUrlToBe(2,"https://demo.nopcommerce.com/register?returnUrl=%2F");
     waitForVisible(5,By.id("gender-male")); // wait for gender to be visible
     Click(By.id("gender-male"));
        // used id to locate gender as male

     TypeKey(By.id("FirstName"),"Rajesh");
     //used id to first name

     TypeKey(By.id("LastName"),"Patel");

     //used id to locate last name

     Birthday(By.name("DateOfBirthDay"),"27");
     Birthday(By.name("DateOfBirthMonth"),"January");
     Birthday(By.name("DateOfBirthYear"),"1985");
     String email = "Krishna" + timeStamp() + "@hotmail.com";
     System.out.println(email);
     TypeKey(By.id("Email"),email);
     TypeKey(By.id("Company"),"Rk ltd");
     Click(By.id("Newsletter"));
     TypeKey(By.id("Password"),"123@456!");
     TypeKey(By.id("ConfirmPassword"),"123@456!");
     Click(By.xpath("//button[@name=\"register-button\"]"));
  //   waitForDisappear(2,By.xpath("//button[@name=\"register-button\"]")); //not seems to work after many attempts

     System.out.println( GetText(By.className("result")));








    driver.close();




    }


    }






