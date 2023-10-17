import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NopCommerce01
{
    protected static WebDriver driver;


    public static void main(String[] args)

    {

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");

        driver=new ChromeDriver(); //instantiate chrome driver class
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //waits for 10 seconds
        driver.manage().window().fullscreen(); //open windows in to full screen
        driver.get("https://demo.nopcommerce.com/"); //launches the website


        driver.findElement(By.linkText("Register")).click(); ///used . linktext to locate register and clicks on register
        driver.findElement(By.id("gender-male")).click();   // used id to locate gender as male
        driver.findElement(By.id("FirstName")).sendKeys("Rajesh");   //used id to first name
        driver.findElement(By.id("LastName")).sendKeys("Patel");     //used id to locate last name
        driver.findElement(By.xpath("//select[@  name=\"DateOfBirthDay\"]")).sendKeys("27");//used x path to locate date of birth
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("January");   //used name to locate month of birthday
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1985");    //used name to locate year of birthday
        driver.findElement(By.id("Email")).sendKeys("rap@hotmail.co.uk");    //used id to locate email
        driver.findElement(By.id("Company")).sendKeys("Rk ltd");    //used id to locate company
        driver.findElement(By.id("Newsletter")).click();    //used id to locate news letter
        driver.findElement(By.id("Password")).sendKeys("123@456!");    //used id to locate password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123@456!");  //used id to locate confirm password
        driver.findElement(By.xpath("//button[@name=\"register-button\"]")).click();   //used xpath  to register





       driver.close();




    }



















}


