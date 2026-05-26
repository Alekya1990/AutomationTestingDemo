package src.com.example;
import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.print.attribute.standard.MediaSize;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
/**
 * Hello world!
 *
 */
public class AutomationTestingDemo 
{
    public static void main( String[] args ) throws InterruptedException
    {
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
      // driver.get("http://localhost/opencart/upload/");
        driver.manage().window().maximize();

        //Navigating to home page
        driver.findElement(By.xpath("//div[@id='PageList2']//a[normalize-space()='Home']")).click();
    
        // Filling the form
         driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Alekya");
         driver.findElement(By.xpath("//input[@id='email']")).sendKeys("alekya30@xyz.com");
         driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
         driver.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys("Hyderabad,Telangana,India");
         driver.findElement(By.xpath("//input[@id='female']")).click();

         // Dropdown handling
        Select drpdown = new Select(driver.findElement(By.xpath("//select[@id='country']")));
        drpdown.selectByVisibleText("India");
        /*Select drpdown1 = new Select(driver.findElement(By.xpath("//select[@id='country']")));
        drpdown1.selectByValue("Australia");
        Select drpdown2 = new Select(driver.findElement(By.xpath("//select[@id='country']")));
        drpdown2.selectByIndex(1);*/

        //getting the page title
        String pageTitle = driver.findElement(By.xpath("//h1[@class='title']")).getText();
        System.out.println("Page Title: " + pageTitle); 

       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
       // driver.close();

        // Alert Handling
        Actions action = new Actions(driver);
        action.click(driver.findElement(By.xpath("//button[@id='alertBtn']"))).perform();
       Thread.sleep(2000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath("//button[@id='confirmBtn']"))).perform();
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();

        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath("//button[@id='promptBtn']"))).perform();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Alekya");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
        System.out.println("Alert Text: " + text);
        if(text.equals("Hello Alekya! How are you today?")) {
            System.out.println("Alert text is correct.");
        } else {
            System.out.println("Alert text is incorrect.");
        }

        //checkbox handling
  
     List<WebElement> checkBox=  driver.findElements(By.xpath("//input[@type='checkbox']"));
          checkBox.get(0).click();
          checkBox.get(2).click();
          checkBox.get(4).click();
       for(int i=0;i< 7;i++) {
       
              if(checkBox.get(i).isSelected()) {

            Thread.sleep(2000);
           checkBox.get(i).click();// deselecting the checkbox
        }
        else
            checkBox.get(i).click(); // selecting the checkbox   
       }


       //scrolling the page
       JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,500)"); // Scroll down by


       //mouse hover action

        Actions action1 = new Actions(driver);
        Thread.sleep(2000);
        action1.moveToElement(driver.findElement(By.xpath("//button[@class='dropbtn']"))).perform();
        WebElement mob=driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
        action1.moveToElement(mob).perform();
        mob.click();

        //keyboard handling
    WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
    field1.clear();
    Thread.sleep(2000);
    field1.sendKeys("Automation Testing");
    WebElement copy=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
    Actions act= new Actions(driver);
   // act.moveToElement(copy).perform();
    act.click(copy).click(copy).perform();

    //drag and drop handling
 Actions act1= new Actions(driver);
    WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
    WebElement target=driver.findElement(By.xpath("//div[@id='droppable']"));
   Thread.sleep(2000);
    act1.dragAndDrop(source, target).perform();
    Thread.sleep(2000);


    //svg element handling
    js.executeScript("window.scrollBy(0,1000)"); // Scroll down by
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@class='svg-container']//*[name()='svg']//*[@fill='green']")).click();
  
//scrolling dropdown
driver.findElement(By.xpath("//input[@id='comboBox']")).click();
WebElement ele=driver.findElement(By.xpath("//div[normalize-space()='Item 44']"));
Thread.sleep(2000);
js.executeScript("arguments[0].scrollIntoView();",ele);
ele.click();


//broken link
WebElement bl=driver.findElement(By.xpath("//a[@class='link'][text()='Errorcode 408']"));

bl.click();
//System.out.println("ErrorCode Text:"+bl.getText());
Thread.sleep(2000);
driver.navigate().back();

//screenshot
js.executeScript("window.scrollBy(0,1500)");
TakesScreenshot ts= (TakesScreenshot) driver;
File sourceFile = ts.getScreenshotAs(OutputType.FILE);
File destinationFile = new File("D:\\DatabaseTesting\\demo\\src\\main\\java\\com\\example\\screenshot.png");
sourceFile.renameTo(destinationFile);

Thread.sleep(2000);
driver.close();


    }

}



